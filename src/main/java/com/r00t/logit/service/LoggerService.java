package com.r00t.logit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r00t.logit.aspect.log.LoggerRules;
import com.r00t.logit.model.DynamicLoggingConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

// DeleteProfileAttribute - Preprod üzerinde load test yapılıcak
// heath map olayına da bakılacak (kütüphane (jamon) ile 2cil olarak bakılıcak)
// öncelik log olayında

@Slf4j
@Service
@EnableAsync
public class LoggerService {
    private static final String REQUEST_LOG_FORMAT = "Request: {} {} from {}";
    private static final String REQUEST_LOG_WITH_ARGS_FORMAT = "Request: {} {} from {} with {}";

    private static final String RESPONSE_LOG_FORMAT = "Response: {} {} to {}";
    private static final String RESPONSE_LOG_WITH_ARGS_FORMAT = "Response: {} {} to {} with {}";

    private final ApplicationService applicationService;
    private final ObjectMapper mapper;

    public LoggerService(ApplicationService applicationService) {
        this.applicationService = applicationService;
        this.mapper = new ObjectMapper();
    }

    // ================================================================================================================

    @Async
    public void request(ProceedingJoinPoint joinPoint) {
        LoggerRules rules = getRules(joinPoint);
        if (!rules.logBefore())
            return;

        HttpServletRequest request = getServletRequest();
        if (rules.excludeArgs()) {
            log.info(REQUEST_LOG_FORMAT,
                     request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
        } else {
            String argsText = "{}";
            try {
                argsText = argsToJson(joinPoint.getArgs(), rules.argsCharLimit());
            } catch (JsonProcessingException e) {
                argsText = e.getMessage();
            } finally {
                log.info(REQUEST_LOG_WITH_ARGS_FORMAT,
                         request.getMethod(), request.getRequestURI(), request.getRemoteAddr(), argsText);
            }
        }
    }

    @Async
    public void response(ProceedingJoinPoint joinPoint, Object value) {
        LoggerRules rules = getRules(joinPoint);
        if (!rules.logAfter())
            return;

        HttpServletRequest request = getServletRequest();
        if (rules.excludeResponseArgs()) {
            log.info(RESPONSE_LOG_FORMAT,
                     request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
        } else {
            String argsText = "{}";
            try {
                argsText = argsToJson(new Object[]{value}, rules.argsCharLimit());
            } catch (JsonProcessingException e) {
                argsText = e.getMessage();
            } finally {
                log.info(RESPONSE_LOG_WITH_ARGS_FORMAT,
                         request.getMethod(), request.getRequestURI(), request.getRemoteAddr(), argsText);
            }
        }
    }

    // ================================================================================================================

    private LoggerRules getRules(ProceedingJoinPoint joinPoint) {
        LoggerRules rules = getDeclaredRules(joinPoint);
        if (rules.disableDynamicLogging())
            return rules;
        DynamicLoggingConfig config = getDynamicLoggerConfig(joinPoint);
        if (config != null)
            rules = new LoggerRules.DefaultRules()
                    .overrideFrom(config);
        return rules;
    }

    private LoggerRules getDeclaredRules(ProceedingJoinPoint joinPoint) {
        LoggerRules rules = null;

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        rules = method.getDeclaredAnnotation(LoggerRules.class);
        if (rules != null)
            return rules;

        Class<?> clazz = joinPoint.getTarget().getClass();
        rules = clazz.getDeclaredAnnotation(LoggerRules.class);
        if (rules != null)
            return rules;

        return new LoggerRules.DefaultRules();
    }

    private DynamicLoggingConfig getDynamicLoggerConfig(ProceedingJoinPoint joinPoint) {
        String clazzName = joinPoint.getTarget().getClass()
                                    .getSimpleName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod()
                                                                        .getName();

        DynamicLoggingConfig config = applicationService.getDynamicLoggingConfig(clazzName, methodName);
        return config != null
               ? config
               : applicationService.getDynamicLoggingConfig(clazzName);
    }

    private String argsToJson(Object[] args, int lengthLimit)
    throws JsonProcessingException {
        if (args == null)
            return "{empty}";
        if (args.length == 0)
            return "{empty}";

        String json = mapper.writeValueAsString(
                Arrays.stream(args)
                      .collect(Collectors.toMap(
                              o -> o.getClass().getName(),
                              Function.identity()
                      ))
        );

        if (lengthLimit != -1)
            if (json.length() > lengthLimit)
                return json.substring(0, lengthLimit) + "...";
        return json;
    }

    // ================================================================================================================

    private HttpServletRequest getServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
    }
}

package com.r00t.logit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r00t.logit.aspect.log.LoggerRules;
import com.r00t.logit.model.DynamicLoggingConfig;
import com.r00t.logit.model.SessionAttributes;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.IntStream;

// DeleteProfileAttribute - Preprod üzerinde load test yapılıcak
// heath map olayına da bakılacak (kütüphane (jamon) ile 2cil olarak bakılıcak)
// öncelik log olayında

@Slf4j
@Service
@EnableAsync
public class LoggerService {
    private static final String REQUEST_LOG_FORMAT = "[ Request] [{}] {} from {}";
    private static final String REQUEST_LOG_WITH_ARGS_FORMAT = "[ Request] [{}] {} from {} with {}";

    private static final String RESPONSE_LOG_FORMAT = "[Response] [{}] {} to {}";
    private static final String RESPONSE_LOG_WITH_ARGS_FORMAT = "[Response] [{}] {} to {} with {}";

    private final ApplicationService applicationService;
    private final ObjectMapper mapper;

    public LoggerService(ApplicationService applicationService) {
        this.applicationService = applicationService;
        this.mapper = new ObjectMapper();
    }

    // ================================================================================================================

    @Async
    public void request(ProceedingJoinPoint joinPoint, SessionAttributes attributes) {
        LoggerRules rules = getRules(joinPoint);
        if (!rules.logBefore())
            return;
        if (rules.excludeBody()) {
            log.info(REQUEST_LOG_FORMAT,
                     attributes.getMethod(), attributes.getRequestURI(), attributes.getRemoteAddr());
        } else {
            Object body = getAnnotatedArg(joinPoint, RequestBody.class);
            String bodyText = objectToJson(body, rules.bodiesCharLimit());
            log.info(REQUEST_LOG_WITH_ARGS_FORMAT,
                     attributes.getMethod(), attributes.getRequestURI(), attributes.getRemoteAddr(), bodyText);
        }
    }

    @Async
    public void response(ProceedingJoinPoint joinPoint, SessionAttributes attributes, Object value) {
        LoggerRules rules = getRules(joinPoint);
        if (!rules.logAfter())
            return;
        if (rules.excludeResponseBody()) {
            log.info(RESPONSE_LOG_FORMAT,
                     attributes.getMethod(), attributes.getRequestURI(), attributes.getRemoteAddr());
        } else {
            if (value instanceof ResponseEntity<?>)
                value = ((ResponseEntity<?>) value).getBody();
            String bodyText = objectToJson(value, rules.bodiesCharLimit());
            log.info(RESPONSE_LOG_WITH_ARGS_FORMAT,
                     attributes.getMethod(), attributes.getRequestURI(), attributes.getRemoteAddr(), bodyText);
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

    private Object getAnnotatedArg(ProceedingJoinPoint joinPoint, Class<? extends Annotation> annotation) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Parameter[] parameters = method.getParameters();

        int parameterIndex = IntStream
                .range(0, parameters.length)
                .parallel()
                .filter(value -> parameters[value].getDeclaredAnnotation(RequestBody.class) != null)
                .findFirst()
                .orElse(-1);
        return parameterIndex != -1
               ? joinPoint.getArgs()[parameterIndex]
               : null;
    }

    private String objectToJson(Object o, int lengthLimit) {
        String json = "";
        try {
            if (o == null)
                return "{null}";
            json = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        } finally {
            if (lengthLimit != -1)
                if (json.length() > lengthLimit)
                    json = json.substring(0, lengthLimit) + "...}";
        }
        return json;
    }
}

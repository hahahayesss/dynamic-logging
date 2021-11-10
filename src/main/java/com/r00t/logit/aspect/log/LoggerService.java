package com.r00t.logit.aspect.log;

import com.r00t.logit.service.ApplicationService;
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

@Slf4j
@Service
@EnableAsync
public class LoggerService {
    private final ApplicationService applicationService;

    public LoggerService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // ================================================================================================================

    @Async
    public void request(ProceedingJoinPoint proceedingJoinPoint) {
        LoggerRules rules = getRules(proceedingJoinPoint);
        if (!rules.logBefore())
            return;
        System.out.println("Log before");
    }

    @Async
    public void response(ProceedingJoinPoint proceedingJoinPoint, Object value) {
        LoggerRules rules = getRules(proceedingJoinPoint);
        if (!rules.logAfter())
            return;
        System.out.println("Log after");
    }

    // DeleteProfileAttribute - Preprod üzerinde load test yapılıcak
    // heath map olayına da bakılacak (kütüphane (jamon) ile 2cil olarak bakılıcak)
    // öncelik log olayında

    // ================================================================================================================

    private LoggerRules getRules(ProceedingJoinPoint proceedingJoinPoint) {
        Class<?> clazz = proceedingJoinPoint.getTarget().getClass();
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        LoggerRules loggerRules = method.getDeclaredAnnotation(LoggerRules.class) != null
                ? method.getDeclaredAnnotation(LoggerRules.class)
                : clazz.getDeclaredAnnotation(LoggerRules.class);
        if (loggerRules == null)
            loggerRules = LoggerRules.DefaultRules.INSTANCE;
        if (loggerRules.disableDynamicLogging())
            return loggerRules;

        DynamicLoggingConfig dynamicLoggingConfig = applicationService.cacheable()
                .getDynamicLoggingConfig();
    }

    private HttpServletRequest getServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
    }
}

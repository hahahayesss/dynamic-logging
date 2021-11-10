package com.r00t.logit.aspect.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
    private final LoggerService loggerService;

    public LoggerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    // ================================================================================================================

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMappings() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getRequestMappings() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PatchMapping)")
    public void patchRequestMappings() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postRequestMappings() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putRequestMappings() {
    }

    // ================================================================================================================

    @Around("requestMappings() || " +
            "getRequestMappings() || " +
            "patchRequestMappings() || " +
            "postRequestMappings() || " +
            "putRequestMappings()")
    public Object temp(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info(
                "{} {} from {}",
                "request.getMethod()",
                "request.getRequestURI()",
                "request.getRemoteAddr()",
                "request.getHeader(\"user-id\")"
        );

        loggerService.request(proceedingJoinPoint);
        Object value = proceedingJoinPoint.proceed();
        loggerService.response(proceedingJoinPoint, value);
        return value;
    }
}

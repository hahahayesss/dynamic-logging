package com.r00t.logit.aspect.extra;

import com.r00t.logit.model.SessionHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.function.Predicate;

@Slf4j
@Aspect
@Component
public class ExtrasAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controllerMethods() {
    }

    @Pointcut("execution(* *(.., com.r00t.logit.model.SessionHolder, ..))")
    public void methodsWithSessionHolder() {
    }

    @Pointcut("execution(* *(.., @com.r00t.logit.aspect.extra.AdminUser (*), ..))")
    public void methodsWithAdminUser() {
    }

    @Pointcut("execution(* *(.., @com.r00t.logit.aspect.extra.AppKey (*), ..))")
    public void methodWithAppKey() {
    }

    // ================================================================================================================

    @Around("controllerMethods() && methodsWithSessionHolder()")
    public Object replaceSessionHolder(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        int parameterIndex = findIndexByType(method, SessionHolder.class);
        if (parameterIndex == -1) {
            log.error("Somethings went wrong");
            return proceedingJoinPoint.proceed();
        }

        SessionHolder sessionHolder = new SessionHolder();
        sessionHolder.setAdminUser(new Object());
        sessionHolder.setAppKey("APPPPPPPPKEEEEEYYYYYYYY");

        Object[] args = proceedingJoinPoint.getArgs();
        args[parameterIndex] = sessionHolder;
        return proceedingJoinPoint.proceed(args);
    }

    @Around("controllerMethods() && methodsWithAdminUser()")
    public Object replaceAdminUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        int parameterIndex = findIndexByAnnotation(method, AdminUser.class);
        if (parameterIndex == -1) {
            log.error("Somethings went wrong");
            return proceedingJoinPoint.proceed();
        }

        Object[] args = proceedingJoinPoint.getArgs();
        args[parameterIndex] = new Object();
        return proceedingJoinPoint.proceed(args);
    }

    @Around("controllerMethods() && methodWithAppKey()")
    public Object replaceAppKey(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        int parameterIndex = findIndexByAnnotation(method, AppKey.class);
        if (parameterIndex == -1) {
            log.error("Somethings went wrong");
            return proceedingJoinPoint.proceed();
        }

        String appKey = "APPPPPPPPKEEEEEYYYYYYYY";

        Object[] args = proceedingJoinPoint.getArgs();
        args[parameterIndex] = appKey;
        return proceedingJoinPoint.proceed(args);
    }

    // ================================================================================================================

    private int findIndexByAnnotation(Method method, Class<? extends Annotation> type) {
        return findIndex(method, parameter ->
                parameter.getAnnotation(type) != null);
    }

    private int findIndexByType(Method method, Class<?> type) {
        return findIndex(method, parameter ->
                parameter.getType().equals(type));
    }

    private int findIndex(Method method, Predicate<Parameter> condition) {
        Parameter[] parameters = method.getParameters();
        for (int x = 0; x < parameters.length; x++)
            if (condition.test(parameters[x]))
                return x;
        return -1;
    }
}

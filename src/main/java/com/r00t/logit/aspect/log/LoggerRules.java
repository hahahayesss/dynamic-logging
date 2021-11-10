package com.r00t.logit.aspect.log;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerRules {

    boolean logBefore() default true;

    boolean logAfter() default true;

    boolean excludeArgs() default true;

    boolean excludeResponseArgs() default true;

    boolean disableDynamicLogging() default false;

    @SuppressWarnings("all")
    static class DefaultRules implements LoggerRules {
        public static final DefaultRules INSTANCE = new DefaultRules();

        private DefaultRules() {
        }

        @Override
        public boolean logBefore() {
            return true;
        }

        @Override
        public boolean logAfter() {
            return true;
        }

        @Override
        public boolean excludeArgs() {
            return true;
        }

        @Override
        public boolean excludeResponseArgs() {
            return true;
        }

        @Override
        public boolean disableDynamicLogging() {
            return false;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return LoggerRules.class;
        }
    }
}

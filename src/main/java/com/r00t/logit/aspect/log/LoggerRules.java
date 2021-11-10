package com.r00t.logit.aspect.log;

import com.r00t.logit.model.DynamicLoggingConfig;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerRules {

    boolean logBefore() default true;

    boolean excludeArgs() default true;

    boolean logAfter() default true;

    boolean excludeResponseArgs() default true;

    int argsCharLimit() default -1;

    boolean disableDynamicLogging() default false;

    @SuppressWarnings("all")
    static class DefaultRules implements LoggerRules {
        private boolean logBefore;
        private boolean excludeArgs;
        private boolean logAfter;
        private boolean excludeResponseArgs;
        private int argsCharLimit;
        private boolean disableDynamicLogging;

        public DefaultRules() {
            this.logBefore = true;
            this.excludeArgs = true;
            this.logAfter = true;
            this.excludeResponseArgs = true;
            this.argsCharLimit = -1;
            this.disableDynamicLogging = false;
        }

        public DefaultRules overrideFrom(DynamicLoggingConfig config) {
            this.logBefore = config.isLogBefore();
            this.excludeArgs = config.isExcludeArgs();
            this.logAfter = config.isLogAfter();
            this.excludeResponseArgs = config.isExcludeResponseArgs();
            this.argsCharLimit = config.getArgsCharLimit();
            return this;
        }

        @Override
        public boolean logBefore() {
            return this.logBefore;
        }

        @Override
        public boolean excludeArgs() {
            return this.excludeArgs;
        }

        @Override
        public boolean logAfter() {
            return this.logAfter;
        }

        @Override
        public boolean excludeResponseArgs() {
            return this.excludeResponseArgs;
        }

        @Override
        public int argsCharLimit() {
            return this.argsCharLimit;
        }

        @Override
        public boolean disableDynamicLogging() {
            return this.disableDynamicLogging;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return LoggerRules.class;
        }
    }
}

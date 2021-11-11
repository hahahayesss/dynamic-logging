package com.r00t.logit.aspect.log;

import com.r00t.logit.model.DynamicLoggingConfig;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerRules {

    boolean logBefore() default true;

    boolean excludeBody() default true;

    boolean logAfter() default true;

    boolean excludeResponseBody() default true;

    int bodiesCharLimit() default -1;

    boolean disableDynamicLogging() default false;

    @SuppressWarnings("all")
    static class DefaultRules implements LoggerRules {
        private boolean logBefore;
        private boolean excludeBody;
        private boolean logAfter;
        private boolean excludeResponseBody;
        private int bodiesCharLimit;
        private boolean disableDynamicLogging;

        public DefaultRules() {
            this.logBefore = true;
            this.excludeBody = true;
            this.logAfter = true;
            this.excludeResponseBody = true;
            this.bodiesCharLimit = -1;
            this.disableDynamicLogging = false;
        }

        public DefaultRules overrideFrom(DynamicLoggingConfig config) {
            this.logBefore = config.isLogBefore();
            this.excludeBody = config.isExcludeBody();
            this.logAfter = config.isLogAfter();
            this.excludeResponseBody = config.isExcludeResponseBody();
            this.bodiesCharLimit = config.getBodiesCharLimit();
            return this;
        }

        @Override
        public boolean logBefore() {
            return this.logBefore;
        }

        @Override
        public boolean excludeBody() {
            return this.excludeBody;
        }

        @Override
        public boolean logAfter() {
            return this.logAfter;
        }

        @Override
        public boolean excludeResponseBody() {
            return this.excludeResponseBody;
        }

        @Override
        public int bodiesCharLimit() {
            return this.bodiesCharLimit;
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

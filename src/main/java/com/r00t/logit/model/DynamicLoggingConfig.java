package com.r00t.logit.model;

import lombok.Data;

@Data
public class DynamicLoggingConfig {
    private String id;
    private String className;
    private String methodName;

    private boolean logBefore;
    private boolean excludeBody;
    private boolean logAfter;
    private boolean excludeResponseBody;
    private int bodiesCharLimit;
}

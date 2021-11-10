package com.r00t.logit.model;

import lombok.Data;

@Data
public class DynamicLoggingConfig {
    private boolean logBefore;
    private boolean excludeArgs;
    private boolean logAfter;
    private boolean excludeResponseArgs;
    private int argsCharLimit;
}

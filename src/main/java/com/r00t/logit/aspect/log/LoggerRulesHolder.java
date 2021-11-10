package com.r00t.logit.aspect.log;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoggerRulesHolder {
    private String name;
    private LoggerRules rules;
    private List<LoggerRulesHolder> subRules;
}

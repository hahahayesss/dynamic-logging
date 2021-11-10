package com.r00t.logit.service;

import com.r00t.logit.aspect.log.DynamicLoggingConfig;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public ApplicationService cacheable() {
        return this;
    }

    public DynamicLoggingConfig getDynamicLoggingConfig() {
        return null;
    }
}

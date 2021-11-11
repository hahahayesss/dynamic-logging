package com.r00t.logit.service;

import com.r00t.logit.model.DynamicLoggingConfig;
import com.r00t.logit.repository.DynamicLoggerConfigRepository;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;

@Service
public class ApplicationService {
    private final DynamicLoggerConfigRepository repository;

    public ApplicationService(DynamicLoggerConfigRepository repository) {
        this.repository = repository;
    }

    public DynamicLoggingConfig getDynamicLoggingConfig(String className) {
        return getDynamicLoggingConfig(className, null);
    }

    public DynamicLoggingConfig getDynamicLoggingConfig(String className, String methodName) {
        try {
            return repository.findByClassNameAndMethodName(className, methodName)
                             .orElseThrow(() -> new PropertyNotFoundException("There is no dynamic config"));
        } catch (IncorrectResultSizeDataAccessException | PropertyNotFoundException e) {
            return null;
        }
    }
}

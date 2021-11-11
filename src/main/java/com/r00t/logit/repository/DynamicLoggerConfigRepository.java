package com.r00t.logit.repository;

import com.r00t.logit.model.DynamicLoggingConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DynamicLoggerConfigRepository extends MongoRepository<DynamicLoggingConfig, String> {

    Optional<DynamicLoggingConfig> findByClassNameAndMethodName(String className, String methodName);
}

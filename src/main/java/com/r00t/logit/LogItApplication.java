package com.r00t.logit;

import com.r00t.logit.model.DynamicLoggingConfig;
import com.r00t.logit.repository.DynamicLoggerConfigRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogItApplication {

    @Bean
    public CommandLineRunner temp(DynamicLoggerConfigRepository repository) {
        return args -> {
            DynamicLoggingConfig config = new DynamicLoggingConfig();
            config.setClassName("TempController");
            config.setMethodName("temp");

            config.setLogBefore(true);
            config.setExcludeBody(false);

            config.setLogAfter(true);
            config.setExcludeResponseBody(false);

            config.setBodiesCharLimit(-1);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LogItApplication.class, args);
    }
}

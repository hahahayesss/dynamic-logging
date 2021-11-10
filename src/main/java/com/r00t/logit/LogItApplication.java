package com.r00t.logit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogItApplication {

    @Bean
    public CommandLineRunner temp() {
        return args -> {
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LogItApplication.class, args);
    }
}

package com.demo.project58.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {
    final String baseURI = "https://httpbin.org/";

    @Bean
    RestClient restClient() {
        return RestClient.create(baseURI);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.ofNullable("auditor");
    }
}

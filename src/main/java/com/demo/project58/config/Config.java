package com.demo.project58.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {
    final String baseURI = "https://httpbin.org/";

    @Bean
    RestClient restClient() {
        return RestClient.create(baseURI);
    }
}

package com.demo.project58;

import com.demo.project58.pojo.Customer;
import com.demo.project58.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner onStart(CustomerService customerService) {
        return (args) -> {
            customerService.save(Customer.builder()
                    .name("jack")
                    .age(50)
                    .build());
        };
    }

}

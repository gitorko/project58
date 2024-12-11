package com.demo.project58.controller;

import com.demo.project58.repository.CustomerRepository;
import com.demo.project58.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.web.client.RestClient;

@WebMvcTest(controllers = CustomerController.class)
@Import(CustomerService.class)
class WebContextControllerTest3 {

    @Autowired
    MockMvcTester mockMvcTester;

    @MockitoBean
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @MockitoBean
    RestClient restClient;

    @Test
    public void test_greet() throws Exception {
        String name = "jack";
        String expectedGreeting = "Hello jack";

        // Act & Assert
        mockMvcTester.get()
                .uri("/customer/greet/" + name)
                .exchange()
                .assertThat()
                .hasStatus(HttpStatus.OK)
                .hasBodyTextEqualTo(expectedGreeting);
    }
}
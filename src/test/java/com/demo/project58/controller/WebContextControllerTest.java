package com.demo.project58.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demo.project58.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClient;

@WebMvcTest(controllers = {CustomerController.class})
class WebContextControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CustomerService customerService;

    @MockitoBean
    RestClient restClient;

    @Test
    public void test_greet() throws Exception {
        String name = "jack";
        String expectedGreeting = "Hello, jack!";
        when(customerService.greet(name)).thenReturn(expectedGreeting);

        // Act & Assert
        mockMvc.perform(get("/customer/greet/" + name))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedGreeting));

        // Verify the service was called correctly
        Mockito.verify(customerService).greet(name);
    }
}
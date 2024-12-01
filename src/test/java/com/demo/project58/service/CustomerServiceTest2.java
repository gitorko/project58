package com.demo.project58.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.demo.project58.pojo.Customer;
import com.demo.project58.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestClient;

//Using @SpringBootTest with slicing to load only needed classes
@SpringBootTest(classes = {CustomerService.class})
@Import(CustomerService.class)
class CustomerServiceTest2 {

    @Autowired
    CustomerService customerService;

    @MockitoBean
    CustomerRepository customerRepository;

    @MockitoBean
    private RestClient restClient;

    @Test
    void test_save() {
        // Arrange
        UUID id = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("John Doe");
        customer.setAge(40);

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        // Act
        Customer savedCustomer = customerService.save(customer);

        // Assert
        Mockito.verify(customerRepository, Mockito.times(1)).save(any(Customer.class));
        assertEquals(id, savedCustomer.getId());
        assertEquals("John Doe", savedCustomer.getName());
        assertEquals(40, savedCustomer.getAge());
    }

    @Test
    void test_findAll() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(UUID.randomUUID(), "Jack", 40));
        customers.add(new Customer(UUID.randomUUID(), "Joe", 30));
        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> resultCustomers = customerService.findAll();

        //assertj validation
        assertThat(resultCustomers).hasSize(2)
                .filteredOn(c -> c.getAge() >= 40)
                .hasSize(1)
                .extracting(Customer::getName)
                .containsExactly("Jack");

    }
}
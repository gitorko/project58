package com.demo.project58.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import com.demo.project58.config.TestContainerConfig;
import com.demo.project58.pojo.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest extends TestContainerConfig {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void test_save() {
        UUID id = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setAge(40);

        // Act
        Customer savedCustomer = customerRepository.save(customer);

        // Assert
        assertNotNull(id);
        assertEquals("John Doe", savedCustomer.getName());
        assertEquals(40, savedCustomer.getAge());
    }

}

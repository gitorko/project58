package com.demo.project58.service;

import java.util.List;
import java.util.UUID;

import com.demo.project58.pojo.Customer;
import com.demo.project58.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    public List<Customer> search(Customer customer) {
        return customerRepository.findAll(Example.of(customer));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(UUID id) {
        var customer = customerRepository.findById(id).orElse(null);
        log.info("Customer: {}", customer.getName());
        return customer;
    }

    public void deleteById(UUID id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> findByNameAndAge(String name, Integer age) {
        return customerRepository.findByNameAndAge(name, age);
    }

    public Page<Customer> findAll(PageRequest pageRequest) {
        return customerRepository.findAll(pageRequest);
    }
}

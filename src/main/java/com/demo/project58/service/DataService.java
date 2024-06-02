package com.demo.project58.service;

import java.util.List;

import com.demo.project58.pojo.Customer;
import com.demo.project58.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> search(Customer customer) {
        return customerRepository.findAll(Example.of(customer));
    }

}

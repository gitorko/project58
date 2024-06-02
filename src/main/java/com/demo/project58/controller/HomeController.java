package com.demo.project58.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.demo.project58.pojo.Customer;
import com.demo.project58.repository.CustomerRepository;
import com.demo.project58.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class HomeController {

    final CustomerRepository customerRepository;
    final DataService dataService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/all")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable UUID id) {
        return customerRepository.findById(id);
    }

    @PutMapping(value = "/update")
    public Customer update(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/find")
    public List<Customer> find(@RequestParam String name, @RequestParam Integer age) {
        return customerRepository.findByNameAndAge(name, age);
    }

    @GetMapping("/page")
    public Page<Customer> findPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return customerRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/search")
    public List<Customer> search(Customer customer) {
        return dataService.search(customer);
    }
}

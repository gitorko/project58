package com.demo.project58.controller;

import java.util.List;
import java.util.UUID;

import com.demo.project58.pojo.Customer;
import com.demo.project58.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    final CustomerService customerService;
    final RestClient restClient;

    @PostMapping("/save")
    @Transactional
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/all")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable UUID id) {
        return customerService.findById(id);
    }

    @PutMapping(value = "/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        customerService.deleteById(id);
    }

    @GetMapping("/find")
    public List<Customer> find(@RequestParam String name, @RequestParam Integer age) {
        return customerService.findByNameAndAge(name, age);
    }

    @GetMapping("/page")
    public Page<Customer> findPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return customerService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/search")
    public List<Customer> search(Customer customer) {
        return customerService.search(customer);
    }

    @GetMapping("/block/{seconds}")
    public String block(@PathVariable Integer seconds) {
        ResponseEntity<Void> result = restClient.get()
                .uri("/delay/" + seconds)
                .retrieve()
                .toBodilessEntity();

        log.info("{} on {}", result.getStatusCode(), Thread.currentThread());
        return Thread.currentThread().toString();
    }
}

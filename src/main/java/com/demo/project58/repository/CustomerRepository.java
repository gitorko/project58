package com.demo.project58.repository;

import java.util.List;
import java.util.UUID;

import com.demo.project58.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("select e from Customer e where e.name = ?1 and e.age = ?2")
    List<Customer> findByNameAndAge(String name, Integer age);

}

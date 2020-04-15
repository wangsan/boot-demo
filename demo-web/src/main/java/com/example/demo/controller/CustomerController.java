package com.example.demo.controller;


import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/customer")     // 通过这里配置使下面的映射都在/users下
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/findList")
    public Iterable<Customer> findList() {
        return customerRepository.findAll();
    }

    @GetMapping("/findOne")
    public Optional<Customer> findOne(@RequestParam Long id) {
        return customerRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @GetMapping("/hello")
    public Customer hello() {
        return new Customer("wang", "san");
    }

}

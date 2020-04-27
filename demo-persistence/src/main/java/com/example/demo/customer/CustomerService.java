package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public CustomerVO findByFirstName(String name) {
        Customer customer = jpaQueryFactory
                .select(QCustomer.customer)
                .from(QCustomer.customer)
                .where(QCustomer.customer.firstName.eq(name))
                .fetchOne();
        return customerMapper.customToCustomerVO(customer);
    }

}

package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
class CustomerServiceTest extends BaseTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerService customerService;

    @Test
    void testFindByLastName() {
        Customer customer = new Customer("first", "last");
        entityManager.persist(customer);
        CustomerVO result = customerService.findByFirstName(customer.getFirstName());
        assertThat(result).extracting(CustomerVO::getName).isEqualTo(customer.getFirstName());
    }
}
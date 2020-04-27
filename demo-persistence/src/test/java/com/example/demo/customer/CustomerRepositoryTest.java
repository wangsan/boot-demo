package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class CustomerRepositoryTest extends BaseTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindByLastName() {
        Customer customer = new Customer("first", "last");
        entityManager.persist(customer);
        List<Customer> findByLastName = customerRepository.findByLastName(customer.getLastName());
        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).size().isEqualTo(1);
    }

    @Test
    public void testFindWithDsl() {
        Customer customer = new Customer("first", "last");
        entityManager.persist(customer);

        QCustomer qCustomer = QCustomer.customer;
        Customer result = customerRepository.findOne(qCustomer.lastName.eq(customer.getLastName())).orElse(null);
        assertEquals(customer.getLastName(), result.getLastName());
    }
}

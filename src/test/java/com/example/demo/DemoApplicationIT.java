package com.example.demo;

import com.example.demo.customer.Customer;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Ignore
@ExtendWith(SpringExtension.class)
class DemoApplicationIT {

    @Configuration
    public static class TestConfiguration {
        @Bean
        public RestTemplate restTemplate() {
            RestTemplateBuilder builder = new RestTemplateBuilder();
            return builder.build();
        }
    }

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testCustomerHello() {
        ResponseEntity<Customer> entity = restTemplate.getForEntity("http://localhost:8080/customer/hello", Customer.class);
        System.out.println(entity.getBody());
    }

    @Test
    void testCustomerFindList() {
        ParameterizedTypeReference<List<Customer>> reference = new ParameterizedTypeReference<List<Customer>>() {
        };
        ResponseEntity<List<Customer>> entity = restTemplate.exchange(
                "http://localhost:8080/customer/findList",
                HttpMethod.GET,
                null,
                reference);
        System.out.println(entity.getBody());
    }

    @Test
    void testCustomerSave() {
        Customer customer = new Customer("foo", "bar");
        ResponseEntity<Void> entity = restTemplate.postForEntity("http://localhost:8080/customer/save", customer, Void.class);
        System.out.println(entity.getStatusCode());
    }

}

package com.example.demo.customer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
@DataJpaTest
public abstract class BaseTest {
    @SpringBootApplication
    @ComponentScan(basePackageClasses = {CustomerService.class})
    public static class TestApplication {

    }
}

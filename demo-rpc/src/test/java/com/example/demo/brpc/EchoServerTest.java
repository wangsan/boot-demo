package com.example.demo.brpc;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.brpc.server.EchoServiceImpl;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
@SpringBootTest
class EchoServerTest {

    @SpringBootApplication
    public static class TestConfiguration {

    }

    @Test
    public void startServer(){
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
package com.example.demo.brpc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.baidu.brpc.spring.annotation.RpcProxy;
import com.example.demo.brpc.api.AsyncEchoService;
import com.example.demo.brpc.api.EchoRequest;
import com.example.demo.brpc.api.EchoService;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
@SpringBootTest
@TestPropertySource(properties = {"brpc.global.server.port=1234"})
class EchoClientTest {

    @SpringBootApplication(
            scanBasePackageClasses = EchoService.class
    )
    public static class TestConfiguration {

    }

    @RpcProxy
    private EchoService echoService;
    @RpcProxy
    private AsyncEchoService asyncEchoService;

    @Test
    public void testEcho() {
        System.out.println(echoService.echo(new EchoRequest("hei")));
    }

}
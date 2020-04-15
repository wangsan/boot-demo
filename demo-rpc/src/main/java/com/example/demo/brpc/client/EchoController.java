package com.example.demo.brpc.client;

import com.baidu.brpc.client.RpcCallback;
import com.baidu.brpc.spring.annotation.RpcProxy;
import com.example.demo.brpc.api.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class EchoController {

    @RpcProxy
    private EchoService echoService;
    @RpcProxy
    private AsyncEchoService asyncEchoService;
    @RpcProxy
    private FooService fooService;

    @GetMapping("/echo")
    public String echo(@RequestParam(value = "name", defaultValue = "World") String name) {
        EchoRequest request = new EchoRequest();
        request.setMessage(name);
        EchoResponse response1 = echoService.echo(request);

        Future<EchoResponse> future = asyncEchoService.echo(request, new RpcCallback<EchoResponse>() {
            @Override
            public void success(EchoResponse response) {
                System.out.println(response.getMessage());
            }

            @Override
            public void fail(Throwable e) {
                e.printStackTrace();
            }
        });

        EchoResponse response2 = null;
        try {
            response2 = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return String.format("sync: %s , async: %s", response1, response2);
    }


    @GetMapping("/foo")
    public String foo(@RequestParam(value = "name", defaultValue = "World") String name) {
        return fooService.foo(new FooMessage(name)).getMessage();
    }
}

package com.example.demo.brpc.server;

import com.baidu.brpc.spring.annotation.RpcExporter;
import com.example.demo.brpc.api.FooMessage;
import com.example.demo.brpc.api.FooService;

@RpcExporter
public class FooServiceImpl implements FooService {
    @Override
    public FooMessage foo(FooMessage request) {
        return new FooMessage(String.format("foo: %s", request.getMessage()));
    }
}

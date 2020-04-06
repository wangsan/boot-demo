package com.example.demo.brpc.server;

import com.baidu.brpc.spring.annotation.RpcExporter;
import com.example.demo.brpc.api.EchoRequest;
import com.example.demo.brpc.api.EchoResponse;
import com.example.demo.brpc.api.EchoService;

@RpcExporter
public class EchoServiceImpl implements EchoService {
    @Override
    public EchoResponse echo(EchoRequest request) {
        return new EchoResponse(String.format("echo: %s", request.getMessage()));
    }
}

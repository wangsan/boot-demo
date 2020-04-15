/*
 * Copyright (c) 2018 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.brpc.api;

import com.baidu.brpc.client.RpcCallback;
import com.baidu.brpc.protocol.BrpcMeta;

import java.util.concurrent.Future;

/**
 * Created by huwenwei on 2018/11/23.
 */
public interface AsyncEchoService extends EchoService {
    /**
     * brpc/sofa：
     * serviceName默认是包名 + 类名，methodName是proto文件Service内对应方法名，
     * hulu：
     * serviceName默认是类名，methodName是proto文件Service内对应方法index。
     */
    @BrpcMeta(serviceName = "example.EchoService", methodName = "Echo")
//    @BrpcMeta(serviceName = "EchoService", methodName = "0")
    Future<EchoResponse> echo(EchoRequest request, RpcCallback<EchoResponse> callback);
}

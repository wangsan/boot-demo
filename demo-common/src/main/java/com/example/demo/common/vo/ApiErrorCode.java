package com.example.demo.common.vo;

import lombok.Getter;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
public enum ApiErrorCode {
    SUCCESS(0),
    SERVER_ERROR(5000),
    CLIENT_VALIDATE_FAILED(4000);

    @Getter
    int code;

    ApiErrorCode(int code) {
        this.code = code;
    }
}

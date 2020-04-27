package com.example.demo.controller;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.vo.ApiErrorCode;
import com.example.demo.common.vo.ApiResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ApiResponse(ApiErrorCode.CLIENT_VALIDATE_FAILED.getCode(), objectError.getDefaultMessage(), null,
                               null);
    }
}

package com.example.demo.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private String requestId;
    private T data;


}

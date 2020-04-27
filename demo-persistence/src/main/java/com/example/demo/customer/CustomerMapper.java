package com.example.demo.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * created by wangsan on 2020/4/27.
 *
 * @author wangsan
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "name", source = "firstName")
    @Mapping(target = "idCode", source = "id")
    CustomerVO customToCustomerVO(Customer customer);
}

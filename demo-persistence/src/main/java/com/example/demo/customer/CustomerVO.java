package com.example.demo.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {
    private Long id;
    private String idCode;
    private String name;
    private String lastName;

}

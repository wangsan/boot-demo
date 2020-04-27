package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SampleProperties;

@RestController
public class IndexController {

    @Autowired
    private SampleProperties sampleProperties;

    @GetMapping("/")
    public String index() {
        return "wangsan index " + sampleProperties.getProp();
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }
}

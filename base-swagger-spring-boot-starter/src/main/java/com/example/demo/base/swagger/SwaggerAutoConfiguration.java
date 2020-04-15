package com.example.demo.base.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SwaggerConfiguration.class)
public class SwaggerAutoConfiguration {
}

package com.example.demo.base.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Configuration
@ConditionalOnProperty(name = "swagger.enabled")
@EnableSwagger2
@Slf4j
public class SwaggerConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "swagger.enabled")
    public Docket docket(SwaggerProperties properties) {
        log.info("load swagger docket");

        Predicate<String> paths;
        if (!properties.getBasePath().isEmpty()) {
            paths = Predicates.or(properties.getBasePath().stream().map(PathSelectors::ant).collect(toList()));
        } else {
            paths = PathSelectors.any();
        }


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(properties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()))
                .paths(paths)
                .build();
    }

    private ApiInfo apiInfo(SwaggerProperties properties) {
        return new ApiInfoBuilder()
                .title(Optional.ofNullable(properties.getTitle()).orElse("hello swagger"))
                .description(Optional.ofNullable(properties.getDescription()).orElse(""))
                .build();
    }
}

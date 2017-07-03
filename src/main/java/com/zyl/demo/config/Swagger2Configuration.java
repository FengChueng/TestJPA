package com.zyl.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类主要进行restful文档的生成
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zyl.demo.ctrl"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .enable(true)
                .useDefaultResponseMessages(false);
    }
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("My Resful API Docs")
                .description("TestJPA API列表")
                .version("1.0")
                .build();
    }
}

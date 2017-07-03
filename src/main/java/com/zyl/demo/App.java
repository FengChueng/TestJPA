package com.zyl.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages="com.zyl.demo.pojo")
@ComponentScan(basePackages = {"com.zyl.demo.ctrl","com.zyl.demo.service","com.zyl.demo.config"})
@EnableJpaRepositories(basePackages="com.zyl.demo.jpa")
@AutoConfigurationPackage
@EnableTransactionManagement
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

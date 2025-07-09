package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRbacApplication {
    // http://localhost:8080/swagger-ui/index.html 預設的SWAGGER
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRbacApplication.class, args);
	}// 有一些奇怪的坑 像是

}

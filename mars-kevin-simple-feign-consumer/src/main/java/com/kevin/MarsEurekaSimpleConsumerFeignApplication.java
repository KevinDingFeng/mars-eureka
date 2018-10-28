package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MarsEurekaSimpleConsumerFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MarsEurekaSimpleConsumerFeignApplication.class, args);
	}
	
}

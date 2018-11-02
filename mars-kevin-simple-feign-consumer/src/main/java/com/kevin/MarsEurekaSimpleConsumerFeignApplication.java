package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MarsEurekaSimpleConsumerFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MarsEurekaSimpleConsumerFeignApplication.class, args);
	}
	
}

package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MarsEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsEurekaServiceApplication.class, args);
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(@RequestParam(value = "name", required = false) String name) {
		System.out.println("provider service");
		return "hi, " + name;
	}
}

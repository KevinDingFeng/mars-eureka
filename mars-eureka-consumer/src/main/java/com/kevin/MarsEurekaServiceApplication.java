package com.kevin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kevin.ribbon.service.HiService;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MarsEurekaServiceApplication {
	
	@Autowired
	private HiService hiService;

	public static void main(String[] args) {
		SpringApplication.run(MarsEurekaServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi() {
		return hiService.hiService("kevin");
	}
}

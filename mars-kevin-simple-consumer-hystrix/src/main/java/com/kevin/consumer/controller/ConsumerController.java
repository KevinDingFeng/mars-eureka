package com.kevin.consumer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.consumer.ribbon.service.HiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {

	@Autowired
	private HiService hiService;

	//一般测试
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "findByIdFallbackMethod")
	public String hi(HttpServletRequest req) {
		return hiService.hiService("kevin " + req.getLocalPort());
	}
	public String findByIdFallbackMethod(HttpServletRequest req) {
		return "Hello World!Kevin!";
	}
}

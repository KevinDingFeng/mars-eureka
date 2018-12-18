package com.kevin.consumer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.UserFeignClient;

@RestController
public class ConsumerController {
	
	@Autowired
	private UserFeignClient userFeignClient;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(HttpServletRequest req) {
		return userFeignClient.getHi("KKevin");
	}

}

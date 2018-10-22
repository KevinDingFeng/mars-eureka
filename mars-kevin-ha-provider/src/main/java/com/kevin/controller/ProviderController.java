package com.kevin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(HttpServletRequest req, @RequestParam(value = "name", required = false) String name) {
		System.out.println("provider service " + req.getLocalPort());
		return "hi, " + name;
	}
}

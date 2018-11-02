package com.kevin.consumer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.UserFeignClient;
import com.kevin.entity.SysUser;

@RestController
public class ConsumerController {
	
	@Autowired
	private UserFeignClient userFeignClient;

	//一般测试 ok
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(HttpServletRequest req) {
		return userFeignClient.getHi("KKevin");
	}

	// 为了方便测试，返回值的类型和参数类型相同或者类似 ok
	// get 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	@RequestMapping(value = "/ribbon1", method = RequestMethod.GET)
	public String ribbon1(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		return userFeignClient.ribbon1Get(2L, "KKKevin");
	}
	// 500 异常，post 接口没提供
	@RequestMapping(value = "/ribbon2", method = RequestMethod.GET)
	public SysUser ribbon2(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		SysUser sysUser = new SysUser();
		sysUser.setId(3L);
		sysUser.setName("KevinKK");
		return userFeignClient.ribbon2Get(sysUser);
	}

	// ok
	@RequestMapping(value = "/ribbon3", method = RequestMethod.GET)
	public String[] ribbon3(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		String[] names = {"Kevin1", "Kevin2", "Kevin3"};
		return userFeignClient.ribbon3Get(names);
	}

	// ok
	@RequestMapping(value = "/ribbon4", method = RequestMethod.GET)
	public List<String> ribbon4(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		List<String> names = new ArrayList<>();
		names.add("Kevin1");
		names.add("Kevin2");
		names.add("Kevin3");
		return userFeignClient.ribbon4Get(names);
	}

	
	// post 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	// ok
	@RequestMapping(value = "/ribbon1_post", method = RequestMethod.GET)
	public String ribbonPost1(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		return userFeignClient.ribbonPost1(2L, "Kevin");
	}

	// ok
	@RequestMapping(value = "/ribbon2_post", method = RequestMethod.GET)
	public SysUser ribbonPost2(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		SysUser sysUser = new SysUser();
		sysUser.setId(3L);
		sysUser.setName("KevinKK");
		return userFeignClient.ribbonPost2(sysUser);
	}

	// ok
	@RequestMapping(value = "/ribbon3_post", method = RequestMethod.GET)
	public String[] ribbonPost3(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		String[] names = {"Kevin1", "Kevin2", "Kevin3"};
		return userFeignClient.ribbonPost3(names);
	}

	// ok
	@RequestMapping(value = "/ribbon4_post", method = RequestMethod.GET)
	public List<String> ribbonPost4(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		List<String> names = new ArrayList<>();
		names.add("Kevin1");
		names.add("Kevin2");
		names.add("Kevin3");
		return userFeignClient.ribbonPost4(names);
	}
}

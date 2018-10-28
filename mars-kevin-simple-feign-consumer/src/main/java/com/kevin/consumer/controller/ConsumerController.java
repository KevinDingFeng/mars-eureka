package com.kevin.consumer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.entity.SysUser;

@RestController
public class ConsumerController {
//
//	@Autowired
//	private HiService hiService;

	//一般测试
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(HttpServletRequest req) {
//		return hiService.hiService("kevin " + req.getLocalPort());
		return null;
	}

	// 为了方便测试，返回值的类型和参数类型相同或者类似
	// get 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	@RequestMapping(value = "/ribbon1", method = RequestMethod.GET)
	public String ribbon1(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
//		return hiService.ribbon1(2L, "Kevin");
		return null;
	}

	@RequestMapping(value = "/ribbon2", method = RequestMethod.GET)
	public SysUser ribbon2(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		SysUser sysUser = new SysUser();
		sysUser.setId(3L);
		sysUser.setName("KevinKK");
//		return hiService.ribbon2(sysUser);
		return null;
	}

	@RequestMapping(value = "/ribbon3", method = RequestMethod.GET)
	public String[] ribbon3(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		String[] names = {"Kevin1", "Kevin2", "Kevin3"};
//		return hiService.ribbon3(names);
		return null;
	}

	@RequestMapping(value = "/ribbon4", method = RequestMethod.GET)
	public List<String> ribbon4(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		List<String> names = new ArrayList<>();
		names.add("Kevin1");
		names.add("Kevin2");
		names.add("Kevin3");
//		return hiService.ribbon4(names);
		return null;
	}

	// post 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	@RequestMapping(value = "/ribbon1_post", method = RequestMethod.GET)
	public String ribbonPost1(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
//		return hiService.ribbonPost1(2L, "Kevin");
		return null;
	}

	@RequestMapping(value = "/ribbon2_post", method = RequestMethod.GET)
	public SysUser ribbonPost2(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		SysUser sysUser = new SysUser();
		sysUser.setId(3L);
		sysUser.setName("KevinKK");
//		return hiService.ribbonPost2(sysUser);
		return null;
	}

	@RequestMapping(value = "/ribbon3_post", method = RequestMethod.GET)
	public String[] ribbonPost3(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		String[] names = {"Kevin1", "Kevin2", "Kevin3"};
//		return hiService.ribbonPost3(names);
		return null;
	}

	@RequestMapping(value = "/ribbon4_post", method = RequestMethod.GET)
	public List<String> ribbonPost4(HttpServletRequest req) {
		System.out.println("provider service " + req.getLocalPort());
		List<String> names = new ArrayList<>();
		names.add("Kevin1");
		names.add("Kevin2");
		names.add("Kevin3");
//		return hiService.ribbonPost4(names);
		return null;
	}
}

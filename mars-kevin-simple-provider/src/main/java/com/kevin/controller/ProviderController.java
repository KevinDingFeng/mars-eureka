package com.kevin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.entity.SysUser;

@RestController
public class ProviderController {

	// 普通测试，只为了测试可以被 consumer 调用
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi(HttpServletRequest req, @RequestParam(value = "name", required = false) String name) {
		System.out.println("provider service " + req.getLocalPort());
		return "hi, " + name;
	}

	// 为了方便测试，返回值的类型和参数类型相同或者类似
	// get 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	@RequestMapping(value = "/ribbon1", method = RequestMethod.GET)
	public String ribbon1(HttpServletRequest req, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "id", required = false) Long id) {
		System.out.println("provider service " + req.getLocalPort());
		return "id = " + id + " ; name = " + name;
	}

	@RequestMapping(value = "/ribbon2", method = RequestMethod.GET)
	public SysUser ribbon2(HttpServletRequest req, @RequestBody SysUser sysUser) {
		System.out.println("provider service " + req.getLocalPort());
		System.out.println("user.id = " + sysUser.getId() + " ; user.name = " + sysUser.getName());
		return sysUser;
	}

	@RequestMapping(value = "/ribbon3", method = RequestMethod.GET)
	public String[] ribbon3(HttpServletRequest req, @RequestParam(value = "names", required = false) String[] names) {
		System.out.println("provider service " + req.getLocalPort());
		if (names != null && names.length > 0) {
			for (String n : names) {
				System.out.println(n);
			}
		}
		return names;
	}

	@RequestMapping(value = "/ribbon4", method = RequestMethod.GET)
	public List<String> ribbon4(HttpServletRequest req,
			@RequestParam(value = "names", required = false) List<String> names) {
		System.out.println("provider service " + req.getLocalPort());
		if (names != null && names.size() > 0) {
			for (String n : names) {
				System.out.println(n);
			}
		}
		return names;
	}

	// post 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	@RequestMapping(value = "/ribbon1_post", method = RequestMethod.POST)
	public String ribbonPost1(HttpServletRequest req, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "id", required = false) Long id) {
		System.out.println("provider service " + req.getLocalPort());
		return "id = " + id + " ; name = " + name;
	}

	@RequestMapping(value = "/ribbon2_post", method = RequestMethod.POST)
	public SysUser ribbonPost2(HttpServletRequest req, @RequestBody SysUser sysUser) {
		System.out.println("provider service " + req.getLocalPort());
		System.out.println("user.id = " + sysUser.getId() + " ; user.name = " + sysUser.getName());
		return sysUser;
	}

	@RequestMapping(value = "/ribbon3_post", method = RequestMethod.POST)
	public String[] ribbonPost3(HttpServletRequest req,
			@RequestParam(value = "names", required = false) String[] names) {
		System.out.println("provider service " + req.getLocalPort());
		if (names != null && names.length > 0) {
			for (String n : names) {
				System.out.println(n);
			}
		}
		return names;
	}

	@RequestMapping(value = "/ribbon4_post", method = RequestMethod.POST)
	public List<String> ribbonPost4(HttpServletRequest req,
			@RequestParam(value = "names", required = false) List<String> names) {
		System.out.println("provider service " + req.getLocalPort());
		if (names != null && names.size() > 0) {
			for (String n : names) {
				System.out.println(n);
			}
		}
		return names;
	}
}

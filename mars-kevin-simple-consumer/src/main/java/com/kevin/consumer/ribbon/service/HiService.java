package com.kevin.consumer.ribbon.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kevin.entity.SysUser;

@Service
public class HiService {

	@Autowired
	private RestTemplate restTemplate;

	// 一般测试
	public String hiService(String name) {
		return restTemplate.getForObject("http://eureka-provider/hi?name=" + name, String.class);
	}

	// 为了方便测试，返回值的类型和参数类型相同或者类似
	// get 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	public String ribbon1(long id, String name) {
		// 方法 1
//		return restTemplate.getForObject("http://eureka-provider/ribbon1?id=" + id + "&name= + " + name, String.class);//可行
		// 方法2 不可行
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		return restTemplate.getForObject("http://eureka-provider/ribbon1", String.class, map);//不可行，provider 获取不到 id 和 name 值
		// 方法 3 不可行
//		return restTemplate.getForObject("http://eureka-provider/ribbon1", String.class, id, name);//不可行，provider 获取不到 id 和 name 值
	}

	public SysUser ribbon2(SysUser sysUser) {
		// 方法 1
		Map<String, Object> map = new HashMap<>();
		map.put("id", sysUser.getId());
		map.put("name", sysUser.getName());
		return restTemplate.getForObject("http://eureka-provider/ribbon2", SysUser.class, map);
		// 方法2
//		map = new HashMap<>();
//		map.put("sysUser", sysUser);
//		return restTemplate.getForObject("http://eureka-provider/ribbon2", SysUser.class, map);
	}

	public String[] ribbon3(String[] names) {
		Map<String, Object> map = new HashMap<>();
		map.put("names", names);
		return restTemplate.getForObject("http://eureka-provider/ribbon3", String[].class, map);
	}

	public List<String> ribbon4(List<String> names) {
		Map<String, Object> map = new HashMap<>();
		map.put("names", names);
		return restTemplate.getForObject("http://eureka-provider/ribbon4", List.class, map);
	}

	// post 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	public String ribbonPost1(long id, String name) {
		// 方法 1
		return restTemplate.postForObject("http://eureka-provider/ribbon1?id=" + id + "&name= + " + name, null, String.class);
		// 方法2
//		Map<String, Object> map = new HashMap<>();
//		map.put("id", id);
//		map.put("name", name);
//		return restTemplate.postForObject("http://eureka-provider/ribbon1", null, String.class, map);
		// 方法 3
//		return restTemplate.postForObject("http://eureka-provider/ribbon1", null, String.class, l, string);
	}

	public SysUser ribbonPost2(SysUser sysUser) {
		// 方法 1
		Map<String, Object> map = new HashMap<>();
		map.put("id", sysUser.getId());
		map.put("name", sysUser.getName());
		return restTemplate.postForObject("http://eureka-provider/ribbon2", null, SysUser.class, map);
		// 方法2
//				map = new HashMap<>();
//				map.put("sysUser", sysUser);
//				return restTemplate.postForObject("http://eureka-provider/ribbon2", null, SysUser.class, map);
	}

	public String[] ribbonPost3(String[] names) {
		Map<String, Object> map = new HashMap<>();
		map.put("names", names);
		return restTemplate.postForObject("http://eureka-provider/ribbon3", null, String[].class, map);
	}

	public List<String> ribbonPost4(List<String> names) {
		Map<String, Object> map = new HashMap<>();
		map.put("names", names);
		return restTemplate.postForObject("http://eureka-provider/ribbon4", null, List.class, map);
	}
}

package com.kevin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kevin.entity.SysUser;

@FeignClient("eureka-provider")
public interface UserFeignClient {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
    String getHi(@RequestParam(value = "name") String name);

	//官网的例子
//    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
//    Store update(@PathVariable("storeId") Long storeId, Store store);
	
	//跟着案例敲的例子，可用
	/*
	@RequestMapping(value = "/ribbon2_post", method = RequestMethod.POST)
	public SysUser ribbonPost2(@RequestBody SysUser sysUser);
	
	//只要参数是复杂对象，即使指定了是 get 方法，feign 依然会以 post 方法进行发送请求
	@RequestMapping(value = "/ribbon2_get", method = RequestMethod.GET)
	public SysUser ribbonget(SysUser sysUser);
	*/
	
	@RequestMapping(value = "/ribbon1", method = RequestMethod.GET)
	public String ribbon1Get(@RequestParam(value = "id") long id, 
			@RequestParam(value = "name") String name);

	@RequestMapping(value = "/ribbon2", method = RequestMethod.GET)
	public SysUser ribbon2Get(@RequestBody SysUser sysUser);
	// 不加 @RequestBody 注解 出现 500 错误 ，提示 post 方法不支持
	// 加 @RequestBody 注解 同上

	@RequestMapping(value = "/ribbon3", method = RequestMethod.GET)
	public String[] ribbon3Get(@RequestParam(value = "names") String[] names);

	@RequestMapping(value = "/ribbon4", method = RequestMethod.GET)
	public List<String> ribbon4Get(@RequestParam(value = "names") List<String> names);

	@RequestMapping(value = "/ribbon1_post", method = RequestMethod.POST)
	public String ribbonPost1(@RequestParam(value = "id") long id, 
			@RequestParam(value = "name") String name);

	@RequestMapping(value = "/ribbon2_post", method = RequestMethod.POST)
	public SysUser ribbonPost2(SysUser sysUser);
	// 加 @RequestBody 注解 ok
	// 不加 @RequestBody 注解 ok
	
	@RequestMapping(value = "/ribbon3_post", method = RequestMethod.POST)
	public String[] ribbonPost3(@RequestParam(value = "names") String[] names);

	@RequestMapping(value = "/ribbon4_post", method = RequestMethod.POST)
	public List<String> ribbonPost4(@RequestParam(value = "names") List<String> names);

}

package com.kevin.consumer.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 * 测试的结果
 * 	请求方式 get：
 * 		参数类型：普通+字符串（可行）、自定义对象（不可行）、数组（不可行）、集合（不可行）
 * 	请求方式 post：
 * 		参数类型：普通+字符串（可行）、自定义对象（可行）、数组（可行）、集合（可行）
 * 
 * 	返回值：
 * 		返回类型：普通+字符串（可行）、自定义对象（可行）、数组（可行）、集合（可行）
 * @author 程任强
 *
 */
@Service
public class HiService {

	@Autowired
	private RestTemplate restTemplate;

	// 一般测试
	public String hiService(String name) {
		return restTemplate.getForObject("http://eureka-provider/hi?name=" + name, String.class);
	}
}

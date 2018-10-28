package com.kevin.consumer.ribbon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kevin.entity.SysUser;
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

	// 为了方便测试，返回值的类型和参数类型相同或者类似
	// get 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	public String ribbon1(long id, String name) {
		return restTemplate.getForObject("http://eureka-provider/ribbon1?id=" + id + "&name= + " + name, String.class);//可行
	}

	// get 方法，一般不会存在使用复杂对象作为请求参数，且 restTemplate 对 get 发送 复杂对象没有找到合适的支持方法
	public SysUser ribbon2(SysUser sysUser) {
		return null;
	}
	// get 方法 ，同上 ribbon2
	public String[] ribbon3(String[] names) {
		return null;
	}
	// get 方法 ，同上 ribbon2
	public List<String> ribbon4(List<String> names) {
		return null;
	}

	// post 方法，参数分几类： 普通类型和字符串、对象、数组、集合
	public String ribbonPost1(long id, String name) {
		// 方法 1
//		return restTemplate.postForObject("http://eureka-provider/ribbon1_post?id=" + id + "&name= + " + name, null, String.class);//可行
		// 方法2
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();//重点，需要使用该类型的 Map ： MultiValueMap
		map.add("id", id);
		map.add("name", name);
		return restTemplate.postForObject("http://eureka-provider/ribbon1_post", map, String.class);//可行
		
		// 头部信息不设置的话，默认是 text 的类型，所以正常情况可以不设置
//		return restTemplate.postForObject("http://eureka-provider/ribbon1_post", map, String.class);//可行，可以添加第四个参数，用来补全 uri 中的预编译参数位置
		
	}
	//下面隐藏的代码是从网上找到的设置 header 的部分，应该是用在提交特殊的信息，比如表单等
//	HttpHeaders headers = new HttpHeaders();
//	MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//	headers.setContentType(type);
//	headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//	JSONObject jsonObject = new JSONObject();
//	jsonObject.putAll(map);
//	HttpEntity<String> formEntity = new HttpEntity<>(jsonObject.toString(), headers);

	public SysUser ribbonPost2(SysUser sysUser) {
		// 方法 1
//		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//		map.add("id", sysUser.getId());
//		map.add("name", sysUser.getName());
//		return restTemplate.postForObject("http://eureka-provider/ribbon2_post", map, SysUser.class);//出错 不可行 Content type multipart/form-data;charset=UTF-8;boundary=xxx not supported
		// 方法2
//		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//		map.add("sysUser", sysUser);
//		return restTemplate.postForObject("http://eureka-provider/ribbon2_post", map, SysUser.class);//同方法1
		
		// 方法3
		return restTemplate.postForObject("http://eureka-provider/ribbon2_post", sysUser, SysUser.class);//可行
	}

	// post 方法，值勉强可以传送过去，但是不理想，尽量不要适用；接收到的参数会使用逗号分隔成新数组的，导致首位数组拥有了特殊符号 
	public String[] ribbonPost3(String[] names) {
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//		map.add("names", names);//这个是原有的测试
		map.add("names", "K11,K22,K33");//为了测试上述说明不理想的效果，这个传过去效果才是想要的
		return restTemplate.postForObject("http://eureka-provider/ribbon3_post", map, String[].class);//可行 ["[\"Kevin1\"","\"Kevin2\"","\"Kevin3\"]"]
	}
	// 同上
	@SuppressWarnings("unchecked")
	public List<String> ribbonPost4(List<String> names) {
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//		map.add("names", names);//这个是原有的测试
		map.add("names", "K11,K22,K33");
		return restTemplate.postForObject("http://eureka-provider/ribbon4_post", map, List.class);// 可行 ["[\"Kevin1\"","\"Kevin2\"","\"Kevin3\"]"]
	}
}

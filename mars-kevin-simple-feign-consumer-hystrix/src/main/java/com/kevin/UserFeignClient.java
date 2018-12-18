package com.kevin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-provider", fallback = HystrixUserFeignClient.class)
public interface UserFeignClient {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
    String getHi(@RequestParam(value = "name") String name);
	
}

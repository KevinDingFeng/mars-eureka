package com.kevin;

import org.springframework.stereotype.Component;

@Component
public class HystrixUserFeignClient  implements UserFeignClient{

	@Override
	public String getHi(String name) {
		return "Hello World! Kevin !" + name;
	}
	
}

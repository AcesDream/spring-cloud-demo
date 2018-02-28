package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itmuch.cloud.movie.model.User;
import com.itmuch.config.FeignConfiguration;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {
	
	/**
	 * 使用feign自带注解
	 * @param id
	 * @return
	 */
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Long id);
}

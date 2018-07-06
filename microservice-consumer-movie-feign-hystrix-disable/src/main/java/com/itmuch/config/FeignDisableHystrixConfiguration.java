package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

/**
 * 这个类不要放在启动类的扫描路径下
 * @ClassName: FeignDisableHystrixConfiguration
 * @Description: TODO
 *
 */
@Configuration
public class FeignDisableHystrixConfiguration {

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		System.out.println("run here");
		return Feign.builder();
	}
}

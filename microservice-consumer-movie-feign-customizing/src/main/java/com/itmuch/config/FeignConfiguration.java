package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * 类似ribbon，可以为单独的feign客户端自定义属性
 * @author lxy
 *
 */
@Configuration
public class FeignConfiguration {
	
	/**
	 * 将契约修改为feign原生的默认契约。这样就可以使用feign自带的注解了
	 * @return
	 */
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
}

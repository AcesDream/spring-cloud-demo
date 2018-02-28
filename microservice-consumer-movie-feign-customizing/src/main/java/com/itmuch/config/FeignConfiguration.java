package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;

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
	
	/**
	 * 当微服务需要进行认证的时候，这里就可以设置用户名和密码
	 * @return
	 */
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//		return new BasicAuthRequestInterceptor("user", "password1");
		return new BasicAuthRequestInterceptor("admin", "password2");
	}
}

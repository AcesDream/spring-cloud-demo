package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * 类似ribbon，可以为单独的feign客户端自定义属性
 * @author lxy
 *
 */
@Configuration
public class FeignConfiguration {
	
	/**
	 * feign日志记录级别
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}

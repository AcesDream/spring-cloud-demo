package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * Feign对日志的处理非常灵活，可为每个feign客户端指定日志记录策略，
 * 每个feign客户端都会创建一个logger。默认情况下，logger的名称是feign接口的完整类名。
 * 需要注意的是：feign的日志打印只会对debug级别做出响应
 * 
 * 我们可以为每个feign客户端配置各自的logger.level对象，告诉feign记录哪些日志。
 * Logger.level有一项可选值：
 * NONE：不记录任何日志，默认值
 * BASIC：仅记录请求方法，URL，响应状态码及执行时间
 * HEADERS：记录BASIC级别的基础之上，记录请求和响应的header
 * FULL：记录请求和响应的header、body和元数据
 * 
 * @author lxy
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieApplication.class, args);
	}
}

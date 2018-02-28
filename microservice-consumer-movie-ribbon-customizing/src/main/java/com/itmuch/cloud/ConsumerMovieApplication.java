package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.itmuch.config.RibbonConfiguration;

/**
 * 指定服务名为：microservice-provider-user的服务使用的配置为自定义配置
 * 
 * 这样可以实现不同的客户端使用不同的规则
 * @author lxy
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfiguration.class)
public class ConsumerMovieApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieApplication.class, args);
	}
}

package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.itmuch.cloud.filter.PreRequestLogFilter;

/**
 * 使用@EnableZuulProxy注解激活zuul
 * 
 * 跟进该注解可以看到该注解整合了@EnableCircuitBreaker、@EnableDiscoveryClient，是个组合注解，目的是简化配置
 * 
 * 这就是最简单的网关服务
 * 
 * 访问：
 * http://GATEWAY:GATEWAY_PORT/想要访问的Eureka服务id的小写/**
 * 
 * 实际会转到：
 * http://想要访问的Eureka服务id的小写:该服务端口/**
 * 
 * 1、启动microservice-discovery-eureka
 * 2、启动microservice-provider-user
 * 3、启动microservice-api-gateway
 * 
 * 访问：
 * http://localhost:8050/microservice-provider-user/1
 * 
 * 实际上会转到：
 * http://localhost:8001/1
 * 
 * @author lxy
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {
	
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
}

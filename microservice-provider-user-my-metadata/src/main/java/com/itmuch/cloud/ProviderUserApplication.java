package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient:声明这是一个Eureka Client
 * 
 * 也可以使用@EnableEurekaClient代替@EnableDiscoveryClient
 * 因为在spring cloud中的服务发现组件有很多，例如zookeeper、Consul
 * @EnableDiscoveryClient 为各种组件服务
 * @author lxy
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}
}

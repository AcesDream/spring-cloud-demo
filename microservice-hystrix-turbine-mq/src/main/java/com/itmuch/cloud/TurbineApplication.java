package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @EnableTurbine : 可以聚合监控数据，同时监控多个微服务
 * 
 * 它只能监控一个端点
 * http://localhost:8030/hystrix
 * @author lxy
 *
 */
@SpringBootApplication
@EnableTurbineStream
public class TurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}

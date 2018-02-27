package com.itmuch.cloud.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.movie.model.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	//produces：指定返回的格式
	@GetMapping(value= "/user/{id}", produces = "application/json")
	public User findById(@PathVariable Long id) {
		
		/**
		 * 注意：不能将restTemplate.getForObject(...)与loadBalancerClient.choose(...)写在同一个方法中
		 * 两者之间会有冲突，因为此时restTemplate实际上是一个Ribbon客户端，本身已经包含了choose的行为
		 */
		//这里microservice-provider-user是虚拟主机名，虚拟主机名不能包含"_"之类的字符
		User findOne = this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
		
		logger.info("根据id:{}，查询到的user：{}", id, findOne);
		return findOne;
	}
	
	@GetMapping("/log-user-instance")
	public void logUserInstance() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		
		logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	}
	
}

package com.itmuch.cloud.movie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient discoveryClient;
	
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.restTemplate.getForObject(this.userServiceUrl + id, User.class);
		
		logger.info("根据id:{}，查询到的user：{}", id, findOne);
		return findOne;
	}
	
	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo() {
		return this.discoveryClient.getInstances("microservice-provider-user");
	}
}

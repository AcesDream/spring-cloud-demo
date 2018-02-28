package com.itmuch.cloud.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.feign.UserFeignClient;
import com.itmuch.cloud.movie.model.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@GetMapping(value = "/user/{id}", produces = "application/json")
	public User findById(@PathVariable Long id) {
		User findOne = this.userFeignClient.getUser(id);
		
		logger.info("根据id:{}，查询到的user：{}", id, findOne);
		return findOne;
	}
		
}

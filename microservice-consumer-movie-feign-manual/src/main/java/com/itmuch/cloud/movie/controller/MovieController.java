package com.itmuch.cloud.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.feign.UserFeignClient;
import com.itmuch.cloud.movie.model.User;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;

@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

	private UserFeignClient userUserFeignClient;
	
	private UserFeignClient adminUserFeignClient;
	
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
		// TODO Auto-generated constructor stub
		
		
		this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user", "password1")).target(UserFeignClient.class, "http://microservice-provider-user/");
		
		this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2")).target(UserFeignClient.class, "http://microservice-provider-user/");
	}
	
	@GetMapping(value = "/user-user/{id}", produces = "application/json")
	public User findByIdUser(@PathVariable Long id) {
		User findOne = this.userUserFeignClient.findById(id);
		
		logger.info("根据id:{}，查询到的user：{}", id, findOne);
		return findOne;
	}
	
	@GetMapping(value = "/user-admin/{id}", produces = "application/json")
	public User findByIdAdmin(@PathVariable Long id) {
		User findOne = this.adminUserFeignClient.findById(id);
		
		logger.info("根据id:{}，查询到的user：{}", id, findOne);
		return findOne;
	}
		
}

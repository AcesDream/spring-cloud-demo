package com.itmuch.cloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.api.UserService;
import com.itmuch.cloud.user.dao.UserRepository;
import com.itmuch.cloud.user.model.User;

@RestController
public class UserResource implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		User findOne = this.userRepository.findOne(id);
		
		return findOne;
	}

}

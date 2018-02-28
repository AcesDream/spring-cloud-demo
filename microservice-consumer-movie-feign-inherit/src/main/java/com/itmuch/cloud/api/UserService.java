package com.itmuch.cloud.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.movie.model.User;

public interface UserService {
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	User getUser(@PathVariable("id") Long id);
}

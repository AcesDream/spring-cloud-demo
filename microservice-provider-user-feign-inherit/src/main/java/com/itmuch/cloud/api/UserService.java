package com.itmuch.cloud.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.user.model.User;

/**
 * 定义公共接口
 * @author lxy
 *
 */
public interface UserService {
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	User getUser(@PathVariable("id") Long id);
}

package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.movie.model.User;

/**
 * Feign与Hystrix集成
 * 需要实现Feign Client的接口即可
 * FeignClientFallback 也可以是public的
 * 
 * @ClassName: UserFeignClient
 * @Description: TODO
 *
 */
@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(-1L);
		user.setName("默认用户");
		
		return user;
	}

}

package com.itmuch.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.movie.model.User;

import feign.hystrix.FallbackFactory;
/**
 * 通过fallback factory检查回退原因
 * 
 * @ClassName: UserFeignClient
 * @Description: TODO
 *
 */
@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}

/**
 * 需要实现FallbackFactory接口，重写create方法
 * @ClassName: FeignClientFallbackFactory
 * @Description: TODO
 *
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		// TODO Auto-generated method stub
		return new UserFeignClient() {
			
			@Override
			public User findById(Long id) {
				// TODO Auto-generated method stub
				//日志输出最好放在fallback方法中，而不是create方法中
				//否则引用启动时，就会输出该日志
				//详见：https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
				logger.info("fallback，reason was：", cause);
				User user = new User();
				user.setId(-1L);
				user.setName("默认用户");
				
				return user;
			}
		};
	}
	
}

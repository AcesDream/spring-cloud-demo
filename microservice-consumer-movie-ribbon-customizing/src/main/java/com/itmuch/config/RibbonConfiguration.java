package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 参考：https://spring.io/guides/gs/client-side-load-balancing/
 * 
 * http://blog.csdn.net/w_x_z_/article/details/71104640
 * 这样就可以实现自定义负载均衡策略，注意如果该配置文件在主应用程序的上下文中，
 * 则该规则应用于所有的ribbon客户端
 * @author lxy
 *
 */
@Configuration
public class RibbonConfiguration {
	
	@Bean
	public IRule ribbonRule() {
		//负载均衡规则调整为随机
		return new RandomRule();
	}
}

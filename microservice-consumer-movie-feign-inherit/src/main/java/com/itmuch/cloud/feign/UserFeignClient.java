package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itmuch.cloud.api.UserService;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient extends UserService {
}

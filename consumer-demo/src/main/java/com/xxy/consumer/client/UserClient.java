package com.xxy.consumer.client;

import com.xxy.consumer.conf.FeignConfig;
import com.xxy.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service",configuration = FeignConfig.class)
public interface UserClient {

    @RequestMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}

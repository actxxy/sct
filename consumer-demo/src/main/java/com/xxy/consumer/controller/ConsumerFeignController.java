package com.xxy.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xxy.consumer.client.UserClient;
import com.xxy.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cf")
@DefaultProperties(defaultFallback = "defaultFallback")//配置该类所有方法的降级方法
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    @HystrixCommand
    public String queryById(@PathVariable Long id) {
        return userClient.queryById(id).toString();
    }
    public String defaultFallback() {
        return "对不起查询失败，请稍后再次尝试。";
    }

}

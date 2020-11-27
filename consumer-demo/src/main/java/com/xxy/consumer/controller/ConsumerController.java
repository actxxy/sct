package com.xxy.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.xxy.consumer.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")//配置该类所有方法的降级方法
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    @HystrixCommand
    public String queryById(@PathVariable Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
//        不再尝试手动获取ip和端口而是通过服务名直接获取
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url,User.class).toString();
    }

    public String queryByIdFallback(Long id) {
        log.error("查询用户信息失败。id: {}",id);
        return "网络拥挤，查询失败。";
    }

    public String defaultFallback() {
        return "对不起查询失败，请稍后再次尝试。";
    }

}

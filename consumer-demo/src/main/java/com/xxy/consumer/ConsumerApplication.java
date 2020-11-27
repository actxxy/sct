package com.xxy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker // 开启熔断
@EnableFeignClients // 开启Feign功能
@SpringCloudApplication // 以上三个组合注解已经在这个注解中了
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    //因为Fegin内部引入了Ribbon所以不需要再注册RestTemplate对象
    @Bean
    @LoadBalanced // 开启Ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

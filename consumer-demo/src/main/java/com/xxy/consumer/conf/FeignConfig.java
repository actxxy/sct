package com.xxy.consumer.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        // 记录所有请求和相应的明细，包括头信息
        return Logger.Level.FULL;
    }
}

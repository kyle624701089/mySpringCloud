package com.kyle.servicefeign.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @ ClassName: FeignConfig
 * @ Description: 用于feign客户端的配置类
 * @ author: Administrator
 * @ date: 2018/9/2 21:54
 * @ version: 1.0
 **/
@Configuration
public class FeignConfig {

    /**
    * @ author: Administrator
    * @ Description: 第一个参数period是请求重试的间隔算法参数，第二个参数maxPeriod 是请求间隔最大时间，第三个参数是重试的次数
    * @ params: []
    * @ date: 22:06 2018/9/2
    * @ return: feign.Retryer
    **/
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}

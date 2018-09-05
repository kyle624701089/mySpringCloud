package com.kyle.serviceribbon.service.serviceImpl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ ClassName: HelloService
 * @ Description: TODO
 * @ author: Administrator
 * @ date: 2018/9/2 17:11
 * @ version: 1.0
 **/
@Service
public class HelloService {
    @Resource
    public RestTemplate restTemplate;

    /**
    * @ author: Administrator
    * @ Description: 加了断路器注解 ，当该service方法报错时，5秒调用20次就会触发fallbackMethod 指向的方法
    * @ params: [name]       
    * @ date: 22:39 2018/9/4
    * @ return: java.lang.String
    **/        
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "hello " + name + " ! There are some errors happend!";
    }
}

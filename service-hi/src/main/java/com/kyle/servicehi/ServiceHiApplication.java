package com.kyle.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    /**
     * 通过 @Value 注解读取yml配置文件中的端口信息
     */
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String helloWorld(@RequestParam(value = "name",defaultValue = "kyle")String name) {
        return "hi " + name + "! ,i`m from port " + port;
    }
}

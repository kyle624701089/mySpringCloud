package com.kyle.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunkai-019
 * @title: CloudConfigController
 * @projectName cloudConfig
 * @description: TODO
 * @date 2021/6/29 20:43
 */
@RestController
@RequestMapping
public class CloudConfigController {

    /**
     * spring中通过@Value注解可以从配置文件中获取属性值
     * 此处是通过yml中配置的配置中心地址http://localhost:8888/获取
     * 该配置中心又是连接的GitHub的某个分支配置文件
     * 所以间接地，获取到了远端仓库中的配置信息
     */
    @Value("${foo}")
    String foo;

    @GetMapping("/foo")
    public String foo() {
        return foo;
    }
}

package com.kyle.servicefeign.service.impl;

import com.kyle.servicefeign.service.DemoHiServiceFeign;
import org.springframework.stereotype.Component;

/**
 * @author sunkai-019
 * @title: DemoHiServiceFeignImpl
 * @projectName mySpringCloud
 * @description: TODO
 * @date 2021/6/25 22:28
 */
@Component
public class DemoHiServiceFeignImpl implements DemoHiServiceFeign {
    @Override
    public String demoHiServiceFeign(String name) {
        return "service-feign 服务调用 demoHi 服务失败";
    }
}

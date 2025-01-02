package com.libraryforusers.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class ConsulController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有的服务
     * @return
     */
    @RequestMapping("services")
    public Object getServices(){

        List<ServiceInstance> instances = discoveryClient.getInstances("admin-center");
        System.out.println(instances.toString());
        return instances;
    }

}

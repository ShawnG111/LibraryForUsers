package com.libraryforusers.controller;

import com.libraryforusers.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestController {

    @Autowired
    private RestTemplate loadBalancedRestTemplate;
    @Autowired
    private ApiService apiService;

    public static final String DATA_CENTER_URL = "http://admin-center";

    @RequestMapping("/testA")
    @ResponseBody
    public String testA(){
        return loadBalancedRestTemplate.getForObject(DATA_CENTER_URL + "/api/test", String.class);
    }

    @RequestMapping("/testB")
    @ResponseBody
    public String testB(){
        return apiService.test();
    }

}

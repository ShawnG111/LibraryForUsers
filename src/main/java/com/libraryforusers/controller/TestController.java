package com.libraryforusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TestController {

    @Autowired
    private RestTemplate loadBalancedRestTemplate;

    public static final String DATA_CENTER_URL = "http://admin-center";

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return loadBalancedRestTemplate.getForObject(DATA_CENTER_URL + "/api/test", String.class);
    }

}

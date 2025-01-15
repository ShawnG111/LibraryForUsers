package com.libraryforusers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RefreshScope
public class CommonConfig {
    @Value("${common.name:TestName}")
    private String name = "TestName";
    @Value("${common.code:0}")
    private String code = "0";

    @PostConstruct
    public void postConstruct() {
        System.out.println("name:" + name);
        System.out.println("code:" + code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

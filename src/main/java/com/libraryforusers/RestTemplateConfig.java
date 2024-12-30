package com.libraryforusers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    RestTemplate restTemplate() {
        OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();
        okHttp3ClientHttpRequestFactory.setConnectTimeout(10*1000);
        okHttp3ClientHttpRequestFactory.setReadTimeout(25*1000);
        okHttp3ClientHttpRequestFactory.setWriteTimeout(25*1000);
        return new RestTemplate(okHttp3ClientHttpRequestFactory);
    }
}

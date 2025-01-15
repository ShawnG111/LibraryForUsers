package com.libraryforusers.service;

import com.libraryforusers.service.impl.Fallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(contextId = "demo", name = "admin-center", fallback = Fallback.class)
public interface ApiService {
    String API_URL_PREFIX = "api";

    @PostMapping(API_URL_PREFIX + "/test")
    String test();

    @PostMapping(API_URL_PREFIX + "/getBookList")
    Map<String, Object> getBookList(@RequestParam("checkString") String checkString,@RequestParam("page") int page,@RequestParam("rows") int rows);

}

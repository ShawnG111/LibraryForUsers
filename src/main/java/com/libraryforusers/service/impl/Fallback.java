package com.libraryforusers.service.impl;

import com.libraryforusers.service.ApiService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Component
public class Fallback implements ApiService {

    @Override
    public String test(){
        return "failed";
    }

    @Override
    public Map<String, Object> getBookList(@RequestParam("checkString") String checkString,@RequestParam("page") int page,@RequestParam("rows") int rows){
        Map ResultMap = new HashMap();
        ResultMap.put("status", "failed");
        return ResultMap;
    }
}

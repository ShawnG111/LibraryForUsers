package com.libraryforusers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libraryforusers.service.ApiService;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private RestTemplate loadBalancedRestTemplate;
    @Autowired
    private ApiService apiService;

    public static final String DATA_CENTER_URL = "http://admin-center";

    @RequestMapping("")
    public String bookList(Model model) {
        model.addAttribute("page", 1);
        return "bookList";
    }

//    @RequestMapping("/getBookList")
//    @ResponseBody
//    public Map<String, Object> getBookList(String checkString, int page, int rows) {
//        Map<String, Object> resultMap = new HashMap<>();
//        Map likeMap = new HashMap();
//        likeMap.put("bookId", checkString);
//        likeMap.put("bookName", checkString);
//        likeMap.put("author", checkString);
//        likeMap.put("typeId", checkString);
//        PageHelper.startPage(page, rows);
//        List<BookDO> list = bookService.checkLike(likeMap);
//        PageInfo pageInfo = new PageInfo(list);
//        resultMap.put("resultData", list);
//        resultMap.put("pageNum", pageInfo.getPages());
//        return resultMap;
//    }

    @RequestMapping("/getBookList")
    @ResponseBody
    public Map getBookList(String checkString, int page, int rows) {
        return apiService.getBookList(checkString, page, rows);
    }

}
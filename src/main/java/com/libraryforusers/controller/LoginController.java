package com.libraryforusers.controller;

import com.libraryforusers.domain.UserDO;
import com.libraryforusers.service.UserService;
import com.libraryforusers.utils.MD5;
import com.libraryforusers.utils.VerifyUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    String welcome(Integer register, Model model) {
        model.addAttribute("register", register);
        return "login";
    }
//
//    @RequestMapping("/login")
//    String login(HttpServletRequest request, long phoneNum, String password, Model model){
//        Map userPhoneMap = new HashMap();
//        userPhoneMap.put("phoneNum", phoneNum);
//        if (userService.count(userPhoneMap)==0){
//            model.addAttribute("message", "用户名或密码错误");
//            return "login";
//        }
//        if (!userService.check(userPhoneMap).getPassword().equals(MD5.md5(password))){
//            model.addAttribute("message", "用户名或密码错误");
//            return "login";
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("userId", userService.check(userPhoneMap).getUserId());
//        session.setAttribute("administrator", userService.check(userPhoneMap).getAdministrator());
//        session.setAttribute("userName", userService.check(userPhoneMap).getUserName());
//        model.addAttribute("userName", session.getAttribute("userName"));
//        return "menu";
//    }

    @RequestMapping("/login")
    @ResponseBody
    Map login(HttpServletRequest request, long phoneNum, String password, String verifyCode) {
        HttpSession session = request.getSession();
        Map resultMap = new HashMap();
        Map userPhoneMap = new HashMap();
        userPhoneMap.put("phoneNum", phoneNum);
        if (userService.count(userPhoneMap)==0){
            resultMap.put("success", "0");
            resultMap.put("status", 1);
            return resultMap;
        }
        if (!userService.check(userPhoneMap).getPassword().equals(MD5.md5(password))){
            resultMap.put("success", "0");
            resultMap.put("status", 2);
            return resultMap;
        }
        if (!verifyCode.equals(session.getAttribute("code"+session.getId()))){
            resultMap.put("success", "0");
            resultMap.put("status", 3);
            return resultMap;
        }
        resultMap.put("success", "1");
        session.setAttribute("userId", userService.check(userPhoneMap).getUserId());
        session.setAttribute("administrator", userService.check(userPhoneMap).getAdministrator());
        session.setAttribute("userName", userService.check(userPhoneMap).getUserName());
        return resultMap;
    }

//    @RequestMapping("/register")
//    String register(UserDO userDO, Model model){
//        userDO.setPassword(MD5.md5(userDO.getPassword()));
//        if(!userService.add(userDO)){
//            model.addAttribute("message", "用户已存在");
//            return "register";
//        }
//        return "login";
//    }

    @RequestMapping("/register")
    @ResponseBody
    Map register(long phoneNum, String userName, String email, String password, String verifyCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map resultMap = new HashMap();
        UserDO userDO = new UserDO();
        userDO.setPhoneNum(phoneNum);
        userDO.setUserName(userName);
        userDO.setEmail(email);
        userDO.setPassword(MD5.md5(password));
        if (!verifyCode.equals(session.getAttribute("code"+session.getId()))){
            resultMap.put("success", "0");
            resultMap.put("status", 2);
            return resultMap;
        }
        if(!userService.add(userDO)){
            resultMap.put("success", "0");
            resultMap.put("status", 1);
            return resultMap;
        }
        resultMap.put("success", "1");
        return resultMap;
    }

    @RequestMapping("/registerPage")
    String registerPage(){
        return "register";
    }

    @RequestMapping("/getVerify")
    @ResponseBody
    public void getVerify(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String id = session.getId();
        Object[] objects = VerifyUtil.newBuilder().build().createImage();
        session.setAttribute("code"+id, objects[0]);

        BufferedImage image = (BufferedImage) objects[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

    @RequestMapping("/menu")
    String menu(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("userName", session.getAttribute("userName"));
        return "menu";
    }

}

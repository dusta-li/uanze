package com.lqh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/index.html")
    public ModelAndView get(HttpSession session){
        Object username = session.getAttribute("username");
        if(username == null){
            username = "zhangsan";
            session.setAttribute("username",username);
        }

        ModelMap modelMap = new ModelMap("message", "个人信息简介")
                .addAttribute("username",username)
                .addAttribute("title","userInfo")
                .addAttribute("date",new Date())
                .addAttribute("foot","banana");

        return new ModelAndView("index",modelMap);
    }
}

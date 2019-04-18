package com.zhangjie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/***
 * @author zhangjie
 * @date 2019/4/16 10:11
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/index.page")
    public ModelAndView index(){
        return new ModelAndView("admin");
    }

}

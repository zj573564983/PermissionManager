package com.zhangjie.controller;

import com.zhangjie.common.JsonData;
import com.zhangjie.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @author zhangjie
 * @date 2019/4/10 10:42
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
//        return "hello,permission";
        throw new PermissionException("test exception");
        //return JsonData.success("hello,permission");
    }
}

package com.zhangjie.controller;

import com.zhangjie.common.ApplicationContextHelper;
import com.zhangjie.common.JsonData;
import com.zhangjie.dao.SysAclModuleMapper;
import com.zhangjie.exception.ParamException;
import com.zhangjie.exception.PermissionException;
import com.zhangjie.model.SysAclModule;
import com.zhangjie.param.TestVo;
import com.zhangjie.util.BeanValidator;
import com.zhangjie.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
        //return JsonData.fail("test json exception");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
        SysAclModuleMapper moduleMapper= ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module=moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}

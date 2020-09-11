package com.cms.portal.controller.admin;

import com.cms.service.api.ITestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private ITestService testService;

    @RequestMapping("test")
    public String test(){
       return "/admin/test/index";
    }

}

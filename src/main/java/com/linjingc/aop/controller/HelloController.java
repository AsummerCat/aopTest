package com.linjingc.aop.controller;

import com.linjingc.aop.annotation.UserAop;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cxc
 * @date 2018/11/26 13:37
 */
@RestController
public class HelloController {


    @RequestMapping("/")
    public String index() {
        System.out.println("随便输出一下");
        return "hello";
    }

    @UserAop
    @RequestMapping("/aop")
    public String aop() throws Exception {
        Thread.sleep(2000);
        System.out.println("loading");
        return "aop切入成功";
    }


    @RequestMapping("errorTest")
    public String errorTest() {
        System.out.println("随便输出一下");
        int i=1/0;
        return "哈哈输出错误";
    }

}

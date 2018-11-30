package com.linjingc.aop.controller1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cxc
 * @date 2018/11/26 13:37
 */
@RestController
@RequestMapping("test2")
public class Test2Controller {
    @RequestMapping("/")
    public String index() {
        System.out.println("随便输出一下");
        int i = 1 / 0;
        return "hello";
    }
}

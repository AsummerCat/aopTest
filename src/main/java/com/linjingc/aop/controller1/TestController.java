package com.linjingc.aop.controller1;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cxc
 * @date 2018/11/26 13:37
 */
@RestController
@RequestMapping("test")
@Log4j2
public class TestController {
    //这里表示捕获ArithmeticException.class的异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    String handleException2(Exception e) {
        log.info("输出异常{}", e);
        return "ArithmeticException Deal!" + e.getMessage();
    }

    @RequestMapping("/")
    public String index() {
        System.out.println("随便输出一下");
        int i = 1 / 0;
        return "hello";
    }
}

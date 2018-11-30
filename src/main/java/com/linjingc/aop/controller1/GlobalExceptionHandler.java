package com.linjingc.aop.controller1;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller全局异常捕获
 *
 * @author cxc
 */
@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {


    //这里表示捕获Exception.class的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    String handleException(Exception e) {
        log.info("输出异常{}", e);
        return "Exception Deal!" + e.getMessage();
    }

    //这里表示捕获RuntimeException.class的异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    String handleException1(Exception e) {
        log.info("输出异常{}", e);
        return "RuntimeException Deal!" + e.getMessage();
    }

    //这里表示捕获ArithmeticException.class的异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    String handleException2(Exception e) {
        log.info("输出异常111{}", e);
        return "ArithmeticException Deal!" + e.getMessage();
    }
}
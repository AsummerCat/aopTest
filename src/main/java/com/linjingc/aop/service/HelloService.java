package com.linjingc.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author cxc
 * @date 2018/12/13 14:23
 */
@Service
public class HelloService {

    public void index() {
        System.out.println("index");
    }
}

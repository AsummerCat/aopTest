package com.linjingc.aop.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author cxc
 * @date 2018/11/26 13:53
 */
@Documented
@Component
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAop {
    //这里需要注意  interface前面要加上@  这里表示这个interface 是一个注解
}

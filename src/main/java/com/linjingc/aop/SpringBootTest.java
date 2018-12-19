package com.linjingc.aop;

import com.linjingc.aop.controller.HelloController;
import com.linjingc.aop.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author cxc
 * @date 2018/12/13 14:18
 */
//@ComponentScan(basePackageClasses = {HelloController.class})
@EnableAspectJAutoProxy
@ComponentScan
public class SpringBootTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBootTest.class);

        //HelloService bean = applicationContext.getBean(HelloService.class);
        //HelloService bean = (HelloService)applicationContext.getBean("hello");
        HelloController bean = applicationContext.getBean(HelloController.class);
        bean.index();
    }
}

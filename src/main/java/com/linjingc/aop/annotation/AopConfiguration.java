package com.linjingc.aop.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @author cxc
 * @date 2018/11/26 14:00
 */
@Aspect
@Configuration
public class AopConfiguration {
    private final Log log = LogFactory.getLog(this.getClass());


    //声明个切面，切哪呢？切到 com.linjingc.aop.controller 这个目录下，以save开头的方法，方法参数(..)和返回类型(*)不限
    // @Pointcut("execution(* com.lxk.service.StudentService.save*(..))")

    //这里是表示 切到这个目录下的所有方法--并且 有带NeeLogin这个方法
    // @Pointcut("execution(public * com.biniu.yxx.controller.*.*(..)) && @annotation(com.biniu.yxx.annotation.NeedLogin)")

    @Pointcut("execution(* com.linjingc.aop.controller.*.*(..))")
    private void executeService() {
    }

    /**
     * 前置通知
     */
    @Before("executeService()")
    public void before(JoinPoint joinPoint) {
        String s = joinPoint.toString();
        System.out.println(s);
        System.out.println("before method   start ...");

        System.out.println("before method   end ...");
    }


    /**
     * 环绕通知
     * 这里表示所有使用这个注解的方法都会被切入
     *
     *         如果不返回   return pjp.proceed(); 则不执行目标方法
     *
     * @param
     */
    @Around("@annotation(UserAop)")
    public void around(ProceedingJoinPoint pjp) {
        String s = pjp.toString();
        System.out.println(s);
        System.out.println("around method   start ...");
        try {
            //return
             pjp.proceed();
            //return "A"; //这里因为注释掉了 原本的返回 所以A直接返回给页面
            System.out.println("结束");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //return null;
        } finally {
            System.out.println("around method   end ...");
        }
    }

    //当定义一个Around增强处理方法时，该方法的第一个形参必须是 ProceedingJoinPoint 类型，
    // 在增强处理方法体内，调用ProceedingJoinPoint的proceed方法才会执行目标方法------这就是@Around增强处理可以完全控制目标方法执行时机、如何执行的关键；
    // 如果程序没有调用ProceedingJoinPoint的proceed方法，则目标方法不会执行。

    //@Around("addAdvice()")
    //public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
    //    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    //    ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
    //    HttpServletRequest request = sra.getRequest();
    //    Long staffId = (Long) request.getAttribute("staffId");
    //    if (staffId == null) {
    //        JsonResult jsonResult = new JsonResult();
    //        jsonResult.setMsg("请先登录");
    //        jsonResult.setStatus("-112");
    //        return jsonResult;
    //    } else {
    //        return pjp.proceed();
    //    }
    //}

    /**
     * 被切入后 目标执行完毕后 必定会执行
     *
     * @param joinPoint
     */
    @AfterReturning("executeService()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After method   start ...");

        System.out.println("After method   end ...");
    }


    /**
     * 在目标执行完毕返回通知
     */
    @AfterReturning("executeService()")
    public void afterRunning() {
        System.out.println("AfterRunning method   start ...");

        System.out.println("AfterRunning method   end ...");
    }


    /**
     * 在目标执行完毕返回通知
     */
    @AfterThrowing(value = "executeService()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("afterThrowing method   start ...");

        System.out.println("afterThrowing method   end ...");
    }
}

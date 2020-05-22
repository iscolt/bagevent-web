package com.iscolt.bageventweb.aspect;

import com.iscolt.bageventweb.service.UserLoginLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.iscolt.bageventweb.common.utils.ConstantUtils.USER_SESSION_KEY;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/22
 * @see: com.iscolt.bageventweb.aspect
 * @version: v1.0.0
 */

@Component
@Aspect
public class LogAspect {

    @Resource
    private UserLoginLogService userLoginLogService;

    @Resource
    private HttpServletRequest servletRequest;

    @Pointcut("@within(com.iscolt.bageventweb.aspect.LoginLog) || @annotation(com.iscolt.bageventweb.aspect.LoginLog)")
    public void pointcut() {
    }


    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "开始执行");
    }

    @After(value = "pointcut()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        String account = String.valueOf(servletRequest.getSession().getAttribute(USER_SESSION_KEY));
        Boolean aBoolean = userLoginLogService.sendLoginLogMsg(account, servletRequest);
        System.out.println(name + "结束执行");
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "返回" + result);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "抛出异常" + e.getMessage());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return proceedingJoinPoint.proceed();
    }
}

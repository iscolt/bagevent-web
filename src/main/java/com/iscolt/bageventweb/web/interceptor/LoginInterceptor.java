package com.iscolt.bageventweb.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.iscolt.bageventweb.common.utils.ConstantUtils.USER_SESSION_KEY;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.web.interceptor
 * @version: v1.0.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object obj = request.getSession().getAttribute(USER_SESSION_KEY);

        // 未登录
        if (obj == null) {
            if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/reg")) {
                return true;
            }
            response.sendRedirect("/login");
            return false;
        } else {
            // 不等于空
            if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/reg")) {
                response.sendRedirect("/index");
            }
            // 放行
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}

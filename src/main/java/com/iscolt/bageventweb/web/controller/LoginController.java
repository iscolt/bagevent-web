package com.iscolt.bageventweb.web.controller;

import com.iscolt.bageventweb.common.utils.SysUtils;
import com.iscolt.bageventweb.model.entity.User;
import com.iscolt.bageventweb.model.entity.UserLoginLog;
import com.iscolt.bageventweb.model.param.RegParam;
import com.iscolt.bageventweb.service.UserLoginLogService;
import com.iscolt.bageventweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import static com.iscolt.bageventweb.common.utils.ConstantUtils.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登陆控制
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.web.controller
 * @version: v1.0.0
 */
@Controller
public class LoginController {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private UserService userService;

    @Resource
    private UserLoginLogService userLoginLogService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    /**
     * 跳转登录页面
     * @return
     */

    @RequestMapping(value = "reg", method = RequestMethod.GET)
    public String reg(){
        return "reg";
    }

    /**
     * 去首页
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @PostMapping(value = "login")
    public String login(String account, String password, Model model){
        Boolean aBoolean = false;
        if (SysUtils.isEmail(account)) {
            // 邮箱登陆
            aBoolean = userService.loginByEmail(account, password);
        }

        else if (SysUtils.isCellPhone(account)) {
            // 手机登陆
            aBoolean = userService.loginByCellPhone(account, password);
        }

        if (aBoolean) {
            // 将登录信息放入会话
            httpServletRequest.getSession().setAttribute(USER_SESSION_KEY, account);
            model.addAttribute(USER_SESSION_KEY, account);
            return "redirect:/index";
        }

        model.addAttribute(USER_LOGIN_ERROR, "登陆失败！");
        return login();
    }

    /**
     * 注册
     * @param regParam
     * @param model
     * @return
     */
    @PostMapping(value = "reg")
    public String reg(RegParam regParam, Model model) {
        String message = "";
        User user = new User();
        user.setUserName(regParam.getUserName());
        user.setPassword(regParam.getPassword());
        if (SysUtils.isEmail(regParam.getAccount())) {
            // 邮箱注册
            user.setEmail(regParam.getAccount());
            message = userService.regByEmail(user);
        }

        else if (SysUtils.isCellPhone(regParam.getAccount())) {
            // 手机注册
            user.setCellphone(regParam.getAccount());
            message = userService.regByCellPhone(user);
        }

        else {
            message = "邮箱或手机格式错误！";
        }

        model.addAttribute(MESSAGE, message);
        return reg();
    }

    /**
     * 注销
     * @return
     */
    @GetMapping(value = "logout")
    public String logout(){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}

package com.iscolt.bageventweb.common.utils;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.common.utils
 * @version: v1.0.0
 */
public class SysUtils {

    /**
     * 判断是否是邮箱
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null) {
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断是否是手机
     * @param cellPhone
     * @return
     */
    public static boolean isCellPhone(String cellPhone) {
        if (cellPhone == null) {
            return false;
        }
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(cellPhone);
        return m.matches();
    }

}

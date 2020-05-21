package com.iscolt.bageventweb.service;

import com.iscolt.bageventweb.model.entity.User;
import com.iscolt.bageventweb.model.entity.UserLoginLog;

/**
 * 用户业务接口
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.service
 * @version: v1.0.0
 */
public interface UserService {

    /**
     * 添加
     * @param user
     * @return
     */
    User create(User user);

    /**
     * 通过邮箱查询
     * @return
     */
    User selectByEmail(String email);

    /**
     * 通过手机号查询
     * @return
     */
    User selectByCellPhone(String cellPhone);

    /**
     * 邮箱登陆
     * @param email
     * @return
     */
    Boolean loginByEmail(String email, String password);

    /**
     * 手机登陆
     * @param cellPhone
     * @return
     */
    Boolean loginByCellPhone(String cellPhone, String password);

    /**
     * 邮箱注册
     * @param user
     * @return
     */
    String regByEmail(User user);

    /**
     * 手机注册
     * @param user
     * @return
     */
    String regByCellPhone(User user);
}

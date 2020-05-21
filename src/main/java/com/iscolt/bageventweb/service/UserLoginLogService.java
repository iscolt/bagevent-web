package com.iscolt.bageventweb.service;

import com.iscolt.bageventweb.model.entity.User;
import com.iscolt.bageventweb.model.entity.UserLoginLog;

import java.util.List;

/**
 * 用户登陆日志业务接口
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.service
 * @version: v1.0.0
 */
public interface UserLoginLogService {

    /**
     * 添加
     * @param userLoginLog
     * @return
     */
    UserLoginLog create(UserLoginLog userLoginLog);

    /**
     * 查询全部
     * @return
     */
    List<UserLoginLog> listAll();

    /**
     * 更具用户id查询
     * @param userId
     * @return
     */
    List<UserLoginLog> listByUserId(Integer userId);
}

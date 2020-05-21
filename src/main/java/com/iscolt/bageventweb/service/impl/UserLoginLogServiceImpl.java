package com.iscolt.bageventweb.service.impl;

import com.iscolt.bageventweb.model.entity.UserLoginLog;
import com.iscolt.bageventweb.repository.UserLoginLogRespository;
import com.iscolt.bageventweb.service.UserLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登陆业务
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.service.impl
 * @version: v1.0.0
 */
@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {

    @Resource
    private UserLoginLogRespository userLoginLogRespository;

    @Override
    public UserLoginLog create(UserLoginLog userLoginLog) {
        return userLoginLogRespository.save(userLoginLog);
    }

    @Override
    public List<UserLoginLog> listAll() {
        return userLoginLogRespository.findAll();
    }

    @Override
    public List<UserLoginLog> listByUserId(Integer userId) {
        return userLoginLogRespository.findAllByUserId(userId);
    }
}

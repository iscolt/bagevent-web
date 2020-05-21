package com.iscolt.bageventweb.service.impl;

import com.iscolt.bageventweb.model.entity.User;
import com.iscolt.bageventweb.repository.UserRepository;
import com.iscolt.bageventweb.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * 用户业务
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
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        // 密码md5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userRepository.save(user);
    }

    @Override
    public User selectByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User selectByCellPhone(String cellPhone) {
        return userRepository.findByCellphone(cellPhone);
    }

    @Override
    public Boolean loginByEmail(String email, String password) {
        User user = selectByEmail(email);
        if (null != user) {
            return user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        return false;
    }

    @Override
    public Boolean loginByCellPhone(String cellPhone, String password) {
        User user = selectByCellPhone(cellPhone);
        if (null != user) {
            return user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        return false;
    }

    @Override
    public String regByEmail(User user) {
        User result = selectByEmail(user.getEmail());
        if (result != null) {
            return "用户已存在！";
        }
        create(user);
        return "注册成功";
    }

    @Override
    public String regByCellPhone(User user) {
        User result = selectByCellPhone(user.getCellphone());
        if (result != null) {
            return "用户已存在！";
        }
        create(user);
        return "注册成功";
    }

}

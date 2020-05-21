package com.iscolt.bageventweb.repository;

import com.iscolt.bageventweb.model.entity.UserLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户登陆日志持久层
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.repository
 * @version: v1.0.0
 */
public interface UserLoginLogRespository extends JpaRepository<UserLoginLog, Integer> {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<UserLoginLog> findAllByUserId(int userId);
}

package com.iscolt.bageventweb.repository;

import com.iscolt.bageventweb.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.repository
 * @version: v1.0.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过邮箱查询
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 通过手机查询
     * @param cellphone
     * @return
     */
    User findByCellphone(String cellphone);
}

package com.iscolt.bageventweb.model.entity;

import com.iscolt.bageventweb.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 用户类
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.model.entity
 * @version: v1.0.0
 */
@Data
@Entity
public class User extends BaseEntity implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "cellphone")
    private String cellphone;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "salt")
    private String salt;
    /**
     * 0 删除， 1正常
     */
    @Basic
    @Column(name = "state")
    private boolean state;

    /**
     * 初始化执行
     */
    @PrePersist
    protected void prePersist() {
        super.prePersist();
        state = true;
    }
}

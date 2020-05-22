package com.iscolt.bageventweb.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iscolt.bageventweb.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 用户登陆日志类
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
@Table(name = "user_login_log", schema = "bagevent_test", catalog = "")
public class UserLoginLog implements Serializable {

    @Id
    @Column(name = "login_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loginId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "login_ip")
    private String loginIp;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 初始化执行
     */
    @PrePersist
    protected void prePersist() {
        if (createTime == null) {
            createTime =  new Timestamp(new Date().getTime());;
        }
    }

}

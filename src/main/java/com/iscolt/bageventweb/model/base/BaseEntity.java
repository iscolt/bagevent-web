package com.iscolt.bageventweb.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.model.base
 * @version: v1.0.0
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

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

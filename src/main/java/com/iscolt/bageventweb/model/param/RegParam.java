package com.iscolt.bageventweb.model.param;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/isColt
 * @date: 2020/5/21
 * @see: com.iscolt.bageventweb.model.param
 * @version: v1.0.0
 */
@Data
public class RegParam implements Serializable {
    private String userName;
    // email 或者手机号
    private String account;
    private String password;
}

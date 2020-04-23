package com.bdqn.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 林国贝
 * @since 2020-04-23
 */
@TableName("sys_role_user")
public class RoleUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色编号
     */
    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    /**
     * 用户编号
     */
    private Integer uid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "RoleUser{" +
        "rid=" + rid +
        ", uid=" + uid +
        "}";
    }
}

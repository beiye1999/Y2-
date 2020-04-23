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
@TableName("sys_role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer rid;

    private Integer pid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "rid=" + rid +
        ", pid=" + pid +
        "}";
    }
}

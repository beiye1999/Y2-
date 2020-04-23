package com.bdqn.sys.service;

import com.bdqn.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 林国贝
 * @since 2020-04-23
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    User findUserByUserName(String userName) throws Exception;
}

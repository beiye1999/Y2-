package com.bdqn.sys.controller;


import com.bdqn.common.utils.JSONResult;

import com.bdqn.common.utils.SystemConstant;
import com.bdqn.sys.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 林国贝
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @PostMapping("/login")
    public JSONResult login(String loginname, String pwd, HttpSession session){
        try {
            //获取当前登录主体对象
            Subject subject= SecurityUtils.getSubject();
            //创建令牌对象
            UsernamePasswordToken token =new UsernamePasswordToken(loginname,pwd);
            //登录
            subject.login(token);
            //获取当前登录对象
            LoginUserVo userVo= (LoginUserVo) subject.getPrincipal();
            userVo.getUser().setLoginpwd(null);//session作用域中不保存密码会更安全
            //保存session
            session.setAttribute(SystemConstant.LOGINUSER,userVo.getUser());
            //登录成功
            return  SystemConstant.LOGIN_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //登录失败，用户名或密码错误
        return SystemConstant.LOGIN_ERROR_PASS;
    }
}


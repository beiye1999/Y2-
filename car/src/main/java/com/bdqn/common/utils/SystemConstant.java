package com.bdqn.common.utils;

public interface SystemConstant {


    /**
     * 当前登录用户的key
     */
    String LOGINUSER = "loginUser";

    /**
     * 成功
     */
    Boolean OK = true;

    /**
     * 失败
     */
    Boolean ERROR = false;


    /**
     * 登录成功
     */
    JSONResult LOGIN_SUCCESS = new JSONResult(SystemConstant.OK,"登录成功");
    /**
     * 登录失败，用户名或密码错误
     */
    JSONResult LOGIN_ERROR_PASS = new JSONResult(SystemConstant.ERROR,"登录失败,用户名或密码错误");

    /**
     * 查询菜单类型为menu
     */
    String TYPE_MENU="menu";

    /**
     * 是否展开，1展开
     */
    Integer STATE_OPEN=1;

    /**
     * 用户角色类型0为超级管理员
     */
    Integer USER_TYPE_SUPER=0;

    /**
     * 操作公告的状态
     */
    JSONResult EDI_SUCCESS=new JSONResult(true,"操作成功");
    JSONResult EDI_ERROR=new JSONResult(false,"操作失败");
    String EXIST = "exist";
}
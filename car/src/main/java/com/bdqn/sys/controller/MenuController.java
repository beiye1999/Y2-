package com.bdqn.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bdqn.common.utils.*;
import com.bdqn.sys.entity.Permission;
import com.bdqn.sys.entity.User;
import com.bdqn.sys.service.PermissionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Resource
    private PermissionService permissionService;

    /**
     * 加载左侧菜单栏
     * @param page
     * @param httpSession
     * @return
     */
    @RequestMapping("/loadIndexLeftMenu")
    public Result loadIndexLeftMenu(Page page, HttpSession session){
        List<Permission> permissionList=new ArrayList<Permission>();
        //创建条件构造器
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        queryWrapper.eq("type",SystemConstant.TYPE_MENU);//只查询type=menu的数据

        //获取当前用户信息
        User user= (User) session.getAttribute(SystemConstant.LOGINUSER);
        //调用方法前判断当前是否是超级管理员，超级管理员可1查看所有菜单
        if(user.getType()==SystemConstant.USER_TYPE_SUPER) {
            //调用查询菜单列表的方法
            permissionList = permissionService.list(queryWrapper);
        }else{
            //如果不是超级管理员，需要根据当前拥有的角色和授权查询菜单
            permissionList = permissionService.list(queryWrapper);
        }

        //创建菜单节点集合
        List<TreeNode> treeNodes=new ArrayList<TreeNode>();
        //for循环遍历菜单集合


        for (Permission permission:permissionList) {
            TreeNode treeNode=new TreeNode();
            treeNode.setId(permission.getId());//菜单Id
            treeNode.setPid(permission.getPid());//父带单id
            treeNode.setTitle(permission.getTitle());//菜单名称
            treeNode.setHref(permission.getHref());//跳转url
            //判断是否展开，0表示展开
            Boolean spread=permission.getOpen()==SystemConstant.STATE_OPEN?true:false;
            treeNode.setSpread(spread);//是否展开
            //将菜单节点信息添加到菜单节点集合中
            treeNodes.add(treeNode);
        }
        //构建菜单节点层级关系
        List<TreeNode> treeNodeList= TreeNodeBuilder.build(treeNodes,1);
        //返回数据
        return  new Result(treeNodeList);
    }

}

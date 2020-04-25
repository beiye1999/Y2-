package com.bdqn.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SystemController {

    /**
     * 去到后台首页
     * @return
     */
    @RequestMapping("/index")
    public  String toIndex(){
        return  "system/home/index";
    }

    /**
     * 去到工作台
     * @return
     */
    @RequestMapping("/toDesktopManager")
    public  String desktopManager(){
        return  "system/home/desktopManager";
    }

    /**
     * 去到公告管理页面
     * @return
     */
    @RequestMapping("/toNoticeManager")
    public String toNoticeManager(){
        return  "system/notice/noticeManager";
    }

    /**
     * 去到部门管理页面
     * @return
     */
    @RequestMapping("/toDeptManager")
    public String toDeptManager(){
        return  "system/dept/deptManager";
    }


    /**
     * 去到部门管理页面-left
     * @return
     */
    @RequestMapping("/toDeptLeft")
    public String toDeptLeft(){
        return  "system/dept/left";
    }

    /**
     * 去到部门管理页面-right
     * @return
     */
    @RequestMapping("/toDeptRight")
    public String toDeptRight(){
        return  "system/dept/right";
    }
}

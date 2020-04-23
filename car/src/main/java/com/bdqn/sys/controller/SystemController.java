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


    @RequestMapping("/toDesktopManager")
    public  String desktopManager(){
        return  "system/home/desktopManager";
    }
}

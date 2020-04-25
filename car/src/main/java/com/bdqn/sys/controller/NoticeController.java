package com.bdqn.sys.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.common.utils.JSONResult;
import com.bdqn.common.utils.SystemConstant;
import com.bdqn.sys.entity.User;
import com.bdqn.sys.utils.DataGridViewResult;
import com.bdqn.sys.entity.Notice;
import com.bdqn.sys.service.NoticeService;
import com.bdqn.sys.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 林国贝
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/sys/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @RequestMapping("/list")
    public DataGridViewResult list(NoticeVo noticeVo){
        //创建分页对象
        IPage<Notice> pages=new Page<Notice>(noticeVo.getPage(),noticeVo.getLimit());
        //创建条件构造器
        QueryWrapper<Notice>queryWrapper=new QueryWrapper<Notice>();
        //标题
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()),"title",noticeVo.getTitle());
        //发布人
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getOpername()),"opername",noticeVo.getOpername());
        //开始时间
        queryWrapper.ge(noticeVo.getStartTime()!=null,"createtime",noticeVo.getStartTime());
        //结束时间
        queryWrapper.le((noticeVo.getEndTime()!=null),"emdtime",noticeVo.getEndTime());
        //按照创建时间降序
        queryWrapper.orderByDesc("createtime");
        //调用查询的方法
        noticeService.page(pages,queryWrapper);
        //返回结果
        return new DataGridViewResult(pages.getTotal(), pages.getRecords());
    }

    @PostMapping("/addNotice")
    public JSONResult addNotice(Notice notice, HttpSession session){
        User user= (User) session.getAttribute(SystemConstant.LOGINUSER);
        notice.setCreatetime(new Date());//创建时间
        notice.setOpername(user.getName());//发布人
        if(noticeService.save(notice)){
            return SystemConstant.EDI_SUCCESS;
        }
        return SystemConstant.EDI_ERROR;
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @RequestMapping("/updateNotice")
    public JSONResult updateNotice(Notice notice){
        notice.setModifytime(new Date());//创建时间
        //保存公告
        if(noticeService.updateById(notice)){
            return SystemConstant.EDI_SUCCESS;
        }
        return SystemConstant.EDI_ERROR;
    }

    /**
     * 删除公告
     * @param notice
     * @return
     */
    @RequestMapping("/deleteById")
    public JSONResult deleteById(Notice notice){
        if(noticeService.removeById(notice)){
            return SystemConstant.EDI_SUCCESS;
        }
        return SystemConstant.EDI_SUCCESS;
    }

    /**
     * 批量删除的公告
     * @param ids
     * @return
     */
    @RequestMapping("/batchDelete")
    public JSONResult batchDelete(String ids){
        try {
            String [] idsStr = ids.split(",");
            //删除
            if(noticeService.removeByIds(Arrays.asList(idsStr))){
                //删除成功
                return SystemConstant.EDI_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //删除失败
        return SystemConstant.EDI_ERROR;
    }
}


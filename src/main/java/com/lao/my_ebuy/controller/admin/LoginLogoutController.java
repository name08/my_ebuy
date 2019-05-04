package com.lao.my_ebuy.controller.admin;

import com.lao.my_ebuy.model.Admin;
import com.lao.my_ebuy.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginLogoutController {

    @Resource
    private AdminService adminService;

    //登陆
    @ResponseBody   //将数据以json格式返回客户端
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public Map<String,Object> login(String username, String password, HttpSession session){
        Admin admin=adminService.login(username,password);
        Map<String,Object> map = new HashMap<String,Object>();
        if (admin!=null){
            session.setAttribute("admin",admin);
            map.put("status",1);    //登录成功
        }else {
            map.put("status",-1);   //登录失败
            map.put("message","账户名或密码错误！请重新登录！");
        }
        return map;
    }

    //跳转到首页
    @RequestMapping(value = "/admin/index",method = RequestMethod.GET)
    public String index(){
        return "/jsp/admin/main.jsp";
    }

    //退出登录
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String logout(){
        return "jsp/admin/login.jsp";
    }
}

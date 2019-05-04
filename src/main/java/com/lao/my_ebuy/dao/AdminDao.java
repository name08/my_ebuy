package com.lao.my_ebuy.dao;

import com.lao.my_ebuy.model.Admin;
import com.lao.my_ebuy.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    //管理员登录
    public Admin login(@Param(value = "username") String username, @Param(value = "password") String password);
    //查询管理员
    public Admin selectAdmin(Integer id);
    //添加管理员
    public Admin addAdmin(Admin admin);
    //删除管理员
    public Admin deleteAdmin(Integer id);
    //修改管理员
    public int updateAdmin(Admin admin);
    //更新管理员密码
    public int updatePassword(Admin admin);
    //查询所有管理员
    public List<Admin> listAdmin(Page<Admin> pageBean);
    //所有用户数量
    public int AdminCount();
    //判断用户是否存在
    public int existAdmin(Admin admin);
}

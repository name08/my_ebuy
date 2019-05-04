package com.lao.my_ebuy.service;

import com.lao.my_ebuy.model.Admin;
import com.lao.my_ebuy.util.Page;

public interface AdminService {

    //管理员登录方法
    public Admin login(String username,String password);
    //管理员查询方法
    public Admin selectAdmin(Integer id);
    //管理员添加方法
    public Admin addAdmin(Admin admin);
    //管理员删除放法
    public Admin deleteAdmin(Integer id);
    //管理员编辑方法
    public int updateAdmin(Admin admin);
    //查询所有管理员放法
    public Page<Admin> listAdmin(Page<Admin> pageBean);
    //管理员网名存同
    public int existAdmin(Admin admin);
    //管理员重置密码
    public int updatePassword(Admin admin);

}

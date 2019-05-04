package com.lao.my_ebuy.service.impl;

import com.lao.my_ebuy.dao.AdminDao;
import com.lao.my_ebuy.model.Admin;
import com.lao.my_ebuy.service.AdminService;
import com.lao.my_ebuy.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Admin login(String username, String password) {
        return this.adminDao.login(username,password);
    }

    /**
     * 根据id查询管理员信息
     * @param id
     * @return
     */
    @Override
    public Admin selectAdmin(Integer id) {
        return this.adminDao.selectAdmin(id);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public Admin addAdmin(Admin admin) {
        return this.adminDao.addAdmin(admin);
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @Override
    public Admin deleteAdmin(Integer id) {
        return this.adminDao.deleteAdmin(id);
    }

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    @Override
    public int updateAdmin(Admin admin) {
        return this.adminDao.updateAdmin(admin);
    }

    /**
     *查询所有管理员并分页
     * @param page
     * @return
     */
    @Override
    public Page<Admin> listAdmin(Page<Admin> page) {
        List<Admin> list = adminDao.listAdmin(page);
        int AdminCount = adminDao.AdminCount();
        page.setTotalDataCount(AdminCount);
        page.setList(list);
        return page;
    }

    /**
     * 判断管理员是否存在
     * @param admin
     * @return
     */
    @Override
    public int existAdmin(Admin admin) {
        return this.adminDao.existAdmin(admin);
    }

    /**
     * 更新管理员密码
     * @param admin
     * @return
     */
    @Override
    public int updatePassword(Admin admin) {
        return this.adminDao.updatePassword(admin);
    }
}

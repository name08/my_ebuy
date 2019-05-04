package com.lao.my_ebuy.service;

import com.lao.my_ebuy.model.Customer;
import com.lao.my_ebuy.util.Page;

import java.util.List;

public interface CustomerService {

    //用户登录
    public Customer customerLogin(String c_username,String c_password);
    //用户注册
    public int customerRegister(Customer customer);
    //添加用户
    public int addCustomer(Customer customer);
    //删除用户
    public int deleteCustomer(Integer id);
    //更新用户
    public int updateCustomer(Customer customer);
    //查询所有用户
    public Page<Customer> queryCustomerPage(Page<Customer> page);
    //判断用户是否存在
    public int existCustomer(Customer customer);
    //查询订单数量
    public int getOrderNumber(Integer id);
    //根据信息查询用户
    public Page<Customer> LikeCustomer(Page<Customer> page);
    //根据id获取客户信息
    public Customer queryCustomer(Integer id);
}

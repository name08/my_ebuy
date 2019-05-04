package com.lao.my_ebuy.service.impl;

import com.lao.my_ebuy.dao.CustomerDao;
import com.lao.my_ebuy.model.Customer;
import com.lao.my_ebuy.service.CustomerService;
import com.lao.my_ebuy.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    /**
     * 用户登录
     * @param c_username
     * @param c_password
     * @return
     */
    @Override
    public Customer customerLogin(String c_username, String c_password) {
        return this.customerDao.customerLogin(c_username,c_password);
    }

    /**
     * 用户注册
     * @param customer
     * @return
     */
    @Override
    public int customerRegister(Customer customer) {
        return this.customerDao.customerRegister(customer);
    }

    /**
     * 添加用户
     * @param customer
     * @return
     */
    @Override
    public int addCustomer(Customer customer) {
        return this.customerDao.addCustomer(customer);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteCustomer(Integer id) {
        return this.customerDao.deleteCustomer(id);
    }

    /**
     * 用户更新
     * @param customer
     * @return
     */
    @Override
    public int updateCustomer(Customer customer) {
        return this.customerDao.updateCustomer(customer);
    }

    /**
     * 普通用户列表
     * @param page
     * @return
     */
    @Override
    public Page<Customer> queryCustomerPage(Page<Customer> page) {
        List<Customer> list = customerDao.queryCustomerPage(page);
        int CustomerCount = customerDao.CustomerCount();
        for (int i = 0; i < list.size(); i++){
            //查询所有用户订单数量
            list.get(i).setOrderNo(customerDao.getOrderNumber(list.get(i).getId()));
            //查询所有用户订单金额
            list.get(i).setTotalPrice(customerDao.getOrderPrice(list.get(i).getId()));
            //如果没有订单,默认订单金额为0.0
            if (list.get(i).getTotalPrice() == 0){
                list.get(i).setTotalPrice(0.0);
            }
        }
        page.setTotalDataCount(CustomerCount);
        page.setList(list);
        return page;
    }

    /**
     * 判断用户是否存在
     * @param customer
     * @return
     */
    @Override
    public int existCustomer(Customer customer) {
        return this.customerDao.existCustomer(customer);
    }

    /**
     * 根据id获取用户订单数量
     * @param id
     * @return
     */
    @Override
    public int getOrderNumber(Integer id) {
        return this.customerDao.getOrderNumber(id);
    }

    /**
     *根据条件查询用户
     * @param page
     * @return
     */
    @Override
    public Page<Customer> LikeCustomer(Page<Customer> page) {
        List<Customer> list = customerDao.LikeCustomer(page);
        int LikeProductCount = customerDao.LikeCustomerCount(page);
        for (int i = 0; i < list.size(); i++){
            //查询所有用户订单金额
            list.get(i).setTotalPrice(customerDao.getOrderPrice(list.get(i).getId()));
            //查询所有用户订单数量
            list.get(i).setOrderNo(customerDao.getOrderNumber(list.get(i).getId()));
            //判断用户如果没有订单，默认金额为0.0
            if (list.get(i).getTotalPrice() == null){
                list.get(i).setTotalPrice(0.0);
            }
        }
        page.setTotalDataCount(LikeProductCount);
        page.setList(list);

        return page;
    }

    /**
     * 根据用户ID获取用户信息
     * @param id
     * @return
     */
    @Override
    public Customer queryCustomer(Integer id) {
        return this.customerDao.queryCustomer(id);
    }
}

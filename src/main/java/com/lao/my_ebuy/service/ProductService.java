package com.lao.my_ebuy.service;

import com.lao.my_ebuy.model.Product;
import com.lao.my_ebuy.util.Page;

import java.util.List;

public interface ProductService {
    //产品分页查询
    public Page<Product> queryProductPage(Page<Product> page);
    //查询产品信息
    public Product getProduct(Integer id);
    //添加产品
    public int addProduct(Product product);
    //删除产品
    public int deleteProduct(Integer id);
    //更新产品
    public int upDateProduct(Product product);
    //模糊查询产品信息
    public Page<Product> LikeProduct(Page<Product> page);
    //根据状态符排序，status=1按照优先级降序，status=2按照创建时间降序，去前四条记录
    public List<Product> listProduct(Product product);
    //判断产品是否存在
    public int existProduct(Product product);
}

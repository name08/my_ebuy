package com.lao.my_ebuy.service;

import com.lao.my_ebuy.model.ProductType;
import com.lao.my_ebuy.util.Page;

import java.util.List;

public interface ProductTypeService {
    //分页查询产品类别列表
    public Page<ProductType> queryProductTypePage(Page<ProductType> page);
    //删除产品类别
    public int deleteProductType(Integer id);
    //添加产品类别
    public int addProductType(ProductType productType);
    //更新产品类别
    public int updateProductType(ProductType productType);
    //查询产品类别信息
    public ProductType getProductType(Integer id);
    //查询是否存在产品类别
    public int existProductType(ProductType productType);
    //获取产品分类列表
    public List<ProductType> listProductType();
    //查询产品数量
    public int getProductNumber(Integer id);
    //模糊查询产品分类
    public Page<ProductType> LikeProductType(Page<ProductType> page);
}

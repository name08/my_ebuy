package com.lao.my_ebuy.controller.admin.productmanager;

import com.lao.my_ebuy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/admin/ProductManage")
public class ProductManageController {
    @Resource
    private ProductService productService;
}

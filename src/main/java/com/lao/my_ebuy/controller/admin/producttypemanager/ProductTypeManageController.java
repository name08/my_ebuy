package com.lao.my_ebuy.controller.admin.producttypemanager;

import com.lao.my_ebuy.model.ProductType;
import com.lao.my_ebuy.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/admin/ProductTypeManage")
@Controller
public class ProductTypeManageController {
    @Resource
    private ProductTypeService productTypeService;
}

package com.lao.my_ebuy.controller.admin.producttypemanager;

import com.lao.my_ebuy.model.ProductType;
import com.lao.my_ebuy.service.ProductTypeService;
import com.lao.my_ebuy.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/admin/product/producttypemanage")
@Controller
public class ProductTypeManageController {
    @Resource
    private ProductTypeService productTypeService;

    /**
     * 分页查询产品类
     * @param page
     * @param request
     * @return
     */
    @RequestMapping(value = "/productTypemanage",method = RequestMethod.POST)
    public String queryProductTypePage(Page<ProductType> page, HttpServletRequest request){
        Page<ProductType> productTypes = productTypeService.queryProductTypePage(page);
        request.setAttribute("productTypes",productTypes);
        return "/jsp/admin/product/producttypemanage/producttypemanage.jsp";
    }

    /**
     * 删除产品类别
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/doDeleteProductType",method = RequestMethod.GET)
    public String doDeleteProductType(Integer id,HttpServletRequest request){
        int ProductCount = productTypeService.deleteProductType(id);
        if (ProductCount > 0){
            request.setAttribute("msg","删除产品类别失败，请先删除产品分类下的产品！");
        }else if (productTypeService.getProductType(id) == null){
            request.setAttribute("msg","删除失败，该产品类型不存在！");
        }else {
            request.setAttribute("msg","删除产品分类成功！");
        }
        return "/admin/product/producttypemanage/productTypemanage";
    }

    /**
     * 跳转到创建产品分类
     * @param request
     * @return
     */
    @RequestMapping(value = "/toAddProductType")
    public String toAddProductType(HttpServletRequest request){
        ProductType productType = new ProductType();
        productType.setPt_orderNum(100);
        productType.setPt_linkUrl("http://");
        request.setAttribute("productType",productType);
        return "/jsp/admin/product/producttypemanage/producttypemanage.jsp";
    }
}

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>jsp/admin/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>jsp/admin/js/jquery.js"></script>
    <!-- 导入kindEditor所需插件 -->
    <link rel="stylesheet" href="<%=basePath%>/plugins/kindeditor/themes/default/default.css">
    <script src="<%=basePath%>/plugins/kindeditor/kindeditor-all.js"></script>
    <script src="<%=basePath%>/plugins/kindeditor/lang/zh_CN.js"></script>
    <!-- 导入代码高亮的css样式，kindeditor需要导入 -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/kindeditor/plugins/code/prettify.css">
    <script type="text/javascript" src="<%=basePath%>/plugins/kindeditor/plugins/code/prettify.js"></script>
    <script>

    </script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">客户模块</a></li>
        <li><a href="#">客户信息编辑</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>顾客信息编辑</span></div>
        <form id="UpdateCustomer"  method="post">
            <input name="id" type="hidden" value="${customer.id}"/>
            <ul class="forminfo">
                <li><label>*帐户名</label><input id="c_username" name="c_username" type="text" class="dfinput" value="${customer.c_username}" readonly><i id="c_usernameError"></i></li>
                <li><label>*昵称</label><input id="c_nickName" name="c_nickName" type="text" class="dfinput" value="${customer.c_nickName}"><i id="c_nickNameError"></i></li>
                <li>
                    <label>*性别</label>
                    <select id="c_sex" name="c_sex" class="dfinput">
                        <c:choose>
                            <c:when test="${customer.c_sex==0}">
                                <option value="${customer.c_sex}" selected="selected">男</option>
                                <option value="${customer.c_sex+1}">女</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${customer.c_sex}" selected="selected">女</option>
                                <option value="${customer.c_sex-1}">男</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                    <i id="c_sexError"></i>
                </li>
                <li><label>*头像</label>
                    <input id="url1" name="c_picUrl" type="text" class="dfinput" value="${customer.c_picUrl}" readonly="readonly">
                    <input type="button" id="image1" class="dfinput" style="width:120px;" value="点我选择图片">
                    <a href="#" id="clearImagePath1">清除选择图片路径</a>
                    <i id="p_picUrlError"></i>
                </li>
                <li><label>电话</label><input id="c_telephone" name="c_telephone" type="text" class="dfinput" value="${customer.c_telephone}"><i id="c_telephoneError"></i></li>
                <li><label>地址</label><input id="c_address" name="c_address" type="text" class="dfinput" value="${customer.c_address}"><i id="c_addressError"></i></li>
                <li><label>邮编</label><input id="c_zipCode" name="c_zipCode" type="text" class="dfinput" value="${customer.c_zipCode}"><i id="c_zipCodeError"></i></li>
                <li><label>电子邮箱</label><input id="c_email" name="c_email" type="text" class="dfinput" value="${customer.c_email}"><i id="c_emailError"></i></li>
                <li><label>顾客介绍</label>
                    <textarea name="c_intro" cols="" rows="" class="textinput" >${customer.c_intro}</textarea><i></i>
                </li>

                <li><label>&nbsp;</label><input id="UpdateCustomer_Button" name="" type="button" class="btn" value="编辑顾客信息">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="returnCustomerManage" type="button" class="btn" value="返回顾客管理"/></li>
            </ul>
        </form>
    
    </div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri	="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>用户列表</title>
    <script type="text/javascript" src="${ctx}/resources/js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/common/common.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/user/list.js"></script>
</head>

<body>
    <h2>用户列表</h2>

    <form:form id="searchForm" class="well form-horizontal" modelAttribute="user" method="post" action="${ctx}/user/list">
        <div class="control-group">
            <label class="control-label">用户名称</label>
            <div class="controls">
                <form:input path="name" class="input-medium search-query" placeholder="用户名称"/>
            </div>
        </div>

        <div class="control-group last-margin">
            <div class="controls">
                <button class="btn btn-success" type="submit">
                    <i class="icon-search icon-white"></i>搜索
                </button>
                <a class="btn btn-primary" href="${ctx}/user/register">添加新用户</a>
            </div>
        </div>
    </form:form>

    <c:forEach var="user" items="${page.getContent()}">
    <div class="userItem">
        <div class="info">
               【用户详情】&nbsp;&nbsp;&nbsp;&nbsp;
               名称：<span>${user.name }</span>
               <a href="${ctx}/user/modify/${user.id}" title="编辑用户信息">编辑</a>
               <a href="${ctx}/user/detail/${user.id}" title="查看用户信息">查看</a>
        </div>
    </div>
    <div class="both"></div>
    </c:forEach>

    <p class="pageInfo">
        当前第 ${page.getNumber()} 页，共${page.getTotalElements()} 条记录，每页显示${page.getSize()} 条，共 ${page.getTotalPages()} 页
        <input id="pageNum" class="span1" type="text" value="${page.getNumber()}" name="page">
        <a id="go" class="btn" onclick="userList.skipPage();" href="javascript:void(0)">Go</a>
    </p>
</body>
</html>

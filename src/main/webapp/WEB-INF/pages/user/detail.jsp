<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri	="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>用户详情</title>
</head>

<body>
    <h2 class="active">用户详情</h2>
    <form:form id="supervisorForm" action="${ctx}/user/save" method="POST" class="form-horizontal">
        <input type="hidden" id="id" name="id" value="${user.id}"/>
        <div class="control-group">
            <label class="control-label control-span">用户名称: ${user.name}</label>
        </div>
        <div class="control-group clear" >
            <div class="controls">
                <a href="${ctx}/user/list" title="显示所有用户信息">返回所有用户信息列表</a>
            </div>
        </div>
    </form:form>
</body>
</html>

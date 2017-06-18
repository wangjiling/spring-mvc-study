<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri	="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>编辑用户信息</title>
</head>

<body>
    <h2>编辑用户信息</h2>
    <form:form id="supervisorForm" action="${ctx}/user/modify" method="POST" class="form-horizontal">
        <input type="hidden" id="id" name="id" value="${user.id}"/>
        <div class="control-group">
            <label class="control-label">用户名</label>
            <div class="controls">
                <input type="text" id="name" name="name"  value="${user.name}" />
            </div>
        </div>

        <div class="control-group clear" >
            <div class="controls">
                <button type="submit" id="submitButton" class="btn btn-default">修改</button>
                <button type="button" class="btn btn-default">取消</button>
            </div>
        </div>
    </form:form>
</body>
</html>

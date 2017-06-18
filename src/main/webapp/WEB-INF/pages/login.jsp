<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="${ctx}/favicon.ico">
    <%--<link rel="stylesheet" type="text/css" href="${ctx}/resources/bootstrap/2.3.1/css/bootstrap.min.css"/>--%>


    <!-- Le styles -->
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 400px;
            padding: 49px 29px 29px;
            margin: 10px auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .control-label {
            width: 60px;
        }

        .form-signin .controls {
            margin-left: 120px;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

        .error{
            color: red;
        }
    </style>

     <script type="text/javascript" src="${ctx}/resources/js/jquery/1.9.1/jquery.js"></script>
     <script type="text/javascript" src="${ctx}/resources/js/validate/1.11.1/jquery.validate.js"></script>
     <script type="text/javascript" src="${ctx}/resources/js/validate/login.js"></script>
</head>

<body>

<div class="container">


    <form action="${ctx}/user/loginProcess" method="post" class="form-horizontal form-signin" id="loginForm">
        <c:if test="${not empty param.error}">
            <div class="control-group error">
                <div class="controls">
                    <span class="help-inline">用户名或密码错误</span>
                </div>
            </div>
        </c:if>

        <div class="control-group">
            <label class="control-label" for="username">用户名</label>

            <div class="controls">
                <input type="text" name="name" id="username" placeholder="用户名"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="password">密码</label>

            <div class="controls">
                <input type="password" name="password" id="password" placeholder="密码"/>
            </div>
        </div>

        <%--<div class="control-group">--%>
            <%--<div class="controls">--%>
                <%--<label class="checkbox">--%>
                    <%--<input type="checkbox" name="remember_me"/> 记住我--%>
                <%--</label>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-large btn-success">登 录</button>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <label>
                    还没有账户？<a href="/user/register">注册</a>
                </label>
            </div>
        </div>
    </form>

    <hr>

    <footer>
        <p class="copyright" style="text-align: center;">&copy; 版权所有</p>
    </footer>

</div>

</body>
</html>



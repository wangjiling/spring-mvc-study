<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <title>用户注册</title>
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

    <script type="text/javascript" src="${ctx}/resources/js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/validate/1.11.1/jquery.validate.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/validate/account/user.js"></script>
</head>

<body>

<div class="container">


    <form action="${ctx}/user/save" method="post" class="form-horizontal form-signin" id="registerForm">
        <div class="control-group">
            <label class="control-label" for="name">用户名</label>

            <div class="controls">
                <input type="text" name="name" id="name" placeholder="用户名"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="password">密码</label>

            <div class="controls">
                <input type="password" name="password" id="password" placeholder="密码"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="confirmPassword">确认密码</label>

            <div class="controls">
                <input type="password" name="confirmPassword" id="confirmPassword" placeholder="确认密码"/>
            </div>
        </div>


        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn btn-large btn-success">注 册</button>
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



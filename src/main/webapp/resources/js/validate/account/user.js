$(function () {
    $("#registerForm").validate({
        errorElement:"span",
        rules:{
            name:"required",
            email:{
                required: true,
                email: true
            },
            password:{
                required:true,
                minlength: 6
            },
            confirmPassword:{
                required:true,
                minlength: 6,
                equalTo:"#password"
            }

        },
        messages:{
            name:"用户名必须填写",
            email:{
                required:"Email必须填写",
                email:"请填写合法的Email地址"
            },
            password:{
                required:"请填写密码",
                minlength: "密码长度不应低于6位"
            },
            confirmPassword:{
                required:"请填写确认密码",
                minlength: "确认密码长度不应低于6位",
                equalTo: "两次密码不同"
            }
        }
    });
});
var ctx = "/";

$(function() {
    validateRule();
    //$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green-login"});
    /*$('.imgcode').click(function() {
        var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
        $(".imgcode").attr("src", url);
    });*/
});

$.validator.setDefaults({
    submitHandler: function(form) {
        login();
    }
});

function login() {
    $.modal.loading($("#btnSubmit").data("loading"));
    var username = $.common.trim($("#username").val());
    //var username = $("#username").val();
    var password = $.common.trim($("#password").val());
    //var password = $("#password").val();
    //var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    $.ajax({
        type: "POST",
        url: "login",
        data: {
            "username": username,
            "password": password,
            //"validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
            if (r.code == 200) {
                location.href = ctx + 'index';
            } else {
                $.modal.closeLoading();
                //$('.imgcode').click();
                $.modal.msg(r.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}

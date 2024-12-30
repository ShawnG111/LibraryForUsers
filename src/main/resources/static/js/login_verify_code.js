$(document).ready(function(){
    getImage();
    $("#verifyPic").click(function(){
        getImage();
    });
    $("#submit").click(function(){
        submit();
    });
    if($("#register").val() == 1){
        $("#message").html("注册成功");
    }
});

function getImage(){
    $("#verifyPic").attr("src","/getVerify?n="+Math.random());
}

function submit() {
    $.ajax({
       type: "GET",
       url: "login",
       data: {
           phoneNum: $("#phoneNum").val(),
           password: $("#password").val(),
           verifyCode: $("#verifyCode").val()
       },
       dataType: "json",
       success: function (data){
           if(data.success == 1){
               window.location = "http://127.0.0.1:81/menu";
           }
           if(data.status == 1 || data.status == 2){
               $("#message").html("用户名或密码错误");
           }
           if(data.status == 3){
               $("#message").html("验证码错误");
           }
           getImage();
       }
    });
}
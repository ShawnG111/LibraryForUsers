$(document).ready(function(){
    getImage();
    $("#verifyPic").click(function(){
        getImage();
    });
    $("#submit").click(function(){
        submit();
    });
});

function getImage(){
    $("#verifyPic").attr("src","/getVerify?n="+Math.random());
}

function submit() {
    $.ajax({
       type: "GET",
       url: "register",
       data: {
           phoneNum: $("#phoneNum").val(),
           userName: $("#userName").val(),
           email: $("#email").val(),
           password: $("#password").val(),
           verifyCode: $("#verifyCode").val()
       },
       dataType: "json",
       success: function (data){
           if(data.success == 1){
               window.location = "http://127.0.0.1:81?register=1";
           }
           if(data.status == 1){
               $("#message").html("用户已存在");
           }
           if(data.status == 2){
               $("#message").html("验证码错误");
           }
           getImage();
       }
    });
}
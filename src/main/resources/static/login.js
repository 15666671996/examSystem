$(document).ready(function () {

    $("#login").click(function () {
        var email = $("#email").val();
        var password = $("#password").val();
        $.post("/login", {email: email, password: password}, function (data) {
            if (data.status) {
                window.location.href = "main.html";
            } else {
                alert(data.message);
            }
        });
    });

});
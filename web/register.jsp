<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页面</title>
    <!-- 引入外部css文件 -->
    <link rel="stylesheet" href="css/register.css">
    <!-- 引入字体图标css文件 -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
    <!--樱花-->
    <script type="text/javascript" src="js/sakura.js"></script>
</head>

<body>
<%--点击爆炸--%>
<canvas class="fireworks" style="position:fixed;left:0;top:0;z-index:99999999;pointer-events:none;"></canvas>
<script type="text/javascript" src="js/fireworks.js"></script>

<div class="registerbox">

    <!--ToDo-->
    <form action="RegisterServlet" method="post">
        <h1>Register</h1>
        <div class="ite">
            <div class="item">
                <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                <input type="text" name="uname" id="" placeholder="Username" required="required">
            </div>
            <div class="item">
                <i class="fa fa-key" aria-hidden="true"></i>
                <input type="password" name="upasswd" id="" placeholder="Password" required="required">
            </div>
            <div class="item">
                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                <input type="email" name="uemail" id="" placeholder="Email" required="required">
            </div>
            <div class="btn">
                <input type="submit" value="注册">
            </div>
            <div class="tiaoz">
                <span> 已有账号？前往 </span><a href="index.jsp">登录</a>
            </div>
        </div>
    </form>
</div>
<div id="footer">CopyRight@布莱恩特科比酱2020</div>
</body>

</html>

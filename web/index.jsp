<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页面</title>
    <!-- 引入外部css文件 -->
    <link rel="stylesheet" href="css/login.css">
    <%--樱花--%>
    <script type="text/javascript" src="js/sakura.js"></script>
    <!-- 引入字体图标css文件 -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!--头像-->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
</head>
<body>
<%--点击爆炸--%>
<canvas class="fireworks" style="position:fixed;left:0;top:0;z-index:99999999;pointer-events:none;"></canvas>
<script type="text/javascript" src="js/fireworks.js"></script>

<div class="loginbox">
    <%
        String success = (String) request.getAttribute("info");
        if(success != null)
        {
            %>
            <h3><%=success%></h3>
            <%
        }
    %>
    <form action="LoginServlet" method="post">
        <h1>Login</h1>
        <div class="ite">
            <div class="item">
                <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                <input type="text" name="uname"  placeholder="Username" required="required">
            </div>
            <div class="item">
                <i class="fa fa-key" aria-hidden="true"></i>
                <input type="password" name="upasswd"  placeholder="Password" required="required">
            </div>
        </div>

        <div class="btn">
            <form action="LoginServlet" method="post">
                <input type="submit" value="登录" class="log">
                <a href="register.jsp"> <input type="button" value="注册"></a>
            </form>
        </div>
    </form>
</div>
<div id="footer">CopyRight@布莱恩特科比酱2020</div>
</body>

</html>
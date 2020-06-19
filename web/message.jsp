<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        String error = (String) request.getAttribute("info");

        if(error != null)
        {
            %>
            <h3><%=error%></h3>
            <%
         }
    %>
    <form action="index.jsp" method="post">
        <div class="btn">
                <input type="submit" value="确定" class="log">
        </div>

    </form>
</div>
<div id="footer">CopyRight@布莱恩特科比酱2020</div>
</body>

</html>
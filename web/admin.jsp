<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.User" %>
<html>
<head>
    <title>管理页面</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png"/>
    <script type="text/javascript" src="js/admin.js"></script>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <!--live2d效果-->
    <link rel="stylesheet" type="text/css" href="live2d/assets/waifu.css"/>
    <script src="live2d/assets/autoload.js" type="text/javascript"></script>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <script>
        function less() {
            /*隐藏result*/
            document.getElementById("result").style.display="none";
        }
    </script>
</head>
<body >
<%
    //获取登录成功的用户信息
    User user = (User) session.getAttribute("admin");
    //判断用户是否登录
    if(user != null)
    {
        %>

    <div id = "action" ></div>

    <div id = "result" ></div>

    <div id="nav">
        <div class="title" id="menu1" onclick="showmenu('1')">学生管理</div>
        <div id="list1" class="content" style="display:none">
            <ul>
                <li onclick="showInsertStudent()">新增学生信息</li>
                <li onclick="showDeleteStudent()">删除学生信息</li>
                <li onclick="showAlterStudent()">修改学生信息</li>
                <li onclick="showQueryStudent()">查询学生信息</li>
            </ul>
        </div>
        <div class="title" id="menu2" onclick="showmenu('2')">教师管理</div>
        <div id="list2" class="content" style="display:none">
            <ul>
                <li onclick="showInsertTeacher()">新增教师信息</li>
                <li onclick="showDeleteTeacher()">删除教师信息</li>
                <li onclick="showAlterTeacher()">修改教师信息</li>
                <li onclick="showQueryTeacher()">查询教师信息</li>
            </ul>
        </div>
        <div class="title" id="menu3" onclick="showmenu('3')">学院管理</div>
        <div id="list3" class="content" style="display:none">
            <ul>
                <li onclick="showInsertDep()">新增学院信息</li>
                <li onclick="showDeleteDep()">删除学院信息</li>
                <li onclick="showAlterDep()">修改学院信息</li>
                <li onclick="showQueryDep()">查询学院信息</li>
            </ul>
        </div>
        <div class="title" id="menu4" onclick="showmenu('4') ">课程管理</div>
        <div id="list4" class="content" style="display:none">
            <ul>
                <li onclick="showInsertCou()">新增课程信息</li>
                <li onclick="showDeleteCou()">删除课程信息</li>
                <li onclick="showAlterCou()">修改课程信息</li>
                <li onclick="showQueryCou()">查询课程信息</li>
            </ul>
        </div>
    </div>

<!--表格-->
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <td>row 1, cell 1</td>--%>
<%--        <td>row 1, cell 2</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>row 2, cell 1</td>--%>
<%--        <td>row 2, cell 2</td>--%>
<%--    </tr>--%>
<%--</table>--%>

<%
		}
    else
     {
         response.sendRedirect("index.jsp");
	 }
		%>
    <!--live2d-->
    <div class="waifu">
        <div class="waifu-tips"></div>
        <canvas id="live2d" class="live2d"></canvas>
        <div class="waifu-tool">
            <span class="fui-home"></span>
            <span class="fui-chat"></span>
            <span class="fui-eye"></span>
            <span class="fui-user"></span>
            <span class="fui-photo"></span>
            <span class="fui-info-circle"></span>
            <span class="fui-cross"></span>
        </div>
    </div>
    <script src="live2d/assets/waifu-tips.js"></script>
    <script src="live2d/assets/live2d.js"></script>
    <script type="text/javascript">
        live2d_settings['modelId'] = 1;
        live2d_settings['modelTexturesId'] = 87;
        initModel("live2d/assets/waifu-tips.json")
    </script>
    <!--背景-->
    <script type="text/javascript" color="100,100,100" opacity='0.4' zIndex="-5" count="99"
        src="js/canvas-nest.min.js"></script>
    <script type="text/javascript" src="js/sakura.js"></script>
<div id="footer">CopyRight@布莱恩特科比酱2020</div>
</body>
</html>

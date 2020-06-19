//导航栏
function showmenu(id) {
    var list = document.getElementById("list"+id);
    var menu = document.getElementById("menu"+id)

    if (list.style.display=="none")
    {
        document.getElementById("list"+id).style.display="block";
        for (i = 1; i <= 4; i++)
        {
            if(i != id)
            {
                document.getElementById("list"+i).style.display="none";
            }
        }
    }
    else
    {
        document.getElementById("list"+id).style.display="none";
    }
}

//ToDo 此处可以用switch,但是我懒,直接CV
//插入学生
function insertStu()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var sno = document.getElementById("sno").value;
    var sname = document.getElementById("sname").value;
    var sage = document.getElementById("sage").value;

    xmlhttp.open("GET", "/SikiJsp/StuServlet?action=insert&sno="+sno+"&sname="+sname+"&sage="+sage, true);
    //post请求参数写在send里面,且要设置请求头
    //xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "插入成功";
            }
            else {
                divtag.innerHTML = "插入失败";
            }
        }
    }
}
//删除学生
function deleteStu()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var sno = document.getElementById("sno").value;
    xmlhttp.open("GET", "/SikiJsp/StuServlet?action=delete&sno="+sno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "删除成功";
            }
            else {
                divtag.innerHTML = "删除失败";
            }
        }
    }
}
//修改学生信息
function alterStu()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var sno = document.getElementById("sno").value;
    var sname = document.getElementById("sname").value;
    var sage = document.getElementById("sage").value;

    xmlhttp.open("GET", "/SikiJsp/StuServlet?action=alter&sno="+sno+"&sname="+sname+"&sage="+sage, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "修改成功";
            }
            else {
                divtag.innerHTML = "修改失败";
            }
        }
    }
}
//查询学生
function queryStu()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var sno = document.getElementById("sno").value;

    xmlhttp.open("GET", "/SikiJsp/StuServlet?action=query&sno="+sno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById("result");
            if(data != "") {
                divtag.innerHTML = data;
            }
            else {
                divtag.innerHTML = "未查询到相关信息";
            }
        }
    }
}
//插入教师
function insertTea()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var tno = document.getElementById("tno").value;
    var tname = document.getElementById("tname").value;
    var tage = document.getElementById("tage").value;

    xmlhttp.open("GET", "/SikiJsp/TeaServlet?action=insert&tno="+tno+"&tname="+tname+"&tage="+tage, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "插入成功";
            }
            else {
                divtag.innerHTML = "插入失败";
            }
        }
    }
}
//删除教师
function deleteTea()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var tno = document.getElementById("tno").value;
    xmlhttp.open("GET", "/SikiJsp/TeaServlet?action=delete&tno="+tno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "删除成功";
            }
            else {
                divtag.innerHTML = "删除失败";
            }
        }
    }
}
//修改教师信息
function alterTea()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var tno = document.getElementById("tno").value;
    var tname = document.getElementById("tname").value;
    var tage = document.getElementById("tage").value;

    xmlhttp.open("GET", "/SikiJsp/TeaServlet?action=alter&tno="+tno+"&tname="+tname+"&tage="+tage, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "修改成功";
            }
            else {
                divtag.innerHTML = "修改失败";
            }
        }
    }
}
//查询教师
function queryTea()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var tno = document.getElementById("tno").value;

    xmlhttp.open("GET", "/SikiJsp/TeaServlet?action=query&tno="+tno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById("result");
            if(data != "") {
                divtag.innerHTML = data;
            }
            else {
                divtag.innerHTML = "未查询到相关信息";
            }
        }
    }
}
//插入学院
function insertDep()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var dno = document.getElementById("dno").value;
    var dname = document.getElementById("dname").value;
    var dnumber = document.getElementById("dnumber").value;
    var dtea = document.getElementById("dtea").value;

    xmlhttp.open("GET", "/SikiJsp/DepServlet?action=insert&dno="+dno+"&dname="+dname+"&dnumber="+dnumber+"&dtea="+dtea, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "插入成功";
            }
            else {
                divtag.innerHTML = "插入失败";
            }
        }
    }
}
//删除学院
function deleteDep()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var dno = document.getElementById("dno").value;
    xmlhttp.open("GET", "/SikiJsp/DepServlet?action=delete&dno="+dno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "删除成功";
            }
            else {
                divtag.innerHTML = "删除失败";
            }
        }
    }
}
//修改学院信息
function alterDep()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var dno = document.getElementById("dno").value;
    var dname = document.getElementById("dname").value;
    var dnumber = document.getElementById("dnumber").value;
    var dtea = document.getElementById("dtea").value;

    xmlhttp.open("GET", "/SikiJsp/DepServlet?action=alter&dno="+dno+"&dname="+dname+"&dnumber="+dnumber+"&dtea="+dtea, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "修改成功";
            }
            else {
                divtag.innerHTML = "修改失败";
            }
        }
    }
}
//查询学院
function queryDep()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var dno = document.getElementById("dno").value;

    xmlhttp.open("GET", "/SikiJsp/DepServlet?action=query&dno="+dno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById("result");
            if(data != "") {
                divtag.innerHTML = data;
            }
            else {
                divtag.innerHTML = "未查询到相关信息";
            }
        }
    }
}
//插入课程
function insertCou()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var cno = document.getElementById("cno").value;
    var cname = document.getElementById("cname").value;
    var ctea = document.getElementById("ctea").value;
    var cnumber = document.getElementById("cnumber").value;

    xmlhttp.open("GET", "/SikiJsp/CouServlet?action=insert&cno="+cno+"&cname="+cname+"&ctea="+ctea+"&cnumber="+cnumber, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "插入成功";
            }
            else {
                divtag.innerHTML = "插入失败";
            }
        }
    }
}
//删除课程
function deleteCou()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var cno = document.getElementById("cno").value;
    xmlhttp.open("GET", "/SikiJsp/CouServlet?action=delete&cno="+cno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "删除成功";
            }
            else {
                divtag.innerHTML = "删除失败";
            }
        }
    }
}
//修改课程信息
function alterCou()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var cno = document.getElementById("cno").value;
    var cname = document.getElementById("cname").value;
    var ctea = document.getElementById("ctea").value;
    var cnumber = document.getElementById("cnumber").value;

    xmlhttp.open("GET", "/SikiJsp/CouServlet?action=alter&cno="+cno+"&cname="+cname+"&cnumber="+cnumber+"&ctea="+ctea, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById('result');
            if(data == "true") {
                divtag.innerHTML = "修改成功";
            }
            else {
                divtag.innerHTML = "修改失败";
            }
        }
    }
}
//查询课程
function queryCou()
{
    var xmlhttp = new XMLHttpRequest();
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器
    var cno = document.getElementById("cno").value;

    xmlhttp.open("GET", "/SikiJsp/CouServlet?action=query&cno="+cno, true);
    //post请求写在send里面
    xmlhttp.send();
    //回调函数
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            var divtag = document.getElementById("result");
            if(data != "") {
                divtag.innerHTML = data;
            }
            else {
                divtag.innerHTML = "未查询到相关信息";
            }
        }
    }
}
//显示插入学生
function showInsertStudent()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入新增学生信息<br/>"
        + "<input type='text' placeholder='学号' id='sno' required='required'>"+"<br/>"
        + "<input type='text'  placeholder='姓名' id='sname' required='required'>"+"<br/>"
        + "<input type='text' placeholder='年龄' id='sage'required='required'>"+"<br/>"
        + "<input id='submit' onclick=insertStu() type='submit' name='submit' value='插入'>"
        + "</div>";
    result.innerHTML = show;
}
//显示删除学生
function showDeleteStudent()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入删除学生信息<br/>"
        + "<input type='text' placeholder='学号' id='sno'  required='required'>"
        + "<input id='submit' onclick=deleteStu() type='submit' name='submit' value='删除'>"
        + "</div>";
    result.innerHTML = show;
}
//显示修改学生
function showAlterStudent()
{
    var alter = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入修改学生信息<br/>"
        + "<input type='text' placeholder='学号'  id='sno'  required='required'>"+"<br/>"
        + "<input type='text' placeholder='姓名' id='sname' required='required'>"+"<br/>"
        + "<input type='text' placeholder='年龄' id='sage' required='required'>"+"<br/>"
        + "<input id='submit' onclick=alterStu() type='submit' name='submit' value='修改'>"
        + "</div>"
    alter.innerHTML = show;
}
//显示查询学生
function showQueryStudent()
{
    var query = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入查询学生信息<br/>"
        + "<input type='text' placeholder='学号' id='sno' required='required'>"
        + "<input id='submit' onclick=queryStu() type='submit' name='submit' value='查询'>"
        + "</div>";
    query.innerHTML = show;
}
//显示插入教师
function showInsertTeacher()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入新增教师信息<br/>"
        + "<input type='text' placeholder='工号' id='tno' required='required'>"+"<br/>"
        + "<input type='text' placeholder='姓名' id='tname' required='required'>"+"<br/>"
        + "<input type='text' placeholder='年龄' id='tage' required='required'>"+"<br/>"
        + "<input id='submit' onclick=insertTea() type='submit' name='submit' value='插入'>"
        + "</div>";
    result.innerHTML = show;
}
//显示删除教师
function showDeleteTeacher()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入删除教师信息<br/>"
        + "<input type='text' placeholder='工号' id='tno'  required='required'>"
        + "<input id='submit' onclick=deleteTea() type='submit' name='submit' value='删除'>"
        + "</div>";
    result.innerHTML = show;
}
//显示修改教师
function showAlterTeacher()
{
    var alter = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入修改教师信息<br/>"
        + "<input type='text' placeholder='工号' id='tno'  required='required'>"+"<br/>"
        + "<input type='text' placeholder='姓名' id='tname' required='required'>"+"<br/>"
        + "<input type='text'  placeholder='年龄' id='tage' required='required'>"+"<br/>"
        + "<input id='submit' onclick=alterTea() type='submit' name='submit' value='修改'>"
        + "</div>";
    alter.innerHTML = show;
}
//显示查询教师
function showQueryTeacher()
{
    var query = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入查询教师信息<br/>"
        + "<input type='text' placeholder='工号' id='tno' required='required'>"
        + "<input id='submit' onclick=queryTea() type='submit' name='submit' value='查询'>"
        + "</div>";
    query.innerHTML = show;
}
//显示插入学院
function showInsertDep()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入新增学院信息<br/>"
        + "<input type='text' placeholder='学院号' id='dno' required='required'>"+"<br/>"
        + "<input type='text' placeholder='学院名' id='dname' required='required'>"+"<br/>"
        + "<input type='text' placeholder='人数' id='dnumber'required='required'>"+"<br/>"
        + "<input type='text' placeholder='院长' id='dtea'required='required'>"+"<br/>"
        + "<input id='submit' onclick=insertDep() type='submit' name='submit' value='插入'>"
        + "</div>";
    result.innerHTML = show;
}
//显示删除学院
function showDeleteDep()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入删除学院信息<br/>"
        + "<input type='text' placeholder='学院号' id='dno'  required='required'>"
        + "<input id='submit' onclick=deleteDep() type='submit' name='submit' value='删除'>"
        + "</div>";
    result.innerHTML = show;
}
//显示修改学院
function showAlterDep()
{
    var alter = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入修改学院信息<br/>"
        + "<input type='text' placeholder='学院号' id='dno'  required='required'>"+"<br/>"
        + "<input type='text' placeholder='学院名' id='dname' required='required'>"+"<br/>"
        + "<input type='text' placeholder='院长' id='dtea' required='required'>"+"<br/>"
        + "<input type='text' placeholder='人数' id='dnumber' required='required'>"+"<br/>"
        + "<input id='submit' onclick=alterDep() type='submit' name='submit' value='修改'>"
        + "</div>";
    alter.innerHTML = show;
}
//显示查询学院
function showQueryDep()
{
    var query = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入查询学院信息<br/>"
        + "<input type='text' placeholder='学院号' id='dno' required='required'>"
        + "<input id='submit' onclick=queryDep() type='submit' name='submit' value='查询'>"
        + "</div>";
    query.innerHTML = show;
}
//显示插入课程
function showInsertCou()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入新增课程信息<br/>"
        + "<input type='text' placeholder='课程号'  id='cno' required='required'>"+"<br/>"
        + "<input type='text' placeholder='课程名' id='cname' required='required'>"+"<br/>"
        + "<input type='text' placeholder='选课人数' id='cnumber'required='required'>"+"<br/>"
        + "<input type='text' placeholder='授课教师' id='ctea'required='required'>"+"<br/>"
        + "<input id='submit' onclick=insertCou() type='submit' name='submit' value='插入'>"
        + "</div>";
    result.innerHTML = show;
}
//显示删除课程
function showDeleteCou()
{
    var result = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入删除课程信息<br/>"
        + "<input type='text' placeholder='课程号' id='cno'  required='required'>"
        + "<input id='submit' onclick=deleteCou() type='submit' name='submit' value='删除'>"
        + "</div>";
    result.innerHTML = show;
}
//显示修改课程
function showAlterCou()
{
    var alter = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入修改课程信息<br/>"
        + "<input type='text' placeholder='课程号' id='cno'  required='required'>"+"<br/>"
        + "<input type='text' placeholder='课程名' id='cname' required='required'>"+"<br/>"
        + "<input type='text'  placeholder='授课教师' id='ctea' required='required'>"+"<br/>"
        + "<input type='text' placeholder='选课人数' id='cnumber' required='required'>"+"<br/>"
        + "<input id='submit' onclick=alterCou() type='submit' name='submit' value='修改'>"
        + "</div>";
    alter.innerHTML = show;
}
//显示查询课程
function showQueryCou()
{
    var query = document.getElementById("action");
    var show = "<div id=''  class=''>"
        + "&nbsp&nbsp请输入查询课程信息<br/>"
        + "<input type='text' placeholder='课程号' id='cno' required='required'>"
        + "<input id='submit' onclick=queryCou() type='submit' name='submit' value='查询'>"
        + "</div>";
    query.innerHTML = show;
}
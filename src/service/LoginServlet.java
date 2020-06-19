package service;

import Dao.DBUtils;
import Dao.UserDao;
import Model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(value = "LoginServlet")
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("uname");
        String password = request.getParameter("upasswd");
        //实例化UserDao对象
        UserDao userDao = new UserDao();
        User user = null;
        try
        {
            user = userDao.login(username, password);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //判断是否登录成功
        if(user != null)
        {
            //成功
            request.getSession().setAttribute("admin", user);//将管理员对象放到session中
            //转发到admin.jsp中
            request.getRequestDispatcher("admin.jsp").forward(request, response);
            //response.sendRedirect("admin.jsp");
        }
        else
        {//失败
            request.setAttribute("info"," 用户名或密码错误！");
            //response.sendRedirect("message.jsp");
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}

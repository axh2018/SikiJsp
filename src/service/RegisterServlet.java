package service;

import Dao.DBUtils;
import Dao.UserDao;
import Model.User;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet
{
    private static Connection connection;
    private static QueryRunner qr = new QueryRunner();
    static
    {
        try
        {
            connection = DBUtils.getConnection();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static int insert(String user,String passwd,String email) throws SQLException
    {
        int success = qr.update(connection,"insert into admin values(?,?,?)",user,passwd,email);
        return success;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("uname");
        String password = req.getParameter("upasswd");
        String email = req.getParameter("uemail");
        //实例化UserDao对象
        UserDao userDao = new UserDao();
        int flag = 0;
        try
        {
            flag = userDao.insertUser(username, password,email);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //判断是否注册成功
        if(flag > 0)
        {
            //成功
            //req.getSession().setAttribute("admin", user);//将管理员对象放到session中
            //转发到admin.jsp中
            req.setAttribute("info"," 注册成功");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            //resp.sendRedirect("resuccess.jsp");
        }
        else
        {//失败
            req.setAttribute("info"," 注册失败！");
            //resp.sendRedirect("message.jsp");
            req.getRequestDispatcher("message.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
    }
}

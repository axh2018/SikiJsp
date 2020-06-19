package service;

import Dao.CouDao;
import Dao.DepDao;
import Dao.StuDao;
import Dao.TeaDao;
import Model.Dep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class DepServlet extends HttpServlet
{
    protected boolean insert(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取request里的sno,sname,sage
        String dno = (req.getParameter("dno"));
        String dname = (req.getParameter("dname"));
        String dtea = (req.getParameter("dtea"));
        String dnumber = (req.getParameter("dnumber"));

        DepDao depDao = new DepDao();
        boolean success = false;
        try {
            success = depDao.insert(Integer.parseInt(dno),dname,Integer.parseInt(dnumber),dtea);
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        if (success)
        {
            out.write("true");
            return true;
        }
        else
        {
            out.write("false");
        }
        out.close();
        return false;
    }
    protected boolean delete(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取request里的sno,sname,sage
        String dno = (req.getParameter("dno"));
        DepDao depDao = new DepDao();
        boolean success = false;
        try {
            success = depDao.delete(Integer.parseInt(dno));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        //成功
        if (success)
        {
            out.write("true");
            return true;
        }
        else
        {
            out.write("false");
        }
        out.close();
        return false;
    }
    protected boolean alter(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取request里的sno,sname,sage
        String dno = (req.getParameter("dno"));
        String dname = (req.getParameter("dname"));
        String dtea = (req.getParameter("dtea"));
        String dnumber = (req.getParameter("dnumber"));
        DepDao depDao = new DepDao();
        boolean success = false;
        try {
            success = depDao.alter(Integer.parseInt(dno),dname,dtea,Integer.parseInt(dnumber));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        if (success)
        {
            out.write("true");
            return true;
        }
        else
        {
            out.write("false");
        }
        out.close();
        return false;
    }
    protected String query(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
    {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取request里的sno
        String dno = (req.getParameter("dno"));
        DepDao depDao = new DepDao();
        String result = "";
        PrintWriter out = resp.getWriter();
        try
        {
            List<Object[]> list = depDao.query(Integer.parseInt(dno));
            if(list.size() != 0)
            {
                result = "院系号："+list.get(0)[0].toString()+" 院名："+(String)list.get(0)[1]+" 院长："+list.get(0)[2].toString()
                        +" 人数："+list.get(0)[3].toString();
            }

            /*
            for (Object[] objs : list)
            {
                for (Object obj : objs)
                {
                    result += obj.toString() + " ";
                }
            }
             */
            if (result != "")
                out.write(result);
            out.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //判断get请求的操作
        String action = req.getParameter("action");
        switch (action)
        {
            case "insert":
                insert(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "alter":
                alter(req, resp);
                break;
            case "query":
                try
                {
                    query(req, resp);
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}

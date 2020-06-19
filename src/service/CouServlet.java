package service;

import Dao.CouDao;
import Dao.StuDao;
import Dao.TeaDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class CouServlet extends HttpServlet
{
    protected boolean insert(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取request里的sno,sname,sage
        String cno = (req.getParameter("cno"));
        String cname = (req.getParameter("cname"));
        String ctea = (req.getParameter("ctea"));
        String cnumber = (req.getParameter("cnumber"));

        CouDao couDao = new CouDao();
        boolean success = false;
        try {
            success = couDao.insert(Integer.parseInt(cno),cname,Integer.parseInt(cnumber),ctea);
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
        String cno = (req.getParameter("cno"));
        CouDao couDao = new CouDao();
        boolean success = false;
        try {
            success = couDao.delete(Integer.parseInt(cno));
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
        String cno = (req.getParameter("cno"));
        String cname = (req.getParameter("cname"));
        String ctea = (req.getParameter("ctea"));
        String cnumber = (req.getParameter("cnumber"));
        CouDao couDao = new CouDao();
        boolean success = false;
        try {
            success = couDao.alter(Integer.parseInt(cno),cname,ctea,Integer.parseInt(cnumber));
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
        String cno = (req.getParameter("cno"));
        CouDao couDao = new CouDao();
        String result = "";
        PrintWriter out = resp.getWriter();
        try
        {
            List<Object[]> list = couDao.query(Integer.parseInt(cno));
            if(list.size() != 0)
            {
                result = "课程号："+list.get(0)[0].toString()+" 课程名："+(String)list.get(0)[1]+" 教师："+list.get(0)[2].toString()
                        +" 选课人数："+list.get(0)[3].toString();
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

package Dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//课程Dao
public class CouDao
{
    private final QueryRunner qr = new QueryRunner();
    //增加,成功返回true
    public boolean insert(int cno,String cname,int cnumber,String ctea) throws SQLException
    {
        Connection connection = null;
        String sql = "insert into course values(?,?,?,?)";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,cno,cname,ctea,cnumber);
            if(success > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //关闭资源
            assert connection != null;
            connection.close();
        }
        return false;
    }
    //删除
    public  boolean delete(int cno) throws SQLException
    {
        Connection connection = null;
        String sql = "delete from course where cno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,cno);
            if(success > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //关闭资源
            assert connection != null;
            connection.close();
        }
        return false;
    }
    //判断学生是否存在
    public boolean exist(int cno)
    {
        PreparedStatement ps;
        ResultSet resultSet;
        String sql = "select * from course where cno = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cno);
            resultSet = ps.executeQuery();
            //有数据,返回true
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //关闭资源
        return false;
    }
    //修改
    public boolean alter(int cno,String cname,String ctea,int cnumber) throws SQLException
    {
        Connection connection = null;
        String sql = "update course set cname = ? , cnumber = ? , ctea = ? where cno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,cname,cnumber,ctea,cno);
            if(success > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //关闭资源
            assert connection != null;
            connection.close();
        }
        return false;
    }
    //查询
    public List<Object[]> query(int cno) throws SQLException
    {
        String sql = "select * from course where cno = ?";
        ArrayListHandler alh = new ArrayListHandler();
        Connection connection = DBUtils.getConnection();
        List<Object[]> arrayList = qr.query(connection, sql, cno, alh);
        //关闭资源
        connection.close();
        return arrayList;
    }
}

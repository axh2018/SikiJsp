package Dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//学院Dao
public class DepDao
{
    //ToDo Dep查询有问题
    //ToDo Cou修改有问题
    private final QueryRunner qr = new QueryRunner();
    //增加,成功返回true
    public boolean insert(int dno,String dname,int dnumber,String dtea) throws SQLException
    {
        Connection connection = null;
        String sql = "insert into department values(?,?,?,?)";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,dno,dname,dtea,dnumber);
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
    public  boolean delete(int dno) throws SQLException
    {
        Connection connection = null;
        String sql = "delete from department where dno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,dno);
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
    public boolean exist(int dno)
    {
        PreparedStatement ps;
        ResultSet resultSet;
        String sql = "select * from department where dno = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, dno);
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
    public boolean alter(int dno,String dname,String dtea,int dnumber) throws SQLException
    {
        Connection connection = null;
        String sql = "update department set dname = ? , dnumber = ? , dtea = ? where dno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,dname,dnumber,dtea,dno);
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
    public List<Object[]> query(int dno) throws SQLException
    {
        String sql = "select * from department where dno = ?";
        ArrayListHandler alh = new ArrayListHandler();
        Connection connection = DBUtils.getConnection();
        List<Object[]> arrayList = qr.query(connection, sql, dno, alh);
        //关闭资源
        connection.close();
        return arrayList;
    }
}

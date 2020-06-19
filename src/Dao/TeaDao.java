package Dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//教师Dao
public class TeaDao
{
    private final QueryRunner qr = new QueryRunner();
    //增加,成功返回true
    public boolean insert(int tno,String tname,int tage) throws SQLException
    {
        Connection connection = null;
        String sql = "insert into tea values(?,?,?)";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,tno,tname,tage);
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
    public  boolean delete(int tno) throws SQLException
    {
        Connection connection = null;
        String sql = "delete from tea where tno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,tno);
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
    //判断教师是否存在
    public boolean exist(int tno)
    {
        PreparedStatement ps;
        ResultSet resultSet;
        String sql = "select * from tea where tno = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, tno);
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
    public boolean alter(int tno,String tname,int tage) throws SQLException
    {
        Connection connection = null;
        String sql = "update tea set tname = ? , tage = ? where tno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,tname,tage,tno);
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
    public List<Object[]> query(int tno) throws SQLException
    {
        String sql = "select * from tea where tno = ?";
        ArrayListHandler alh = new ArrayListHandler();
        Connection connection = DBUtils.getConnection();
        List<Object[]> arrayList = qr.query(connection, sql, tno, alh);
        //关闭资源
        connection.close();
        return arrayList;
    }
}

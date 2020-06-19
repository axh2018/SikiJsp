package Dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//学生Dao
public class StuDao
{
    private final QueryRunner qr = new QueryRunner();
    //增加,成功返回true
    public boolean insert(int sno,String sname,int sage) throws SQLException
    {
        Connection connection = null;
        String sql = "insert into stu values(?,?,?)";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,sno,sname,sage);
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
    public  boolean delete(int sno) throws SQLException
    {
        Connection connection = null;
        String sql = "delete from stu where sno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,sno);
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
    public boolean exist(int sno)
    {
        PreparedStatement ps;
        ResultSet resultSet;
        String sql = "select * from stu where sno = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, sno);
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
    public boolean alter(int sno,String sname,int sage) throws SQLException
    {
        Connection connection = null;
        String sql = "update stu set sname = ? , sage = ? where sno = ?";
        try {
            connection = DBUtils.getConnection();
            int success = qr.update(connection,sql,sname,sage,sno);
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
    public List<Object[]> query(int sno) throws SQLException
    {
        String sql = "select * from stu where sno = ?";
        ArrayListHandler alh = new ArrayListHandler();
        Connection connection = DBUtils.getConnection();
        List<Object[]> arrayList = qr.query(connection, sql, sno, alh);
        //关闭资源
        connection.close();
        return arrayList;
    }
}

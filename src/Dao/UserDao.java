package Dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.*;

import Model.User;
import Dao.DBUtils;

//管理员Dao
public class UserDao
{
    //用户登录，登录成功返回一个含值User对象,如果登录失败返回一个User空对象
    public User login(String username,String password) throws Exception
    {
        Connection conn = DBUtils.getConnection();
        User user = null;
        String sql = "select * from admin where user = ? and passwd = ?;";

        try {
            //获取PreparedStatement对象
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            //对sql参数进行动态赋值
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();//查询结果集

            //判断数据库中是否存在该用户
            if(rs.next()){
                user = new User();//实例化一个user对象
                //给用户对象赋值
                user.setName(rs.getString("user"));
                user.setPasswd(rs.getString("passwd"));
            }
            //释放资源
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return user;
    }
    //用户注册，返回一个int值表示状态,1：成功，0失败
    public int insertUser(String username,String password,String email) throws Exception
    {
        Connection conn = DBUtils.getConnection();
        String sql = "insert into admin values(?,?,?);";

        int flag = 0;
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            flag = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return flag;
    }
}

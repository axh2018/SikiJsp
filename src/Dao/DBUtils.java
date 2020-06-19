package Dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Bryant
 */
//获取数据库连接工具类
public class DBUtils
{
    //设置属性和方法为static,方便后面调用
    private static Connection conn;
    private static final DataSource DS = new ComboPooledDataSource();
    //返回一个连接对象
    public static Connection getConnection()
    {
        try {
            conn = DS.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

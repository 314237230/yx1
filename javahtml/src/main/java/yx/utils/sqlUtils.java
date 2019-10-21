package yx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author:三金
 * @Date:2019/10/17 19:25
 */
public class sqlUtils {
    static String url = "";
    static String name = "";
    static String pwd = "";
    static String driver = "";

    static {
        Properties properties = new Properties();
        InputStream inputStream = sqlUtils.class.getClassLoader().getResourceAsStream("sql.properties");
        try {
            properties.load(inputStream);
            //连接数据库
            url = properties.getProperty("mysql.url");
            name = properties.getProperty("mysql.name");
            pwd = properties.getProperty("mysql.pwd");
            driver = properties.getProperty("mysql.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 获取连接驱动
     */
    public Connection getconnection() throws Exception {
            //加载数据库驱动
            Class.forName(driver);
            //连接数据库 产生数据库连接对象
            Connection connection = DriverManager.getConnection(url,name,pwd);
            return connection;

    }
    /**
     * 释放资源
     * */
    public void close(Connection connection, Statement statement, ResultSet resultSet){

        if (resultSet !=null){
            try {
                //释放资源
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.close(connection,statement);
        }
    }
    public void close(Connection connection, Statement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

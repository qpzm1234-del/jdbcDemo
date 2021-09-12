package com.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {
    private static String user;
    private static String driver;
    private static String url;
    private static String password;
    static{
        try {
            Properties pro = new Properties();
            pro.load(new FileInputStream("src\\jdbc.properties"));
            user = pro.getProperty("username");
            driver = pro.getProperty("driverClassName");
            url = pro.getProperty("url");
            password = pro.getProperty("password");

        }catch (Exception e){
            throw new RuntimeException(e);
    }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //
    //关闭连接(这里只是把连接放回连接池）并没有真的关闭连接connection
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

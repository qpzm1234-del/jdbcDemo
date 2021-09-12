package com.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class druidDtuils {
    public static DataSource is;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            is = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return is.getConnection();
    }
    //关闭连接(这里只是把连接放回连接池）并没有真的关闭连接connection
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
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

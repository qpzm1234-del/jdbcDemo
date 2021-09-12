package com.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int i = 1;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        Class.forName("com.mysql.jdbc.Driver");
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        Connection connection = DriverManager.getConnection(url, properties);
        String sql1 = "insert into mytable02 value(1,'aaa','3班',60,60,60)";
        //预处理
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        //添加到批处理
        preparedStatement.addBatch(sql1);
        //用for语句执行10次批处理
        for (; i <= 10; i++){
            preparedStatement.executeUpdate();
                     }
        //情况批处理
        preparedStatement.clearBatch();
        System.out.println(i-1);
    }

}

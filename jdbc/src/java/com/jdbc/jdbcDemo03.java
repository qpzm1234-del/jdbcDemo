package com.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connect = driver.connect(url, properties);
        String sql = "delete from mytable02 where `name` = 'aaa'";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        int rows = preparedStatement.executeUpdate();
        if(rows>0){
            System.out.println("删除成功");
        }
        else{
            System.out.println("失败");
        }
        preparedStatement.close();
        connect.close();
    }
}

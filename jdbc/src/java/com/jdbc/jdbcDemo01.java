package com.jdbc;

import com.jdbc2.mytable02;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class jdbcDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        mytable02 mytable02 = new mytable02();
        //注册驱动
        //1.通过反射注册驱动（会抛出sql异常和ClassNotFound异常
        //Class.forName("com.mysql.jdbc.Driver");
        Driver driver= new Driver();
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        Properties properties= new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        //创建连接（需要设置url(连接的主机名、端口以及数据库名），以及登录账号密码
        //1.通过反射注册驱动（会抛出sql异常和ClassNotFound异常
        //Connection connect = DriverManager.getConnection(url,properties);
        //2.Driver driver= new Driver();
        Connection connect = driver.connect(url, properties);
        //增加
        //String sql = "insert into mytable02 values(20,'房伟周','1班','83','110','79')";
        //删除
        //String sql = "delete from mytable02 where name='房伟周'";
        //修改
        //String sql = "update mytable02 set `name` = '房伟' where id = 10";
        //查询
        String sql = "select * from mytable02";
        //执行sql语句
        //Statement statement = connect.createStatement();
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        //获取影响行数（用于判断是否成功）
        //int row = statement.executeUpdate(sql);
        //获取查询到的结果集并输出查询结果
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            mytable02.setId(resultSet.getInt(1));
            mytable02.setName(resultSet.getString(2));
            mytable02.setCla(resultSet.getString(3));
            mytable02.setMath(resultSet.getInt(4));
            mytable02.setEnglish(resultSet.getInt(5));
            mytable02.setChinese(resultSet.getInt(6));
            System.out.println(mytable02);
        }
        //System.out.println(rows>0 ? "插入成功" : "插入失败错误");
        //System.out.println(rows>0 ? "删除成功" : "删除失败");
        //System.out.println(rows>0 ? "修改成功" : "删除失败");
        //System.out.println(res);
        preparedStatement.close();
        resultSet.close();
        connect.close();

    }
   
}

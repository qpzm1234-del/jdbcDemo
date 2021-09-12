package com.jdbc;

import com.jdbc2.mytable02;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcDemo04 {

    @Test
    public void test() throws SQLException {
        mytable02 mytable02 = new mytable02();
        Connection connection = druidDtuils.getConnection();
        String sql = "select * from mytable02";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
        druidDtuils.close(resultSet,preparedStatement,connection);
    }

}

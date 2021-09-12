package com.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Druid {
    @Test
    public void testDruid() throws Exception {
        int i =0;
        Properties pro = new Properties();
        pro.load(new FileInputStream("src\\druid.properties"));
        //创建指定参数的连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = dataSource.getConnection();
        String sql1 = "insert into mytable02 value(1,'aaa','3班',60,60,60)";
        //预处理
        PreparedStatement preparedStatement = conn.prepareStatement(sql1);
        //添加到批处理
        preparedStatement.addBatch(sql1);
        //用for语句执行10次批处理
        for (; i <= 10; i++){
            preparedStatement.executeUpdate();
        }
        //情况批处理
        preparedStatement.clearBatch();
        System.out.println(i-1);
        System.out.println("success");
        conn.close();

    }

}

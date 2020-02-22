package com.example.db.jdbc;


import org.springframework.stereotype.Service;

import java.sql.*;

/**
 * @author wuxinxin
 */
@Service
public class JdbcService {

    public void selectTest() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest", "root", "123456");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from mytest.tradelog limit 1");

        while (resultSet.next()){
            String string = resultSet.getString(1);
            String string1 = resultSet.getString(2);
            String string2 = resultSet.getString(3);
            String string3 = resultSet.getString(4);
            System.out.println(string+"-"+string1+"-"+string2+"-"+string3);
        }

        connection.close();
    }

}

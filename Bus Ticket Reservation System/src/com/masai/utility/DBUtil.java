package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection provideConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectDatabase", "root", "yatin@123");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

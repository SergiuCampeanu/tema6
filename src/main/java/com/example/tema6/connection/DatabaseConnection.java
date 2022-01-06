package com.example.tema6.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    final String DB_URL = "jjdbc:mysql://localhost:3306/maptema5";
    final String USER = "root";
    final String PASS = "admin";

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}

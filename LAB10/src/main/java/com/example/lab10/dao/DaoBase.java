package com.example.lab10.dao;
import java.sql.*;
public abstract class DaoBase {

    public Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";

        return DriverManager.getConnection(url, user, pass);
    }

}

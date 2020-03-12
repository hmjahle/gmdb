package com.hmjahle.model;

import javax.xml.validation.SchemaFactoryLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    public static final String DB_NAME = "gmdb";
    public static final String CONNECTION_STRING =  "jdbc:mysql://localhost:3306/" + DB_NAME + "?serverTimezone=UTC";
    public static final String DB_USERNAME = "gruppe35";
    public static final String DB_PASSWORD = "Gruppe35!?";

  
      public static final String TABLE_ALBUMS = "albums";

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USERNAME, DB_PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not connect to database: " + e.getMessage());
            return false;
        }
    };

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Could not close connection " + e.getMessage());
        }
    }


}
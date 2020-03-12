package com.hmjahle.model;

import javax.xml.validation.SchemaFactoryLoader;
import java.sql.*;

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

    public static void getActorRoles(String name) throws SQLException {
        // 0. Making a connection
        GMDb myDB = new GMDb("jdbc:mysql://localhost:3306/GMDb", "root", "hjalma1402");
        // 1. Get a connection
        Connection myConn = DriverManager.getConnection(myDB.HOST, myDB.UNAME, myDB.UPASS);
        // 2. Create a statement
        Statement stmt = myConn.createStatement();
        // 3. Execute a SLQ query
        ResultSet myRs = stmt.executeQuery("select distinct skuespillerIProduksjon.rolle from skuespillerIProduksjon, mediePerson\r\n" +
                "where skuespillerIProduksjon.MediePersonID =\r\n" +
                "      (select mediePerson.MediePersonID from mediePerson where Navn ='" + name + "');");
        // 4. Process the result set
        while(myRs.next()) {
            System.out.println(name + " spiller rollen til: " + myRs.getString("Rolle"));
        }
    }

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
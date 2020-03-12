package com.hmjahle.model;

import javax.xml.validation.SchemaFactoryLoader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "gmdb";
    public static final String CONNECTION_STRING =  "jdbc:mysql://localhost:3306/" + DB_NAME + "?serverTimezone=UTC";
    public static final String DB_USERNAME = "gruppe35";
    public static final String DB_PASSWORD = "Gruppe35!?";

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, DB_USERNAME, DB_PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Could not connect to database: " + e.getMessage());
            return false;
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

    public List<String> getActorRoles(String name)  {
        StringBuilder sb = new StringBuilder("select distinct skuespillerIProduksjon.rolle from skuespillerIProduksjon, mediePerson ");
        sb.append("where skuespillerIProduksjon.MediePersonID =");
        sb.append("(select mediePerson.MediePersonID from mediePerson where Navn = '");
        sb.append(name);
        sb.append("');");

        System.out.println("SQL statement = " + sb.toString());
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> roles = new ArrayList<>();
            while(results.next()) {
                roles.add(results.getString(1));
            }
            return roles;
        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

}
package com.hmjahle;

import com.hmjahle.model.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource datasource = new DataSource();
        if(!datasource.open()){
            System.out.println("Cannot open datasource");
            return;
        }
        List<String> rolesForArtist = datasource.getActorRoles("Axel Hennie");
        for (String role: rolesForArtist) {
            System.out.println(role);
        }
        datasource.close();

    }
}

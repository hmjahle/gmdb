package com.hmjahle.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.xml.validation.SchemaFactoryLoader;
import java.awt.image.FilteredImageSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "gmdb";
    public static final String CONNECTION_STRING =  "jdbc:mysql://localhost:3306/" + DB_NAME + "?serverTimezone=UTC";
    public static final String DB_USERNAME = "gruppe35";
    public static final String DB_PASSWORD = "Gruppe35!?";

    private Connection conn;

    private Film fillOutFilm(ResultSet results) throws SQLException{
        Film film = new Film(results.getInt(1), results.getString(3));
        film.setLengde(results.getTime(4));
        film.setGittUtPåVideo(results.getBoolean(10));
        film.setLagetFor(results.getString(8));
        film.setUtgivelsesår(results.getInt(5));
        film.setLanseringsdato(results.getDate(6));
        film.setStoryline(results.getString(7));
        return film;
    }

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

    public List<Skuespiller> getSkuespillere() {
        StringBuilder sb = new StringBuilder("select  * from medieperson, skuespilleriproduksjon");
        sb.append(" where medieperson.MediePersonID = skuespilleriproduksjon.MediePersonID group by Navn;");

        System.out.println("SQL statement = " + sb.toString());
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<Skuespiller> skuespillere = new ArrayList<>();
            while (results.next()) {
                Skuespiller s = new Skuespiller();
                s.setId(results.getInt(1));
                s.setNavn(results.getString(2));
                s.setFødselsår(results.getInt(3));
                s.setFødeslsLand(results.getString(4));
                skuespillere.add(s);
            }
            return skuespillere;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<String> getActorRoles(Skuespiller skuespiller)  {
        // 0. Making a connection
        // 1. Get a connection
        // 2. Create a statement
        StringBuilder sb = new StringBuilder("select distinct skuespillerIProduksjon.rolle from skuespillerIProduksjon, mediePerson ");
        sb.append("where skuespillerIProduksjon.MediePersonID =");
        sb.append("(select mediePerson.MediePersonID from mediePerson where Navn = '");
        sb.append(skuespiller.getNavn());
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

    public List<Film> getFilmer() {

        StringBuilder sb = new StringBuilder("select * from produksjon where medietype='Film'");
        System.out.println("SQL statement = " + sb.toString());
        return getFilms(sb);

    }

    public Film getFilmById(int id) {
        StringBuilder sb = new StringBuilder("select * from produksjon where medietype='Film' and ");
        sb.append("produksjon.produksjonsid = ");
        sb.append(id);
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {
            return fillOutFilm(results);
        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Film> getFilmerMedSkuespiller(Skuespiller skuespiller) {

        StringBuilder sb = new StringBuilder("select * from produksjon ");
        sb.append("inner join skuespilleriproduksjon s on produksjon.ProduksjonsID = s.ProduksjonsID ");
        sb.append("where produksjon.MedieType = 'Film' and s.MediePersonID = ");
        sb.append(skuespiller.getId());
        sb.append(";");
        return getFilms(sb);

    }

    public List<Sjanger> getSjangere() {

        StringBuilder sb = new StringBuilder("select * from filmkategori;");
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {
            List<Sjanger> sjangere = new ArrayList<>();
            while (results.next()) {
                Sjanger sjanger = new Sjanger(
                        results.getInt(1),
                        results.getString(2),
                        results.getString(3)
                );
                sjangere.add(sjanger);
            }
            return sjangere;
        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }

    public List<FilmSelskap> getFilmselskapMedFilmISjanger(Sjanger sjanger) {
        StringBuilder sb = 
    }

    @Nullable
    private List<Film> getFilms(StringBuilder sb) {
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {

            List<Film> filmer = new ArrayList<>();
            while(results.next()) {
                filmer.add(fillOutFilm(results));
            }
            return filmer;
        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
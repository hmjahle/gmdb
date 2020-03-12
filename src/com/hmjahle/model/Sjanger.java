package com.hmjahle.model;

import java.util.List;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public class Sjanger {

    private int id;
    private String beskrivelse;
    private String navn;

    private List<Film> sjangerForFilm;
    private List<Serie> sjangerForSerie;

    public Sjanger(int id, String beskrivelse, String navn) {
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}

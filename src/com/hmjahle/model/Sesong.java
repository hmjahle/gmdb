package com.hmjahle.model;

import java.util.List;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public class Sesong {

    private int id;
    private String tittel;
    private String beskrivelse;

    private Serie serie;

    private List<Episode> episoder;

    public Sesong(int id, String tittel) {
        this.id = id;
        this.tittel = tittel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Episode> getEpisoder() {
        return episoder;
    }

    public void addEpisode(Episode episode) {
        if (episoder.contains(episode)) {
            throw new IllegalArgumentException("Denne episoden er lagt til allerede");
        }
        episoder.add(episode);
    }
}

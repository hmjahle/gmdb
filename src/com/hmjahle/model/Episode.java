package com.hmjahle.model;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public class Episode extends Produksjon{

    private Sesong sesong;

    public Episode(int id, String tittel) {
        super(id, tittel);
    }

    public Sesong getSesong() {
        return sesong;
    }

    public void setSesong(Sesong sesong) {
        this.sesong = sesong;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "tittel='" + tittel + '\'' +
                '}';
    }
}

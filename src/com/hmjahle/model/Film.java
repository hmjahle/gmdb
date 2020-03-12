package com.hmjahle.model;

import java.util.List;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public class Film extends Produksjon implements KanHaSjanger {

    private String lagetFor;
    private List<Sjanger> sjangere;

    public Film(int id, String tittel) {
        super(id, tittel);
    }

    public String getLagetFor() {
        return lagetFor;
    }

    public void setLagetFor(String lagetFor) throws IllegalArgumentException {
        if (lagetFor.equals("Stream") || lagetFor.equals("Kino") || lagetFor.equals("TV")) {
            this.lagetFor = lagetFor;
        } else {
            throw new IllegalArgumentException("Må være laget for 'Stream', 'Tv', eller 'Kino'");
        }
    }

    @Override
    public String toString() {
        return "Film{" +
                "tittel='" + tittel + '\'' +
                '}';
    }

    @Override
    public void addSjanger(Sjanger sjanger) {
        if(sjangere.contains(sjanger)) {
            return;
        }
        sjangere.add(sjanger);
    }
}

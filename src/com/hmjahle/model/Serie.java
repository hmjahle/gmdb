package com.hmjahle.model;

import java.util.List;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public class Serie implements KanHaSjanger{

    private int id;
    private String lagetFor;
    private String beskrivelse;
    private String tittel;

    private List<Sesong> sesonger;
    private List<Sjanger> sjangere;

    public Serie(int id, String tittel) {
        this.id = id;
        this.tittel = tittel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLagetFor() {
        return lagetFor;
    }

    public void setLagetFor(String lagetFor) {
        this.lagetFor = lagetFor;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public List<Sesong> getSesonger() {
        return this.sesonger;
    }

    public void addSesong(Sesong sesong) throws IllegalArgumentException {
        if (sesonger.contains(sesong)) {
            throw new IllegalArgumentException("Senne sesongen er lagt til allerede");
        }
        this.sesonger.add(sesong);
    }

    @Override
    public void addSjanger(Sjanger sjanger) {
        if(sjangere.contains(sjanger)) {
            return;
        }
        sjangere.add(sjanger);
    }
}

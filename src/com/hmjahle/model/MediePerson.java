package com.hmjahle.model;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public abstract class MediePerson {

    protected int id;
    protected String navn;
    protected int fødselsår;
    protected String fødeslsLand;

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

    public int getFødselsår() {
        return fødselsår;
    }

    public void setFødselsår(int fødselsår) {
        this.fødselsår = fødselsår;
    }

    public String getFødeslsLand() {
        return fødeslsLand;
    }

    public void setFødeslsLand(String fødeslsLand) {
        this.fødeslsLand = fødeslsLand;
    }
}

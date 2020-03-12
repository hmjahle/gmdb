package com.hmjahle.model;

import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.Time;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public abstract class Produksjon {

    protected int id;
    protected String tittel;
    protected Time lengde;
    protected int utgivelsesår;
    protected Date lanseringsdato;
    protected String storyline;
    protected boolean gittUtPåVideo;

    public Produksjon(int id, String tittel) {
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

    public Time getLengde() {
        return lengde;
    }

    public void setLengde(Time lengde) {
        this.lengde = lengde;
    }

    public int getUtgivelsesår() {
        return utgivelsesår;
    }

    public void setUtgivelsesår(int utgivelsesår) {
        this.utgivelsesår = utgivelsesår;
    }

    public Date getLanseringsdato() {
        return lanseringsdato;
    }

    public void setLanseringsdato(Date lanseringsdato) {
        this.lanseringsdato = lanseringsdato;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public boolean isGittUtPåVideo() {
        return gittUtPåVideo;
    }

    public void setGittUtPåVideo(boolean gittUtPåVideo) {
        this.gittUtPåVideo = gittUtPåVideo;
    }

}

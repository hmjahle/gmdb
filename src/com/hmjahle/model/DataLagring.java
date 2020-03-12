package com.hmjahle.model;

import java.util.List;

/**
 * @author hansm on 12.03.2020
 * @project gmdb
 */
public class DataLagring {

    private List<Skuespiller> skuespillere;
    private List<Episode> episoder;
    private List<Film> filmer;
    private List<Sesong> sesonger;
    private List<Serie> serier;
    private List<Sjanger> sjangere;

    public List<Sjanger> getSjangere() {
        return sjangere;
    }

    public void setSjangere(List<Sjanger> sjangere) {
        this.sjangere = sjangere;
    }

    public List<Episode> getEpisoder() {
        return episoder;
    }

    public void setEpisoder(List<Episode> episoder) {
        this.episoder = episoder;
    }

    public List<Film> getFilmer() {
        return filmer;
    }

    public void setFilmer(List<Film> filmer) {
        this.filmer = filmer;
    }

    public List<Sesong> getSesonger() {
        return sesonger;
    }

    public void setSesonger(List<Sesong> sesonger) {
        this.sesonger = sesonger;
    }

    public List<Serie> getSerier() {
        return serier;
    }

    public void setSerier(List<Serie> serier) {
        this.serier = serier;
    }

    public List<Skuespiller> getSkuespillere() {
        return skuespillere;
    }

    public void setSkuespillere(List<Skuespiller> skuespillere) {
        this.skuespillere = skuespillere;
    }

    public Skuespiller getSkuespillerMedNavn(String name) {
        for (Skuespiller s: skuespillere) {
            if (s.getNavn().equals(name)) {
                return s;
            }
        }
        return null;
    }


}

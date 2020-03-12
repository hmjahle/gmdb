package com.hmjahle;

import com.hmjahle.model.DataLagring;
import com.hmjahle.model.DataSource;
import com.hmjahle.model.Film;
import com.hmjahle.model.Skuespiller;

import javax.xml.crypto.Data;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource datasource = new DataSource();
        if(!datasource.open()){
            System.out.println("Cannot open datasource");
            return;
        }
        // Lager datalagrings objekt
        DataLagring dataLagring = new DataLagring();

        // Legger skuespilelre til i datalagringen
        dataLagring.setSkuespillere(datasource.getSkuespillere());
        dataLagring.setFilmer(datasource.getFilmer());
        dataLagring.setSjangere(datasource.getSjangere());




        Skuespiller skuespiller = dataLagring.getSkuespillerMedNavn("Axel Hennie");
        List<Film> filmerMedAksel = datasource.getFilmerMedSkuespiller(skuespiller);
        for (Film f: filmerMedAksel) {
            System.out.println(f);
        }


        datasource.close();
    }
}

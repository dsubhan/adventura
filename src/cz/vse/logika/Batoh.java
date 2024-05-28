package cz.vse.logika;

import java.util.ArrayList;

/**
 * Třída Batoh - reprezentuje batoh s předměty.
 * Předměty se dají přidávat a odebírat z batohu. Batoh má maximální velikost.
 *
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class Batoh {
    private ArrayList<IPredmet> predmety;
    private int maxPocet;

    /**
     * Vytvoření batohu s maximálním počtem předmětů.
     * @param maxPocet maximální počet předmětů, které se vejdou do batohu
     */
    public Batoh(int maxPocet) {
        this.maxPocet = maxPocet;
        this.predmety = new ArrayList<>();
    }

    /**
     * Metoda pro přidání předmětu do batohu.
     * @param predmet přidávaný předmět
     * @return true pokud byl předmět do batohu přidán, false pokud je batoh plný a předmět se do něho nevejde
     */
    public boolean pridejPredmet(IPredmet predmet){
        if (predmety.size() < maxPocet){
            if (predmet.getPrenosnost()){
                predmety.add(predmet);
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Metoda pro odebrání předmětu z batohu
     * @param nazevPredmetu název odebíraného předmětu
     * @return true pokud byl předmět odebrán, false pokud předmět v batohu není
     */
    public boolean odeberPredmet(String nazevPredmetu){
        for (int i = 0; i < predmety.size(); i++){
            if (predmety.get(i).getNazev().equals(nazevPredmetu)){
                predmety.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda pro vypsání všech předmětů v batohu.
     * @return textový řetězec předmětů v batohu
     */
    @Override
    public String toString() {
        String vypisPredmetu = "|";
        for (IPredmet predmet : predmety){
            vypisPredmetu += predmet.getNazev() + "|";
        }
        return vypisPredmetu;
    }
}

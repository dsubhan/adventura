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
     *
     * @param predmet přidávaný předmět
     */
    public void pridejPredmet(IPredmet predmet){
        if (predmety.size() < maxPocet){
            if (predmet.getPrenosnost()){
                predmety.add(predmet);
            }
        }
    }

    /**
     * Metoda pro odebrání předmětu z batohu
     *
     * @param nazevPredmetu název odebíraného předmětu
     */
    public void odeberPredmet(String nazevPredmetu){
        for (int i = 0; i < predmety.size(); i++){
            if (predmety.get(i).getNazev().equals(nazevPredmetu)){
                predmety.remove(i);
                return;
            }
        }
    }

    /**
     * Metoda pro kontrolu existence předmětu v batohu
     * @param nazev název předmětu
     * @return true pokud existuje, false pokud ne
     */
    public boolean obsahujePredmet(String nazev){
        for (IPredmet predmet : predmety) {
            if (predmet.getNazev().equals(nazev)){
                return true;
            }
        }
        return false;
    }


    /**
     * Metoda pro získání počtu předmětů v batohu
     * @return počet předmětů v batohu
     */
    public int getPocetPredmetu(){
        return predmety.size();
    }

    /**
     * Metoda pro získání maximálního počtu předmětů v batohu
     * @return maximální počet předmětů v baothu
     */
    public int getMaxPocet() {
        return maxPocet;
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

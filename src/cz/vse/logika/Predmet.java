package cz.vse.logika;

/**
 * Třída předmět - reprezentuje předmět který bude přidáván do batohu.
 *
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class Predmet implements IPredmet{
    private String nazev;
    private boolean jePrenosnosna;

    /**
     * Vytvoření předmětu s jeho názvem.
     * @param nazev název předmětu
     */
    public Predmet(String nazev, boolean prenosnost){
        this.nazev = nazev;
        this.jePrenosnosna = prenosnost;
    }

    /**
     * Metoda pro získání názvu předmětu.
     * @return název předmětu
     */
    @Override
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda pro získání přenosnosti předmětu.
     * @return true pokud je přesný, false pokud není
     */
    @Override
    public boolean getPrenosnost() {
        return jePrenosnosna;
    }
}

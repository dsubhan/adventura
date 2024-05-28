package cz.vse.logika;

/**
 * Třída PrikazBatoh implementuje do hry příkaz batoh který slouží pro zobrazení předmětů v batohu (inventář).
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class PrikazBatoh implements IPrikaz{

    private static final String NAZEV = "batoh";

    private Batoh batoh;

    /**
     * Konstruktor třídy
     * @param batoh batoh do kterého se budou přidávat/odebírat předměty
     */
    public PrikazBatoh(Batoh batoh){
        this.batoh = batoh;
    }

    /**
     * Metoda pro vrácení věcí v batohu.
     *
     * @return textový řetězec věcí v batohu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return batoh.toString();
    }

    /**
     * Metoda vrací název příkazu
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

package cz.vse.logika;

/**
 * Třída PrikazOdebrat implementuje do hry možnost odebrání předmětu z batohu
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class PrikazOdebrat implements IPrikaz{

    private static final String NAZEV = "odebrat";
    private Batoh batoh;

    /**
     * Konstruktor třídy
     * @param batoh batoh ze kterého se budou předměty odebírat
     */
    public PrikazOdebrat(Batoh batoh) {
        this.batoh = batoh;
    }

    /**
     * Metoda pro odebrání předmětu z batohu
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, která se vypíše hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0){
            return "Co mám odebrat? Musíš mi to upřesnit.";
        }
        else if (parametry.length == 1 && batoh.obsahujePredmet(parametry[0])){
            batoh.odeberPredmet(parametry[0]);
            return "Předmět " + parametry[0] + " byl odebrán z batohu";
        }
        return "Tento předmět v batohu nemáš";
    }

    /**
     * Metoda pro vrácení názvu příkazu
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

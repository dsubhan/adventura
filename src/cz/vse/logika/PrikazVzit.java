package cz.vse.logika;

/**
 * Třída PrikazVzit implementuje do hry příkaz vzít který slouží pro sebrání předmětu z prostoru a vložení ho do batohu
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class PrikazVzit implements IPrikaz{

    private static final String NAZEV = "vzít";

    private Batoh batoh;
    private HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     * @param batoh batoh do kterého se budou ukládat předměty
     * @param herniPlan herní plán ze kterého získáme aktuální prostor
     */
    public PrikazVzit(Batoh batoh, HerniPlan herniPlan) {
        this.batoh = batoh;
        this.herniPlan = herniPlan;
    }

    /**
     * Metoda pro sebrání předmětu z prostoru a vložení ho do batohu
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return zpráva, která se vypíše hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Prostor prostor = herniPlan.getAktualniProstor();

        if (parametry.length == 0) {
            return "Co mam vzit? Musis mi to upresnit.";
        }
        else if (parametry.length == 1 && prostor.obsahujePredmet(parametry[0])){
            IPredmet predmet = prostor.getPredmet(parametry[0]);
            if (predmet.getPrenosnost()){
                if (batoh.getPocetPredmetu() < batoh.getMaxPocet()){
                    batoh.pridejPredmet(predmet);
                    prostor.odeberPredmet(predmet);
                    return "Předmět " + predmet.getNazev() + " se ti přidal do batohu";
                }
                else {
                    return "Nemáš místo v batohu. Odeber nějaký předmět.";
                }

            }
            else {
                return "Tento předmět nelze vzít";
            }
        }

        return "Tento předmět neexistuje";
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

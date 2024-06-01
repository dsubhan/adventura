package cz.vse.logika;

/**
 * Třída PrikazProzkoumat implementuje do hry možnost prozkoumat prostor a vypsat obsah předmětů v daném prostoru
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class PrikazProzkoumat implements IPrikaz{
    private static final String NAZEV = "prozkoumat";

    private HerniPlan herniPlan;
    private Batoh batoh;

    /**
     * Konstruktor třídy
     * @param herniPlan herní plán pro získání aktuálního prostoru
     */
    public PrikazProzkoumat(HerniPlan herniPlan, Batoh batoh) {
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    /**
     * Metoda pro výpis předmětů v prosoru
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return předměty v místnosti jako textový řetězec
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Prostor prostor = herniPlan.getAktualniProstor();
        //pokud se nacházíme v pokladnici a prozkoumáme ji, vytvoří se nová místnost a vloží se do ní poklad
        if (prostor.getNazev().equals("pokladnice") && batoh.obsahujePredmet("klíč")){
            Prostor skryta_mistnost = new Prostor("skrytá_místnost", "skrytá místnost s pokladem");
            skryta_mistnost.pridejPredmet(new Predmet("poklad", true));
            prostor.setVychod(skryta_mistnost);
            skryta_mistnost.setVychod(prostor);
            return "Našel jsi skryté dveře \n" + prostor.popisVychodu();
        }
        else{
            return prostor.vypisPredmetu() + "\n" + prostor.popisVychodu();
        }


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

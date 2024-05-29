package cz.vse.logika;

/**
 * Třída PrikazProzkoumat implementuje do hry možnost prozkoumat prostor a vypsat obsah předmětů v daném prostoru
 * @author David Subhan, subd02, subd02@vse.cz
 */
public class PrikazProzkoumat implements IPrikaz{
    private static final String NAZEV = "prozkoumat";

    private HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     * @param herniPlan herní plán pro získání aktuálního prostoru
     */
    public PrikazProzkoumat(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    /**
     * Metoda pro výpis předmětů v prosoru
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return předměty v místnosti jako textový řetězec
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Prostor prostor = herniPlan.getAktualniProstor();

        return prostor.vypisPredmetu();
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

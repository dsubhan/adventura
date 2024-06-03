package cz.vse.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2016/2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @BeforeEach
    public void setUp() {
        hra1 = new Hra();
    }


    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("rozcestí", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi vesnice");
        assertFalse(hra1.konecHry());
        assertEquals("vesnice", hra1.getHerniPlan().getAktualniProstor().getNazev());

        hra1.zpracujPrikaz("jdi radnice");
        assertFalse(hra1.konecHry());
        assertEquals("radnice", hra1.getHerniPlan().getAktualniProstor().getNazev());

        assertTrue(hra1.getHerniPlan().getAktualniProstor().obsahujePredmet("klíč"));
        hra1.zpracujPrikaz("vzít klíč");
        assertTrue(hra1.getBatoh().obsahujePredmet("klíč"));
        assertFalse(hra1.getHerniPlan().getAktualniProstor().obsahujePredmet("klíč"));
        hra1.zpracujPrikaz("jdi vesnice");
        assertEquals("vesnice", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertFalse(hra1.konecHry());

        hra1.zpracujPrikaz("jdi rozcestí");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("jdi tajemná_pěšina");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("jdi hradní_nádvoří");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("jdi hrad");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("jdi vstupní_sál");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("jdi pokladnice");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("prozkoumat");
        assertFalse(hra1.konecHry());
        hra1.zpracujPrikaz("jdi skrytá_místnost");
        assertFalse(hra1.getBatoh().obsahujePredmet("klíč"));
        assertTrue(hra1.konecHry());
    }
}

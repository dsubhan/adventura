package cz.vse.logika;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída BatohTest slouží k otestování
 * třídy Batoh
 *
 * @author David Subhan, subd02, subd02@vse,cz
 */
public class TestBatoh {

    /**
     * Testuje přidání předmětu do batohu
     */
    @Test
    public void testPridejPredmet(){
        Batoh batoh = new Batoh(3);

        Predmet predmet = new Predmet("pero", true);

        batoh.pridejPredmet(predmet);

        assertTrue(batoh.obsahujePredmet("pero"));

        assertFalse(batoh.obsahujePredmet("tužka"));
    }

    /**
     * Testuje odebrání předmětu z batohu
     */
    @Test
    public void testOdeberPredmet(){
        Batoh batoh = new Batoh(3);

        Predmet predmet = new Predmet("pero", true);

        batoh.pridejPredmet(predmet);
        assertTrue(batoh.obsahujePredmet("pero"));

        batoh.odeberPredmet("pero");
        assertFalse(batoh.obsahujePredmet("pero"));
    }

    /**
     * Testuje maximální počet předmětů v batohu
     */
    @Test
    public void testMaxPocetPredmetu(){
        Batoh batoh = new Batoh(2);

        Predmet predmet = new Predmet("pero", true);
        Predmet predmet2 = new Predmet("tužka", true);
        Predmet predmet3 = new Predmet("pravítko", true);

        batoh.pridejPredmet(predmet);
        batoh.pridejPredmet(predmet2);

        batoh.pridejPredmet(predmet3);
        assertFalse(batoh.obsahujePredmet("pravítko"));
    }

    /**
     * Testuje zda jde do batohu vložit nepřenositelný předmět
     */
    @Test
    public void testNeprenositelnyPredmet(){
        Batoh batoh = new Batoh(2);

        Predmet predmet = new Predmet("pero", false);

        batoh.pridejPredmet(predmet);
        assertFalse(batoh.obsahujePredmet("pero"));
    }
}

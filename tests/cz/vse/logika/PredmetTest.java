package cz.vse.logika;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída PredmetTest slouží k otestování
 * třídy Predmet
 *
 * @author David Subhan, subd02, subd02@vse,cz
 */
public class PredmetTest {

    /**
     * Testuje zda je predmet prenosny nebo ne
     */
    @Test
    public void testJePresnosny(){
        Predmet predmet1 = new Predmet("myš", true);
        Predmet predmet2 = new Predmet("postel", false);

        assertTrue(predmet1.getPrenosnost());
        assertFalse(predmet2.getPrenosnost());

    }
}

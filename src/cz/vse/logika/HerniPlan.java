package cz.vse.logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor rozcesti = new Prostor("rozcestí","rozcestí ze kterého můžete jít do bažiny, vesnice nebo tajemnou pěšinou");

        Prostor bazina = new Prostor("bažina", "bažina s tajemnou chýší");
        Prostor chyse = new Prostor("chýše", "tajemná chýše staré čarodejnice, ta naštěstí zrovna není doma");

        Prostor tajemna_pesina = new Prostor("tajemná_pěšina", "tajemná pěšina na které kvákají žáby a řvou vrány");
        Prostor hradni_nadvori = new Prostor("hradní_nádvoří","velké hradní nádvoří v jehož středu stojí opuštěný hrad");
        Prostor hrad = new Prostor("hrad","opuštěný hrad");
        Prostor vstupni_sal = new Prostor("vstupní_sál", "vstupní sál hradu, na podlaze je červený koberec a na stěnách obrazy rytířů");
        Prostor knihovna = new Prostor("knihovna", "knihovna plná zchátralých knížek");
        Prostor pokladnice = new Prostor("pokladnice", "hradní pokladnice, bohužel je celá vybraná");

        Prostor vesnice = new Prostor("vesnice","opuštěná vesnice se 3 zchátralými domy");
        Prostor dum_1 = new Prostor("bíly_dům", "zchátralý bílý dům, v jeho levém rohu se nachází zaprášená truhla");
        Prostor dum_2 = new Prostor("žlutý_dům", "zchátralý žlutý dům, tento dům je úplně prázdý");
        Prostor dum_3 = new Prostor("hnědý_dům", "zchátralý hnědý dům, uprostřed místnosti je zaprášený stůl");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        rozcesti.setVychod(bazina);
        rozcesti.setVychod(vesnice);
        rozcesti.setVychod(tajemna_pesina);
        // prostor bažiny
        bazina.setVychod(rozcesti);
        bazina.setVychod(chyse);
        chyse.setVychod(bazina);
        //prostor vesnice
        vesnice.setVychod(rozcesti);
        vesnice.setVychod(dum_1);
        vesnice.setVychod(dum_2);
        vesnice.setVychod(dum_3);
        dum_1.setVychod(vesnice);
        dum_2.setVychod(vesnice);
        dum_3.setVychod(vesnice);

        tajemna_pesina.setVychod(hradni_nadvori);
        tajemna_pesina.setVychod(rozcesti);
        // prostor hradu
        hradni_nadvori.setVychod(tajemna_pesina);
        hradni_nadvori.setVychod(hrad);
        hrad.setVychod(hradni_nadvori);
        hrad.setVychod(vstupni_sal);
        vstupni_sal.setVychod(hrad);
        vstupni_sal.setVychod(knihovna);
        vstupni_sal.setVychod(pokladnice);
        knihovna.setVychod(vstupni_sal);
        pokladnice.setVychod(vstupni_sal);

                
        aktualniProstor = rozcesti;  // hra začíná na rozcesti
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}

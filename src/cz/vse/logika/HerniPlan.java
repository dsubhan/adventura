package cz.vse.logika;


/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory,
 * propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class HerniPlan {

    private Prostor aktualniProstor;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }

    /**
     * Vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor rozcesti = new Prostor("rozcestí", "rozcestí ze kterého můžete jít do bažiny, vesnice nebo tajemnou pěšinou");

        Prostor bazina = new Prostor("bažina", "Bažina je tajemné místo, kde se setkává soumrak se zemí. \nVzduch je tužší a vlhčí, a ticho je proříznuto jen zvuky ptáků a kvákáním žab. \nUprostřed této bažiny stojí tajemná chýše, zahalená v mlze a stínech. \nJejí existence přitahuje zvědavé duše, ale zároveň vyvolává pocit obavy.");
        Prostor chyse = new Prostor("chýše", "Chýše \nVnitřek chýše září tichem a tajemstvím. \nOheň v krbu osvětluje temné kouty, kde se lesknou magické předměty a symboly. \nVzduch je nasycen vůní bylin a okna propouštějí slabé světlo, které tvoří tance stínů na zemi.");

        Prostor tajemna_pesina = new Prostor("tajemná_pěšina", "tajemná pěšina na které kvákají žáby a řvou vrány");
        Prostor hradni_nadvori = new Prostor("hradní_nádvoří", "velké hradní nádvoří v jehož středu stojí opuštěný hrad");
        Prostor hrad = new Prostor("hrad", "opuštěný hrad");
        Prostor vstupni_sal = new Prostor("vstupní_sál", "Vstupní sál hradu \nČervený koberec, nyní zaprášený a místy potrhaný, se táhne po celé délce místnosti. \nNa stěnách visí obrazy rytířů, jejich barvy vybledly a rámy jsou popraskané. \nVysoké stropy zdobí pavučiny a vzduch je těžký a chladný. \nV místnosti vládne hluboké ticho, narušované jen vzdáleným kapáním vody.");
        Prostor knihovna = new Prostor("knihovna", "Knihovna \nHradní knihovna je tichá a opuštěná. \nPrach pokrývá prázdné police, zatímco světlo z oken jen zčásti osvětluje místnost. \nVzduch je zatuchlý a vlhký, a knižní vůně je téměř zapomenutá.");
        Prostor pokladnice = new Prostor("pokladnice", "Pokladnice \nPokladnice hradu, celá vybraná, nyní září prázdnými regály. \nElegance minulosti je zastižena zatuchlým vzduchem a stíny, které se táhnou po zlacených zdobeních. \nJednou mající spoustu skrytých pokladů, teď jen zůstává jako památka na slávu, která ji kdysi vyplňovala.");

        Prostor vesnice = new Prostor("vesnice", "opuštěná vesnice se 3 zchátralými domy");
        Prostor krcma = new Prostor("krčma", "Krčma \nPrach pokrývá rozházené dřevěné stoly a lavice, zatímco pavučiny visí z rohů. \nNa podlaze leží rozbité džbány a zaprášené talíře. \nKrb je plný popela a sazí, vzduch těžký a vlhký, voní plísní. \nOkna jsou zamlžená a některá rozbitá, propouštějí slabé světlo na ztrouchnivělou podlahu.");
        Prostor kovarna = new Prostor("kovárna", "Kovárna \nPrach pokrývá staré nástroje a kovadlinu, zatímco pavučiny visí z rohů do rohů. \nNa podlaze se válí rezavé hřebíky a úlomky kovu. \nVýheň je studená a plná popela, vzduch je těžký a cítit po rzi a spáleném dřevě.");
        Prostor radnice = new Prostor("radnice", "Radnice \nVysoké stropy pokrývají pavučiny, zatímco prach se usadil na lavicích a stole starosty plném zažloutlých papírů. \nVybledlé portréty na popraskaných rámech visí na stěnách. \nPodlahy z tvrdého dřeva vrzají pod každým krokem. \nVzduch je zatuchlý a vlhký, okna jsou zamlžená a rozbitá, propouštějí jen slabé paprsky světla.");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        // začátek hry - rozcestí
        rozcesti.setVychod(bazina);
        rozcesti.setVychod(vesnice);
        rozcesti.setVychod(tajemna_pesina);
        // prostor bažiny
        bazina.setVychod(rozcesti);
        bazina.setVychod(chyse);
        chyse.setVychod(bazina);
        //prostor vesnice
        vesnice.setVychod(rozcesti);
        vesnice.setVychod(krcma);
        vesnice.setVychod(kovarna);
        vesnice.setVychod(radnice);
        krcma.setVychod(vesnice);
        kovarna.setVychod(vesnice);
        radnice.setVychod(vesnice);
        // tajemná pěšina spojující rozcestí a hrad
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


        aktualniProstor = rozcesti;  // hra začíná na rozcestí

        // Předměty v prostorech
        Predmet klic = new Predmet("klíč", true);
        Predmet mesec = new Predmet("měšec", true);

        Predmet lebka = new Predmet("lebka", true);
        Predmet zabiHlen = new Predmet("žabí_hlen", false);
        Predmet napojLasky = new Predmet("nápoj_lásky", true);

        Predmet kronika = new Predmet("kronika", true);
        Predmet pecetniPrsten = new Predmet("pečetní_prsten", true);
        Predmet svicen = new Predmet("svícen", false);

        Predmet brneni = new Predmet("rytířské_brnění", false);
        Predmet mec = new Predmet("meč", true);
        Predmet stit = new Predmet("štít", true);


        // Vložení předmětů do prostorů
        radnice.pridejPredmet(klic);
        radnice.pridejPredmet(mesec);

        chyse.pridejPredmet(lebka);
        chyse.pridejPredmet(zabiHlen);
        chyse.pridejPredmet(napojLasky);

        knihovna.pridejPredmet(kronika);
        knihovna.pridejPredmet(pecetniPrsten);
        knihovna.pridejPredmet(svicen);

        vstupni_sal.pridejPredmet(brneni);
        vstupni_sal.pridejPredmet(mec);
        vstupni_sal.pridejPredmet(stit);
    }

    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

}

package cz.vse.logika;

/**
 * Třída implementující toto rozhraní bude reprezentovat jeden předmět.
 *
 * @author David Subhan, subd02, subd02@vse.cz
 */
public interface IPredmet {

    /**
     * Metoda pro vrácení názvu předmětu.
     * @return název předmětu
     */
    public String getNazev();

    /**
     * Metoda pro vrácení přenosnosti předmětu.
     * @return true pokud je přenosný, false pokud není
     */
    public boolean getPrenosnost();
}

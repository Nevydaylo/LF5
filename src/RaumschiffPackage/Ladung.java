package RaumschiffPackage;

public class Ladung {
    private String bezeichnung;
    private int menge;

    public Ladung() {
    }

    public Ladung(String bezeichnung, int menge) {
        this.bezeichnung = bezeichnung;
        this.menge = menge;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setMenge(int menge) {
        this.menge = menge;
    }
    public int getMenge() {
        return menge;
    }

    public String toString() {
        return "Bezeichnung: " + bezeichnung + ", Menge: " + menge;
    }
}


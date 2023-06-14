package RaumschiffPackage;

import java.util.ArrayList;



public class Raumschiff extends Ladung {

    public static void main(String[] args) {

        Raumschiff meinRaumschiff = new Raumschiff(10, 100,
                75, 100, 100,
                5, "Enterprise");

        Raumschiff zielRaumschiff = new Raumschiff(5, 100,
                50, 100, 100,
                5, "Interstellar");
        meinRaumschiff.zustandRaumschiff();

        Ladung ladung1 = new Ladung("Lebensmittel", 50);
        Ladung ladung2 = new Ladung("Medizin", 20);
        meinRaumschiff.addLadung(ladung1);
        meinRaumschiff.addLadung(ladung2);
        meinRaumschiff.nachrichtAnAlle("Erster Logbucheintrag");
        meinRaumschiff.nachrichtAnAlle("Zweiter Logbucheintrag");

        meinRaumschiff.ladungsverzeichnisAusgeben();
        System.out.println("Logbuch Einträge:");
        ArrayList<String> logbuchEintraege = meinRaumschiff.eintraegeLogbuchZurueckgeben();
        for (String eintrag : logbuchEintraege) {
            System.out.println(eintrag);
        }


        meinRaumschiff.photonentorpedoSchiessen(zielRaumschiff);
        meinRaumschiff.phaserkanoneSchiessen(zielRaumschiff);
        meinRaumschiff.reparaturDurchfuehren(true,true,true,3);
        meinRaumschiff.nachrichtAnAlle("Hallo zusammen!");

    }
    private int photonentorpedoAnzahl;
    private int energieversorgungInProzent;
    private int schildeInProzent;
    private int huelleInProzent;
    private int lebenserhaltungssystemeInProzent;
    private int androidenAnzahl;
    private String schiffsname;
    private ArrayList<String> broadcastKommunikator;
    private ArrayList<Ladung> ladungsverzeichnis;
    private ArrayList<String> logbuchEintraege;

    // Konstruktoren
    public Raumschiff() {
    }

    public Raumschiff(int photonentorpedoAnzahl, int energieversorgungInProzent, int zustandSchildeInProzent,
                      int zustandHuelleInProzent, int zustandLebenserhaltungssystemeInProzent,
                      int anzahlDroiden, String schiffsname) {
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schildeInProzent = zustandSchildeInProzent;
        this.huelleInProzent = zustandHuelleInProzent;
        this.lebenserhaltungssystemeInProzent = zustandLebenserhaltungssystemeInProzent;
        this.androidenAnzahl = anzahlDroiden;
        this.schiffsname = schiffsname;
        this.broadcastKommunikator = new ArrayList<>();
        this.ladungsverzeichnis = new ArrayList<>();
        this.logbuchEintraege = new ArrayList<>();
    }

    public int getPhotonentorpedoAnzahl() {
        return photonentorpedoAnzahl;
    }

    public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahlNeu) {
        this.photonentorpedoAnzahl = photonentorpedoAnzahlNeu;
    }

    public int getEnergieversorgungInProzent() {
        return energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(int zustandEnergieversorgungInProzentNeu) {
        this.energieversorgungInProzent = zustandEnergieversorgungInProzentNeu;
    }

    public int getSchildeInProzent() {
        return schildeInProzent;
    }

    public void setSchildeInProzent(int zustandSchildeInProzentNeu) {
        this.schildeInProzent = zustandSchildeInProzentNeu;
    }

    public int getHuelleInProzent() {
        return huelleInProzent;
    }

    public void setHuelleInProzent(int zustandHuelleInProzentNeu) {
        this.huelleInProzent = zustandHuelleInProzentNeu;
    }

    public int getLebenserhaltungssystemeInProzent() {
        return lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(int zustandLebenserhaltungssystemeInProzentNeu) {
        this.lebenserhaltungssystemeInProzent = zustandLebenserhaltungssystemeInProzentNeu;
    }

    public int getAndroidenAnzahl() {
        return androidenAnzahl;
    }

    public void setAndroidenAnzahl(int androidenAnzahl) {
        this.androidenAnzahl = androidenAnzahl;
    }

    public String getSchiffsname() {
        return schiffsname;
    }

    public void setSchiffsname(String schiffsname) {
        this.schiffsname = schiffsname;
    }

    public void addLadung(Ladung neueLadung) {
        ladungsverzeichnis.add(neueLadung);
    }

    public void photonentorpedoSchiessen(Raumschiff r) {
        if (photonentorpedoAnzahl == 0) {
            nachrichtAnAlle("-=*Click*=-");
        } else {
            photonentorpedoAnzahl--;
            nachrichtAnAlle("Photonentorpedo abgeschossen!");
            if (r != this) {
                r.treffer(this);
            }
        }
    }
    public void phaserkanoneSchiessen(Raumschiff r) {
        if (energieversorgungInProzent < 50) {
            nachrichtAnAlle("-=*Click*=-");
        } else {
            energieversorgungInProzent -= 50;
            nachrichtAnAlle("Phaserkanone abgeschossen!");
            if (r != this) {
                r.treffer(this);
            }
        }
    }


    private void treffer(Raumschiff r) {
        System.out.println(getSchiffsname() + " wurde getroffen!");

        int neueSchildeInProzent = getSchildeInProzent() - 50;
        setSchildeInProzent(neueSchildeInProzent);

        if (neueSchildeInProzent <= 0) {
            int neueHuelleInProzent = getHuelleInProzent() - 50;
            int neueEnergieversorgungInProzent = getEnergieversorgungInProzent() - 50;
            setHuelleInProzent(neueHuelleInProzent);
            setEnergieversorgungInProzent(neueEnergieversorgungInProzent);

            if (neueHuelleInProzent <= 0) {
                System.out.println("Die Lebenserhaltungssysteme von " + getSchiffsname() + " wurden vernichtet!");
                setLebenserhaltungssystemeInProzent(0);
            }
        }
    }



    public void nachrichtAnAlle(String message) {
        broadcastKommunikator.add(message);
    }


    public ArrayList<String> eintraegeLogbuchZurueckgeben() {
        return broadcastKommunikator;
    }

    public void photonentorpedosLaden(int anzahlTorpedos) {

        photonentorpedoAnzahl += anzahlTorpedos;
    }

    public void reparaturDurchfuehren(boolean schutzschilde, boolean energieversorgung, boolean schiffshuelle,
                                      int anzahlDroiden) {
    }

    public void zustandRaumschiff() {
        System.out.println("Zustand des Raumschiffs: " + getSchiffsname());
        System.out.println("Photonentorpedo Anzahl: " + getPhotonentorpedoAnzahl());
        System.out.println("Energieversorgung in Prozent: " + getEnergieversorgungInProzent() + "%");
        System.out.println("Schilde in Prozent: " + getSchildeInProzent() + "%");
        System.out.println("Hülle in Prozent: " + getHuelleInProzent() + "%");
        System.out.println("Lebenserhaltungssysteme in Prozent: " + getLebenserhaltungssystemeInProzent() + "%");
        System.out.println("Anzahl Androiden: " + getAndroidenAnzahl());
        System.out.println("Ladungsverzeichnis: ");
        ladungsverzeichnisAusgeben();
        System.out.println("Logbuch Einträge: ");
        for (String eintrag : eintraegeLogbuchZurueckgeben()) {
            System.out.println(eintrag);
        }
    }


    public void ladungsverzeichnisAusgeben() {
       System.out.println("Ladungsverzeichnis:");
        for (Ladung ladung : ladungsverzeichnis) {
            System.out.println("Bezeichnung: " + ladung.getBezeichnung() + ", Menge: " + ladung.getMenge());
        }
    }

    public void ladungsverzeichnisAufraeumen() {
        ladungsverzeichnis.clear();
    }



}


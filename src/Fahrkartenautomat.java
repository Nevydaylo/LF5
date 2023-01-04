
import java.util.Scanner;
import java.text.DecimalFormat;

class Fahrkartenautomat {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.#");
        begreussung();
        Scanner tastatur = new Scanner(System.in);
        double zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
        System.out.println("Zu zahlender Betrag: " +  df.format(zuZahlenderBetrag) + "€ ");
        double eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
        double rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        System.out.println("Rückgabebetrag: " + df.format(rueckgabebetrag) + " €");
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        rueckgeldAusgabe(rueckgabebetrag, eingezahlterGesamtbetrag, zuZahlenderBetrag);
        fahrkartenAusgeben();

    }

    public static void begreussung (){
        System.out.println("Herzlich Wilkommen!");
        System.out.println();
    }

    // Kartenauswahl und Ticketauswahl
    public static double fahrkartenbestellungErfassen (Scanner tastatur){
        DecimalFormat df = new DecimalFormat("#.#");

        int ticketQuantity;
        double ticketPrice;
        double totalCost = 0.0;
        int ticketOption;


        // Schleife, bis der Benutzer die Option "Bezahlen" auswählt
        do {
        // Anzeige der Ticketoptionen
        System.out.println("Wählen Sie ihre Wunschfahrkarten für Berlin AB aus:");
        System.out.println("  Kurzstrecke AB [2,00 EUR] (1)");
        System.out.println("  Einzelfahrschein AB [3,00 EUR] (2)");
        System.out.println("  Tageskarte AB [8,80 EUR] (3)");
        System.out.println("  4-Fahrten-Karte AB [9,40 EUR] (4)");
        System.out.println("  Bezahlen (9)");
        System.out.print("Ihre Wahl: ");
        ticketOption = tastatur.nextInt();

        // Berechnung des Preises des ausgewählten Tickets
        if (ticketOption == 1) {
        ticketPrice = 2.00; // Kurzstreckenticket
        } else if (ticketOption == 2) {
        ticketPrice = 3.00; // Einzelfahrschein
        } else if (ticketOption == 3) {
        ticketPrice = 8.80; // Tageskarte
        } else if (ticketOption == 4) {
        ticketPrice = 9.40; // 4-Fahrten-Karte
        } else {
        ticketPrice = 0.0; // Ungültige Option
        }

        // Falls ein gültiges Ticket ausgewählt wurde, Benutzer auffordern, die Anzahl einzugeben
        if (ticketPrice > 0.0) {
        System.out.print("Anzahl der Fahrkarten (1 bis 10): ");
        ticketQuantity = tastatur.nextInt();

        // Überprüfung, ob die eingegebene Anzahl gültig ist
        while (ticketQuantity < 1 || ticketQuantity > 10) {
        System.out.println("Ungültiger Wert. Bitte geben Sie eine Zahl zwischen 1 und 10 ein.");
        System.out.print("Anzahl der Fahrkarten (1 bis 10): ");
        ticketQuantity = tastatur.nextInt();
        }

        // Berechnung des Gesamtpreises für die ausgewählten Tickets
        double ticketCost = ticketQuantity * ticketPrice;
        totalCost += ticketCost;
            // Anzeige der Zwischensumme
            System.out.println("Zwischensumme: " + df.format(totalCost) + " €");
        } else if (ticketOption != 9) {
            // Falls eine ungültige Ticketoption ausgewählt wurde, Benutzer darauf hinweisen
            System.out.println("Ungültige Option. Bitte wählen Sie eine der angegebenen Optionen aus.");
        }
        } while (ticketOption != 9); // Schleife wird beendet, wenn die Option "Bezahlen" ausgewählt wurde

        return totalCost;
    }

    public static double fahrkartenBezahlen (Scanner tastatur, double zuZahlenderBetrag){
        DecimalFormat df = new DecimalFormat("#.#");

        double eingeworfeneMuenze;
        double eingezahlterGesamtbetrag;
        double nochZuZahlen;

        eingezahlterGesamtbetrag = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.println("Noch zu zahlen: " + df.format(nochZuZahlen) + "€ ");
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (eingeworfeneMuenze != 5.0 && eingeworfeneMuenze != 10.0 && eingeworfeneMuenze != 20.0
                    && eingeworfeneMuenze != 1.0 && eingeworfeneMuenze != 2.0) {
                System.out.println("Ungültig nur 5, 10, 20 Euro Scheine oder 1, 2 Euro Münzen erlaubt.");

            } else {
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            }
        }
            return eingezahlterGesamtbetrag;
    }

    public static void fahrkartenAusgeben () {

        System.out.println("\nFahrscheine werden ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
        System.out.println("Danke für ihren Einkauf bei uns.");
        System.out.println("Bitte entnehmen Sie ihre Fahrscheine.");
    }

    public static void rueckgeldAusgabe (double rueckgabebetrag, double eingezahlterGesamtbetrag, double zuZahlenderBetrag){

        DecimalFormat df = new DecimalFormat("#.#");
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + df.format(rueckgabebetrag)  + " €");
            System.out.println("wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 2.0;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 1.0;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.5;
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.2;
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.1;
            }
            while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.05;
            }
    }
}
}




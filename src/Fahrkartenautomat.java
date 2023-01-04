import java.util.Scanner;
import java.text.DecimalFormat;

class Fahrkartenautomat {
    public static void main(String[] args) {
        begreussung();
        Scanner tastatur = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.#");

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int ticketOption;
        int ticketQuantity;
        double ticketPrice;
        double totalCost = 0.0;

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

        zuZahlenderBetrag = totalCost; // Preis pro Fahrkarte AB usw.
        System.out.println("Zu zahlender Betrag (Euro): " + zuZahlenderBetrag);

        // 2
        eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;
        eingeworfeneMuenze = 0.0;
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.println("Noch zu zahlen: " + df.format(nochZuZahlen));
            System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
            eingeworfeneMuenze = tastatur.nextDouble();
            if (eingeworfeneMuenze != 5.0 && eingeworfeneMuenze != 10.0 && eingeworfeneMuenze != 20.0
                    && eingeworfeneMuenze != 1.0 && eingeworfeneMuenze != 2.0) {
                System.out.println("Ungültig nur 5, 10, 20 Euro Scheine oder 1, 2 Euro Münzen erlaubt.");
                eingeworfeneMuenze = 0.0;
            } else {
                eingezahlterGesamtbetrag += eingeworfeneMuenze;
            }
        }
        // 3
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

        // 4
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + df.format(rueckgabebetrag)  + " Euro");
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
        // 5
        System.out.println("Danke für ihren Einkauf bei uns.");
        System.out.println("Bitte entnehmen Sie ihre Fahrscheine.");
    }

    public static void begreussung (){
        System.out.println("Herzlich Wilkommen!");
        System.out.println();
    }



}




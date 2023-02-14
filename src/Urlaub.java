import java.util.Scanner;

public class Urlaub {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);

        System.out.print("Geben Sie Ihr gesamtes Reisebudget an: ");
        double reiseKasse = tastatur.nextDouble();

        final double RESERVE = reiseKasse * 0.1;

        System.out.printf("Ihre Reserve beträgt: %.2f€\n", RESERVE);

        reiseKasse = calculator(tastatur, reiseKasse, RESERVE);

        System.out.printf("\nProgramm wurde Heruntergefahren, Reserve: %.2f€\n", reiseKasse);
    }

    public static double calculator(Scanner tastatur, double reiseKasse, final double RESERVE) {
        while (true) {
            double umrechneRate;
            String waehrung;
            while (true) {
                System.out.println("\nWelches Land wollen Sie auswählen?");
                System.out.println("  USA: 'U'");
                System.out.println("  Japan: 'J'");
                System.out.println("  England: 'E'");
                System.out.println("  Schweiz: 'S'");
                System.out.println("  Dänemark: 'D'");
                System.out.print("\nIhre eingabe: ");

                char eingabe = tastatur.next().charAt(0);

                if (eingabe == 'U' || eingabe == 'u') {
                    umrechneRate = 0.98;
                    waehrung = "USD (Dollar)";
                    break;
                } else if (eingabe == 'J' || eingabe == 'j') {
                    umrechneRate = 141;
                    waehrung = "JPY (Yen)";
                    break;
                } else if (eingabe == 'E' || eingabe == 'e') {
                    umrechneRate = 0.88;
                    waehrung = "GBP (Pfund)";
                    break;
                } else if (eingabe == 'S' || eingabe == 's') {
                    umrechneRate = 0.96;
                    waehrung = "CHF (Franken)";
                    break;
                } else if (eingabe == 'D' || eingabe == 'd') {
                    umrechneRate = 7.44;
                    waehrung = "DKK (Kronen)";
                    break;
                } else {
                    System.out.println("\nFehler! Keine gültige Eingabe!");
                }
            }

            System.out.print("\nWie viele Euros wollen Sie umwechseln? ");

            double euro = tastatur.nextDouble();
            if (reiseKasse - euro >= RESERVE) {
                reiseKasse -= euro;

                System.out.printf("Sie erhalten %.2f %s\n", euro * umrechneRate, waehrung);
                System.out.printf("Ihr freies Reisebudget beträgt: %.2f€ + %.2f€ (Reserve)\n", reiseKasse - RESERVE, RESERVE);
            } else {
                System.out.printf("Sie fallen unter Ihre %.2f€ Reserve\n", RESERVE);
                System.out.print("Wollen Sie mehr in Ihre Reisekasse einzahlen? (y/n) ");
                if (willMehrEinzahlen(tastatur)) {
                    System.out.print("\nGeben Sie den Wert ein den Sie einzahlen möchten: ");
                    reiseKasse += tastatur.nextDouble();
                    System.out.printf("Neuer Reisekasse Wert: %.2f€ + %.2f€ (Reserve)\n", reiseKasse - RESERVE, RESERVE);
                } else {
                    return reiseKasse;
                }
            }
        }
    }

    public static boolean willMehrEinzahlen(Scanner tastatur){
        while(true) {
            char eingabe = tastatur.next().charAt(0);

            if (eingabe == 'y' || eingabe == 'Y') {
                return true;
            } else if (eingabe == 'n' || eingabe == 'N') {
                return false;
            } else {
                System.out.println("\nFehler! Nur die Eingaben y und n sind möglich! ");
            }
        }
    }
}
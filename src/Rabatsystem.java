import java.util.Scanner;

        public class Rabatsystem {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in); // Erstellt eine neue Scanner-Instanz

                System.out.print("Bitte geben Sie den Bestellwert ein: ");
                double orderAmount = scanner.nextDouble(); // Liest den Bestellwert ein

                double discount = 0; // Initialisiert den Rabatt auf 0

                // Berechnet den Rabatt basierend auf dem Bestellwert
                if (orderAmount > 0 && orderAmount <= 100) {
                    discount = 0.1; // Rabatt von 10 %
                } else if (orderAmount > 100 && orderAmount <= 500) {
                    discount = 0.15; // Rabatt von 15 %
                } else if (orderAmount > 500) {
                    discount = 0.2; // Rabatt von 20 %
                }

                double discountedAmount = orderAmount - (orderAmount * discount); // Berechnet den ermäßigten Bestellwert

                // Gibt den ermäßigten Bestellwert aus gghghg
                System.out.println("Der ermäßigte Bestellwert beträgt: " + discountedAmount + "€");
            }
        }


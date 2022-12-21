import java.util.Scanner;

public class Schaltjahr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Jahr abfragen
        System.out.print("Bitte geben Sie eine Jahreszahl ein: ");
        int jahr = scanner.nextInt();

        // Prüfen, ob es sich um ein Schaltjahr handelt
        boolean schaltjahr = false;
        if (jahr % 4 == 0) {
            if (jahr % 100 == 0) {
                if (jahr % 400 == 0) {
                    schaltjahr = true;
                }
            } else {
                schaltjahr = true;
            }
        }

        // Ausgabe
        if (schaltjahr) {
            System.out.println(jahr + " ist ein Schaltjahr.");
        } else {
            System.out.println(jahr + " ist kein Schaltjahr.");
        }
    }
}

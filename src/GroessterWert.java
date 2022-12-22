import java.util.Scanner;
public class GroessterWert {

    public static void main(String[] args) {
        Scanner Tastatur = new Scanner(System.in);
        int a, b, c, max;

        // Eingabe
        System.out.print("a: ");
        a = Tastatur.nextInt();
        System.out.print("b: ");
        b = Tastatur.nextInt();
        System.out.print("c: ");
        c = Tastatur.nextInt();

        // Verabeitung
        if ( a > b)  {
            max = Math.max(a, c);
        }
        else {
            max = Math.max(b, c);
        }
        System.out.println("Der größte eingegebene Wert ist: " + max);
    }
}
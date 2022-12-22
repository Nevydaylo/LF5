import java.util.Scanner;

class Summe {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);

int n;
        int sum = 0;

        System.out.print("Bitte geben Sie eine Zahl ein: ");
        n = tastatur.nextInt();

        for (int i = 1; i <= n; i++) {
        System.out.print(i + " ");
        sum += i;
        }

        System.out.println();
        System.out.println("Summe: " + sum);
        }
}

import java.util.Scanner;

public class Rom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine römische Zahl ein: ");
        String roman = scanner.nextLine();

        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            int value = getValue(c);
            if (i + 1 < roman.length()) {
                int nextValue = getValue(roman.charAt(i + 1));
                if (nextValue > value) {
                    result += (nextValue - value);
                    i++;
                } else {
                    result += value;
                }
            } else {
                result += value;
            }
        }
        System.out.println("Die Dezimalzahl ist: " + result);
    }

    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Ungültiges römisches Zeichen: " + c);
        };
    }
}

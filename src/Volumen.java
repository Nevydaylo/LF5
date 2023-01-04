public class Volumen {
    public static void main(String[] args) {
        System.out.println(volumenBerechnung(2));
        System.out.println(volumenBerechnung(5));
    }

    public static double volumenBerechnung (double seitenlänge) {
        double volumen = seitenlänge * seitenlänge * seitenlänge;
        return volumen;
    }
}

public class Fahrplan {
    public static void main(String[] args) {

        // Weichestellungen
        int fahrzeit = 0;
        char haltInSpandau = 'n';
        char richtungHamburg = 'n';
        char haltInStendal = 'j';
        char endetIn = 'h';
        char haltinStendal = 'j';
        char haltWolfsburg = 'j';
        char haltBraunschweig = 'j';

        fahrzeit = fahrzeit + 8; // Fahrzeit Hbf -> Spandau

        if (haltInSpandau == 'j') {
            fahrzeit = fahrzeit + 2; // Halt in Spandau
        }
        else if (richtungHamburg == 'j') {
            fahrzeit = fahrzeit + 96;
            System.out.print("Sie erreichen Hamburg nach" +fahrzeit + " Minuten");
        }
        else if (richtungHamburg == 'n') {
            fahrzeit = fahrzeit + 34;
        }
        else if (haltinStendal == 'n') {
            fahrzeit += 6;
        }
        else if (haltinStendal == 'j') {
            fahrzeit += 16;
        }
        else if (haltWolfsburg == 'j') {
            fahrzeit += 29;
            System.out.print("Sie erreichen Wolfsburg nach" +fahrzeit + " Minuten");
        }
        else if (haltWolfsburg == 'n' && haltBraunschweig == 'j') {
            fahrzeit += 50;
            System.out.print("Sie erreichen Braunschweig nach" +fahrzeit + " Minuten");
        }
        else if (haltBraunschweig == 'n') {
            fahrzeit += 62;
            System.out.print("Sie erreichen Hannover nach" +fahrzeit + " Minuten");

        }

    }

}
import java.util.Random;

public class LottoNumbers {
    public static void main(String[] args) {
        Random rnd = new Random();

        // Generate 5 main numbers between 1 and 50
        for (int i = 0; i < 6; i++) {
            int mainNumber = rnd.nextInt(49) + 1;
            System.out.print(mainNumber + " ");
        }

        System.out.print("| ");

        // Generate 2 unique Euro numbers between 1 and 10
        int euroNumber1 = 0;
        euroNumber1 = rnd.nextInt(10) + 1;
       // int euroNumber2 = 0;
       // while (euroNumber1 //== euroNumber2) {

           // euroNumber2 = rnd.nextInt(10) + 1;
        //}
        System.out.print(euroNumber1); //+ //euroNumber2);
    }
}

public class Passwort {
    public static void main(String[] args) {
        int[] validPasscodes = new int[4];
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (checkPasscode(i)) {
                validPasscodes[count] = i;
                count++;
            }
        }

        for (int i = 0; i < validPasscodes.length; i++) {
            System.out.println(validPasscodes[i]);
        }
    }

    public static boolean checkPasscode(int H4X0R) {
        // gibt true zurück, falls das Passwort korrekt ist.
        boolean result = false;
        for (int E1337 = 42; E1337 <= (52 ^ (0x6c)); E1337 += (3 << (14 % 6))) {
            if (result = ((++E1337 | E1337 + (2 >>> 1)) ^ (1 + H4X0R)) == (123456789 & 0)) {
                break;
            }
        }
        return result;
    }
}

package commonUtils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomSource {

    public static String generateRandomString(int size) {
        String firstLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder randomString = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            randomString.append(AlphaNumericString.charAt(index));
        }
        return randomString.toString();
    }

    public static String generateRandomEmail(int size) {
        String Email;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        Email = sb.toString() + "@test.com";
        return Email;
    }

    public static String generateRandomNumber(int size) {
        String AlphaNumericString = "0123456789";
        StringBuilder randomNumber = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = (int) (AlphaNumericString.length()
                    * Math.random());
            randomNumber.append(AlphaNumericString
                    .charAt(index));
        }
        return randomNumber.toString();
    }


    public static String nameWithFirstCapitalLetter(int size) {
        String firstLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder randomString = new StringBuilder(size);
        for (int i = 0; i < size - 1; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            randomString.append(AlphaNumericString.charAt(index));
        }
        StringBuilder randomString2 = new StringBuilder(size);
        int index = (int) (firstLetter.length() * Math.random());
        randomString2.append(firstLetter.charAt(index));
        return randomString2 + randomString.toString();
    }

    public static String getPassword(int length) {
        char[] SYMBOLS = "^$*.[]{}()?-\"!@#%&/\\,><':;|_~`".toCharArray();
        char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] NUMBERS = "0123456789".toCharArray();
        char[] ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789^$*.[]{}()?-\"!@#%&/\\,><':;|_~`".toCharArray();
        Random rand = new SecureRandom();

        assert length >= 4;
        char[] password = new char[length];

        password[0] = LOWERCASE[rand.nextInt(LOWERCASE.length)];
        password[1] = UPPERCASE[rand.nextInt(UPPERCASE.length)];
        password[2] = NUMBERS[rand.nextInt(NUMBERS.length)];
        password[3] = SYMBOLS[rand.nextInt(SYMBOLS.length)];

        for (int i = 4; i < length; i++) {
            password[i] = ALL_CHARS[rand.nextInt(ALL_CHARS.length)];
        }

        for (int i = 0; i < password.length; i++) {
            int randomPosition = rand.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomPosition];
            password[randomPosition] = temp;
        }

        return new String(password);
    }

}

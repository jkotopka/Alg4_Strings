package org.kotopka;

import java.util.Random;

public class RandStringGen {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERALS = "0123456789";
    private static final Random rand = new Random();

    public static String generate(int length) {
        String alphabet = LOWER + UPPER + NUMERALS;
        return generate(alphabet, length);
    }

    public static String generate(String alphabet, int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(generate(rand.nextInt(10)));
        }
    }
}

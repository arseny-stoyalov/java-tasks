package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the fifth pack of tasks
 * number in brackets (in commentaries) is a task No
 *
 * @author Stoyalov Arseny BVT1803
 */
public final class Fifth {

    /**
     * Encodes string by making an integer
     * array of the same size where
     * each element is 'code of char at the same position -
     * code of previous char'. First element is just
     * first character's code
     * (1)
     */
    public static int[] encrypt(String str) {

        char[] chars = str.toCharArray();
        int[] res = new int[chars.length];
        res[0] = chars[0];
        for (int i = 1; i < res.length; i++)
            res[i] = chars[i] - chars[i - 1];
        return res;
    }

    /**
     * Decodes integer array where elements are
     * the difference between char codes of the
     * same and previous positions is resulting
     * string
     * (1)
     *
     * @return Decoded message
     */
    public static String decrypt(int[] codes) {

        char[] chars = new char[codes.length];
        chars[0] = (char) codes[0];
        for (int i = 1; i < chars.length; i++)
            chars[i] = (char) (codes[i] + chars[i - 1]);
        return new String(chars);
    }

    /**
     * Checks if chess piece can potentially move
     * from one position
     * (2)
     *
     * @param piece Name of a chess piece starting with a capital
     * @param now   Current position
     * @param next  Position to move to
     */
    public static boolean canMove(String piece, String now, String next) {

        int numDiff = Math.abs(now.charAt(1) - next.charAt(1));
        int letterDiff = Math.abs(now.charAt(0) - next.charAt(0));
        if (numDiff == 0 && letterDiff == 0) return true;
        switch (piece) {
            case "Pawn":
                if (now.charAt(1) > next.charAt(1)) return false;
                return (letterDiff == 0 && numDiff < 3) || (letterDiff == 1 && numDiff == 1);
            case "Knight":
                return numDiff == 2 && letterDiff == 1;
            case "Bishop":
                return numDiff == letterDiff;
            case "Rook":
                return numDiff == 0 || letterDiff == 0;
            case "Queen":
                return (numDiff == 0 || letterDiff == 0) || (numDiff == letterDiff);
            case "King":
                return numDiff < 2 && letterDiff < 2;
        }
        return false;
    }

    /**
     * Checks if the first given word can become
     * other given word only by adding characters
     * (no removing)
     * (3)
     *
     * @param inner Word to add characters to
     * @param full  Word to get as a result
     */
    public static boolean canComplete(String inner, String full) {

        if (inner.length() > full.length()) return false;
        boolean canComplete = true;
        for (int i = 0; i < inner.length() && canComplete; i++) {
            if (inner.charAt(i) != full.charAt(i)) {
                canComplete = false;
                for (int j = i + 1; j < full.length(); j++) {
                    if (inner.charAt(i) == full.charAt(j)) {
                        canComplete = true;
                        break;
                    }
                }
            }
        }
        return canComplete;
    }

    /**
     * Sums up all given arguments then
     * multiplies all digits of the result
     * until in becomes a one-digit number
     * (4)
     *
     * @return one-digit result of multiplying
     */
    public static int sumDigProd(int... args) {

        String sum = String.valueOf(Arrays.stream(args).reduce(0, Integer::sum));
        while (Integer.parseInt(sum) / 10 != 0) {
            int prod = 1;
            for (int i = 0; i < sum.length(); i++)
                prod *= Character.getNumericValue(sum.charAt(i));
            sum = String.valueOf(prod);
        }
        return Integer.parseInt(sum);
    }

    /**
     * Finds all words in array of String
     * that have the same vowels (at any
     * position and in any number) as
     * the first one
     * (5)
     *
     * @param args Array of words to proceed
     * @return Array of all matching words
     */
    public static String[] sameVowelGroup(String[] args) {

        int[] vowels = args[0].chars()
                .map(Character::toLowerCase)
                .filter(c -> c == 'a' || c == 'o' || c == 'i' || c == 'e' || c == 'u')
                .distinct().toArray();

        return Arrays.stream(args)
                .map(String::toLowerCase)
                .filter(str -> Arrays.equals(
                        str.chars()
                                .filter(c -> c == 'a' || c == 'o' || c == 'i' || c == 'e' || c == 'u')
                                .distinct().toArray(), vowels))
                .toArray(String[]::new);
    }

    /**
     * Checks if card number is valid
     * by checking the number of digits
     * in it (should be 14-19)
     * and using Luhn's algorithm
     * (6)
     *
     * @param id Card number
     * @return true if valid
     */
    public static boolean validateCard(long id) {

        StringBuilder strId = new StringBuilder(String.valueOf(id));
        if (strId.length() > 19 || strId.length() < 14) return false;
        char checkNum = strId.charAt(strId.length() - 1);
        strId.deleteCharAt(strId.length() - 1).reverse();
        for (int i = 0; i < strId.length(); i += 2) {
            String prod = String.valueOf(Character.getNumericValue(strId.charAt(i)) * 2);
            if (prod.length() > 1)
                prod = String.valueOf(Character.getNumericValue(prod.charAt(0))
                        + Character.getNumericValue(prod.charAt(1)));
            strId.setCharAt(i, prod.charAt(0));
        }
        int sum = strId.chars()
                .reduce((a, b) -> Character.forDigit((char) a, 10) + Character.forDigit((char) b, 10))
                .orElse(0);
        char realNum = Character.forDigit(10 - (sum % 10), 10);
        return realNum == checkNum;
    }

    private static final String[] tensEng = {
            "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
            "", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] onesEng = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    /**
     * Takes number and returns its
     * English equivalent
     * (7)
     */
    public static String numToEng(int num) {

        StringBuilder builder = new StringBuilder();
        builder.append(onesEng[num / 100]).append(num / 100 == 0 ? "" : " hundred ");
        if (num % 100 < 20 && num % 100 > 10) builder.append(tensEng[num % 100]);
        else builder
                .append(tensEng[(num % 100) / 10])
                .append((num % 100) / 10 == 0 ? "" : " ")
                .append(onesEng[num % 10]);
        return builder.toString();
    }

    private static final String[] hundredsRus = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"
    };

    private static final String[] tensRus = {
            "", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят",
            "девяносто", "",
            "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать",
            "восемнадцать", "девятнадцать"
    };

    private static final String[] onesRus = {
            "", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"
    };

    /**
     * Takes number and returns its
     * Russian equivalent
     * (7)
     */
    public static String numToRus(int num) {

        StringBuilder builder = new StringBuilder();
        builder.append(hundredsRus[num / 100]).append(num / 100 == 0 ? "" : " ");
        if (num % 100 < 20 && num % 100 > 10) builder.append(tensRus[num % 100]);
        else builder
                .append(tensRus[(num % 100) / 10])
                .append((num % 100) / 10 == 0 ? "" : " ")
                .append(onesRus[num % 10]);
        return builder.toString();
    }

    /**
     * Returns SHA-256 hash of a given String
     * (8)
     */
    public static String getSha256Hash(String str) {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (digest == null) return null;

        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            String hexStr = Integer.toHexString(0xff & b);
            if (hexStr.length() == 1) hex.append('0');
            hex.append(hexStr);
        }
        return hex.toString();
    }

    /**
     * Returns correct Game of Thrones character's
     * title with the correct cases
     * (9)
     */
    public static String correctTitle(String title) {

        List<String> lowerCases = List.of("and", "the", "of", "in");
        String[] words = title.toLowerCase().split(" ");
        String[] res = Arrays.stream(words)
                .map(word -> {
                    if (!lowerCases.contains(word))
                        word = word.toUpperCase().charAt(0) + word.substring(1);
                    return word;
                }).toArray(String[]::new);
        return String.join(" ", res);
    }

    /**
     * Checks if number is a hexagonal lattice.
     * If it is returns the ASCII-illustration
     * of it and the word 'Invalid' otherwise
     * (10)
     */
    public static String hexLattice(int num) {

        int edge = 1;
        boolean isLattice = false;
        int nextHexLattice = 1;
        while (nextHexLattice <= num && !isLattice) {
            if (num == nextHexLattice)
                isLattice = true;
            else {
                edge++;
                nextHexLattice += 6 * (edge - 1);
            }
        }
        if (!isLattice) return "Invalid";

        StringBuilder builder = new StringBuilder();
        int spaces = edge;
        int letters = edge;
        for (int i = 0; i < edge * 2 - 1; i++) {
            builder.append(" ".repeat(spaces));
            builder.append("o ".repeat(letters));
            builder.append("\n");
            if (i < edge - 1) {
                spaces--;
                letters++;
            } else {
                spaces++;
                letters--;
            }
        }

        return builder.toString();
    }

}

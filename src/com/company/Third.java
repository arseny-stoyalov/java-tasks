package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents the third pack of tasks
 * number in brackets (in commentaries) is a task No
 *
 * @author Stoyalov Arseny BVT1803
 */
public final class Third {

    /**
     * Finds the amount of solutions a quadratic
     * equation has
     * (1)
     *
     * @param a first coefficient
     * @param b second coefficient
     * @param c third coefficient
     * @return short number of solutions
     */
    public static short solutions(int a, int b, int c) {

        int d = b * b - 4 * a * c;
        if (d > 0) return 2;
        if (d < 0) return 0;
        return 1;
    }

    /**
     * Finds index of second appearance of
     * the word 'zip' in give text
     * (2)
     *
     * @param text to find in
     * @return index if there are at least
     * 2 appearances of 'zip', -1 otherwise
     */
    public static int findZip(String text) {
        return text.indexOf("zip", text.indexOf("zip") + 1);
    }

    /**
     * Checks if number is perfect i.e.
     * equals to the sum of its proper
     * positive divisors
     * (3)
     *
     * @param num to check
     * @return true if perfect
     */
    public static boolean checkPerfect(int num) {

        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    /**
     * Flips first and last chars of a word
     * (4)
     *
     * @param word of String
     * @return changed word or a message
     */
    public static String flipEndChars(String word) {

        if (word.length() < 2) return "Incompatible.";
        char first = word.charAt(0);
        char second = word.charAt(word.length() - 1);
        if (first == second) return "Two's a pair";
        return second + word.substring(1, word.length() - 1) + first;
    }

    /**
     * Checks if given code is valid i.e.
     * starts with '#' which is followed by
     * 6 numbers or letters A-F case insensitively
     * (5)
     *
     * @param code of String to check
     * @return true if valid
     */
    public static boolean isValidHexCode(String code) {
        Matcher matcher = Pattern.compile("#[0-9A-Fa-f]{6}+").matcher(code);
        return matcher.matches();
    }

    /**
     * Checks if first array has the same number of
     * unique elements as second array
     * (6)
     *
     * @param arr1 first array
     * @param arr2 second array
     * @return true if has
     */
    public static boolean same(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();
        for (int a : arr1) set.add(a);
        int a1 = set.size();
        set.clear();
        for (int a : arr2) set.add(a);
        return a1 == set.size();
    }

    /**
     * Checks if given number is a Kaprekar number
     * (7)
     *
     * @param num of int to check
     * @return true if Kaprekar
     */
    public static boolean isKaprekar(int num) {

        String square = String.valueOf((int) Math.pow(num, 2));
        if (square.length() < 2) square = "0" + square;
        int length = square.length();
        int right, left = 0;
        left = Integer.parseInt(square.substring(0, length / 2));
        right = Integer.parseInt(square.substring(length / 2));
        return left + right == num;
    }

    /**
     * Finds substring which consist of
     * the longest row of zero numbers
     * (8)
     *
     * @param binary code of String
     * @return the longest row of zero numbers
     */
    public static String longestZero(String binary) {

        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') builder.append("0");
            else {
                if (!builder.toString().equals("")) list.add(builder.toString());
                builder.setLength(0);
            }
        }
        String res = "";
        for (String zeros : list)
            if (zeros.length() > res.length()) res = zeros;
        return res;
    }

    /**
     * Finds next prime number after the given one
     * (9)
     *
     * @param num if int to proceed
     * @return given number if it's prime
     * or next prime number if it isn't
     */
    public static int nextPrime(int num) {

        if (num < 2) return 2;
        boolean isPrime = true;
        for (int i = 2; i < num && isPrime; i++)
            if (num % i == 0) isPrime = false;
        if (isPrime) return num;

        while (!isPrime) {
            num++;
            isPrime = true;
            for (int i = 2; i < num && isPrime; i++)
                if (num % i == 0) isPrime = false;
        }
        return num;
    }

    /**
     * Checks if given edge values can make a right
     * triangle
     * (10)
     *
     * @param a first edge
     * @param b second edge
     * @param c third edge
     * @return true if edges can represent
     * right triangle
     */
    public static boolean rightTriangle(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        return a == max ? Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)
                : b == max ? Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)
                : Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
    }

}

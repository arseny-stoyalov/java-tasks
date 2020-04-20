package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents the second pack of tasks
 * number in brackets (in commentaries) is a task No
 * @author Stoyalov Arseny BVT1803
 */
public final class Second {

    /**
     * Method repeats each each letter in a word n times
     * (1)
     * @param word that will have repeated letters
     * @param times to repeat
     * @return result as String
     */
    public static String repeat(String word, int times){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(String.valueOf(word.charAt(i)).repeat(Math.max(0, times)));
        }
        return builder.toString();
    }

    /**
     * Finds smallest and largest numbers in array
     * and subtract one from another
     * (2)
     * @param array to proceed
     * @return difference between min and max
     */
    public static int differenceMaxMin(int[] array){
        int max = 0;
        int min = 0;
        for (int a : array) {
            if (a > max) max = a;
            if (a < min) min = a;
        }
        return max - min;
    }

    /**
     * Checks if average value of array elements is integer
     * (3)
     * @param array to proceed
     * @return true if integer
     */
    public static boolean isAvgWhole(int[] array){
        int sum = 0;
        for (int a : array) sum += a;
        return sum % array.length == 0;
    }

    /**
     * Takes array and makes its elements equal to sum
     * of all previous elements
     * (4)
     * @param array to proceed
     * @return array where element is the sum of previous ones
     */
    public static int[] cumulativeSum(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }
        return array;
    }

    /**
     * Finds out how many digits to the right of the
     * decimal point there are in the number
     * (5)
     * @param num String value of number
     * @return amount of digit
     */
    public static int getDecimalPlaces(String num){
        try {
            double n = Double.parseDouble(num);
        }
        catch (Exception e) {
            return -1;
        }
        String decimals = num.substring(num.indexOf('.') + 1);
        return decimals.length();
    }

    /**
     * Returns an element of the Fibonacci row at
     * a certain spot
     * (6)
     * @param num number of element to search
     * @return element
     */
    public static long Fibonacci(int num){
        long first = 1;
        long second = 1;
        for (int i = 2; i <= num; i++) {
            long temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

    /**
     * Checks if post index is valid i.e. is no longer than 5
     * digits and contains digits only
     * (7)
     * @param index String value of index to proceed
     * @return true if valid
     */
    public static boolean isValid(String index){
        if (index.length() > 5 || index.length() == 0) return false;
        Matcher matcher = Pattern.compile("[\\D]+").matcher(index);
        return !matcher.find();
    }

    /**
     * Checks if first word starts with a letter that is the last
     * letter os second word and vice versa
     * (8)
     * @param first word
     * @param second word
     * @return if the condition is met
     */
    public static boolean isStrangePair(String first, String second){
        return first.charAt(0) == second.charAt(second.length() - 1)
                && first.charAt(first.length() - 1) == second.charAt(0);
    }

    /**
     * Checks if word has the given prefix
     * (9)
     * @param word to check
     * @param prefix to check
     * @return true if has
     */
    public static boolean isPrefix(String word, String prefix){
        if (prefix.charAt(prefix.length() - 1) == '-') prefix = prefix.substring(0, prefix.length() - 1);
        return prefix.equals(word.substring(0, prefix.length()));
    }

    /**
     * Checks if word has the given suffix
     * (9)
     * @param word to check
     * @param suffix to check
     * @return true if has
     */
    public static boolean isSuffix(String word, String suffix){
        if (suffix.charAt(0) == '-') suffix = suffix.substring(1);
        return suffix.equals(word.substring(word.length() - suffix.length()));
    }

    /**
     * Returns the amount of blocks produced
     * at a certain stage of an algorithm.
     * At the first stage three blocks appear,
     * at the second one disappears, then
     * it all loops
     * (10)
     * @param step at which blocks will be produced
     * @return amount of blocks
     */
    public static int boxSeq(int step){
        switch(step % 2){
            case 1: return step + 2;
            case 0: return step;
            default: return -1;
        }
    }

}

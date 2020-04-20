package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Second {

    public static String repeat(String word, int times){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < times; j++) builder.append(word.charAt(i));
        }
        return builder.toString();
    }

    public static int differenceMaxMin(int[] array){
        int max = 0;
        int min = 0;
        for (int a : array) {
            if (a > max) max = a;
            if (a < min) min = a;
        }
        return max - min;
    }

    public static boolean isAvgWhole(int[] array){
        int sum = 0;
        for (int a : array) sum += a;
        return sum % array.length == 0;
    }

    public static int[] cumulativeSum(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }
        return array;
    }

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

    public static boolean isValid(String index){
        if (index.length() > 5) return false;
        Matcher matcher = Pattern.compile("[\\D]+").matcher(index);
        return !matcher.find();
    }

    public static boolean isStrangePair(String first, String second){
        return first.charAt(0) == second.charAt(second.length() - 1)
                && first.charAt(first.length() - 1) == second.charAt(0);
    }

    public static boolean isPrefix(String word, String prefix){
        if (prefix.charAt(prefix.length() - 1) == '-') prefix = prefix.substring(0, prefix.length() - 1);
        return prefix.equals(word.substring(0, prefix.length()));
    }

    public static boolean isSuffix(String word, String suffix){
        if (suffix.charAt(0) == '-') suffix = suffix.substring(1);
        return suffix.equals(word.substring(word.length() - suffix.length()));
    }

    public static int boxSeq(int step){
        switch(step % 2){
            case 1: return step + 2;
            case 0: return step;
            default: return -1;
        }
    }

}

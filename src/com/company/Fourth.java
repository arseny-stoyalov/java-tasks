package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents the fourth pack of tasks
 * number in brackets (in commentaries) is a task No
 *
 * @author Stoyalov Arseny BVT1803
 */
public final class Fourth {

    /**
     * Formats given text
     * (1)
     *
     * @param n number of words
     * @param k desired amount of chars in a line
     * @param essay text to format
     * @return formatted text
     */
    public static String formatEssay(int n, int k, String essay) {

        StringBuilder res = new StringBuilder();
        StringBuilder lineBuff = new StringBuilder();
        String[] words = essay.trim().split("[\\s]+");
        if (words.length != n)
            return "I don't help liars, enter the real amount of words in your essay";
        for (int i = 0; i < n; i++) {
            if (words[i].length() > k)
                return " You think you are so clever and original, huh?\n Well, I think I won't " +
                        "bother helping you until you stop entering words longer than the line capacity " +
                        "YOU'VE chosen.\n Anyone's trying to break their helper should be ashamed of themselves.";
            lineBuff.append(words[i]);
            if (lineBuff.length() > k) {
                if (res.length() > 0) res.deleteCharAt(res.length() - 1);
                res.append("\n");
                lineBuff.setLength(0);
                lineBuff.append(words[i]);
            }
            res.append(words[i]).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    /**
     * Unites brackets in given text into clusters
     * (2)
     *
     * @param parens text to proceed
     * @return array of clusters
     */
    public static String[] split(String parens) {

        List<String> list = new ArrayList<>();
        int cluster = 0;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < parens.length(); i++) {
            if (parens.charAt(i) == '(') cluster++;
            if (parens.charAt(i) == ')') cluster--;
            buffer.append(parens.charAt(i));
            if (cluster == 0) {
                list.add(buffer.toString());
                buffer.setLength(0);
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }

    /**
     * Makes snake_case word camelCase
     * (3)
     *
     * @param word in snake case
     * @return word in camel case
     */
    public static String toCamelCase(String word) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '_') {
                builder.append(word.toUpperCase().charAt(i + 1));
                i++;
            } else builder.append(word.charAt(i));
        }
        return builder.toString();
    }

    /**
     * Makes camelCase word snake_case
     * (3)
     * @param word in camel case
     * @return word in snake case
     */
    public static String toSnakeCase(String word) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)))
                builder.append("_").append(word.toLowerCase().charAt(i));
            else builder.append(word.charAt(i));
        }
        return builder.toString();
    }

    /**
     * Counts person's salary depending on
     * what time he/she's chosen to work i.e.
     * 9:00-17:00 means normal payment
     * other time means normal payment is
     * multiplied by overtime coefficient
     * (4)
     *
     * @param args array where
     *             0 - time when work started
     *             1 - time when work ended
     *             2 - payment
     *             3 - overtime coefficient
     * @return string amount of earning in dollars
     */
    public static String overTime(double... args) {

        if (args.length < 4) return null;

        double start, end, pay, k;
        start = args[0];
        end = args[1];
        pay = args[2];
        k = args[3];
        if (start >= end) end += 24;
        double usual, extra;
        usual = extra = 0;
        if (start < 9) extra += (Math.min(9, end) - start);
        if (end > 17) extra += (end - Math.max(17, start));
        if (end > 9 && start < 17) usual += (Math.min(17, end) - Math.max(9, start));

        double earned = (extra * k + usual) * pay;

        return String.format(Locale.US, "$%.2f", earned);
    }

    /**
     * Counts person's BMI
     * (5)
     * @param weight value
     * @param height value
     * @return BMI + diagnosis (overweight, normal, underweight)
     */
    public static String BMI(String weight, String height) {

        Pattern number = Pattern.compile("[0-9]+\\.?[0-9]*");
        Pattern metric = Pattern.compile("(pounds|kilos|inches|meters){1}");

        if (!number.matcher(weight).find() || !number.matcher(height).find())
            return "Could not find height/weight values";
        if (!metric.matcher(weight).find() || !metric.matcher(height).find())
            return "Incorrect metric system";

        double dWeight = 0;
        Matcher numW = number.matcher(weight);
        if (numW.find())
            dWeight = Double.parseDouble(numW.group());

        double dHeight = 0;
        Matcher numH = number.matcher(height);
        if (numH.find())
            dHeight = Double.parseDouble(numH.group());

        Matcher metricH = metric.matcher(height);
        if (metricH.find())
            if (metricH.group().equals("inches")) dHeight /= 39.37;
        Matcher metricW = metric.matcher(weight);
        if (metricW.find())
            if (metricW.group().equals("pounds")) dWeight /= 2.205;

        double bmi = dWeight / (dHeight * dHeight);
        bmi = (double) Math.round(bmi * 10) / 10;

        return bmi + " "
                + (bmi < 18.5 ? "Underweight" : bmi >= 25 ? "Overweight" : "Normal weight");
    }

    /**
     * Counts how many steps would it take to
     * make given number to a one digit number
     * where step means multiplying all digits
     * of number by each other
     * (6)
     * @param num to proceed
     * @return amount of steps
     */
    public static int bugger(int num) {

        int k = 0;
        while (num / 10 != 0) {
            String str = String.valueOf(num);
            int temp = 1;
            for (int i = 0; i < str.length(); i++) {
                temp *= Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            num = temp;
            k++;
        }
        return k;
    }

    /**
     * Replaces multiple character occurrences with
     * '*how many times occurred'
     * (7)
     * @param str string to proceed
     * @return changed string
     */
    public static String toStarShorthand(String str) {

        StringBuilder builder = new StringBuilder();
        int times = 1;
        builder.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                times++;
                if (i == str.length() - 1) builder.append("*").append(times);
            } else {
                if (times > 1) builder.append("*").append(times);
                builder.append(str.charAt(i));
                times = 1;
            }
        }
        return builder.toString();
    }

    /**
     * Checks if two strings rhyme i.e.
     * last words have identical vowels
     * (8)
     * @param first string
     * @param second string
     * @return true if rhymes
     */
    public static boolean doesRhyme(String first, String second) {

        String one = first.trim();
        String two = second.trim();
        if (!Character.isLetter(first.charAt(first.length() - 1)))
            one = first.trim().substring(0, first.length() - 2);
        if (!Character.isLetter(second.charAt(second.length() - 1)))
            two = second.trim().substring(0, second.length() - 2);
        one = one.substring(one.lastIndexOf(' ') + 1, one.length() - 1).toLowerCase();
        two = two.substring(two.lastIndexOf(' ') + 1, two.length() - 1).toLowerCase();
        StringBuilder vowelsOne = new StringBuilder();
        StringBuilder vowelsTwo = new StringBuilder();
        for (int i = 0; i < one.length(); i++) {
            switch (one.charAt(i)) {
                case 'a':
                case 'e':
                case 'u':
                case 'i':
                case 'o':
                    vowelsOne.append(one.charAt(i));
                    break;
            }
        }
        for (int i = 0; i < two.length(); i++) {
            switch (two.charAt(i)) {
                case 'a':
                case 'e':
                case 'u':
                case 'i':
                case 'o':
                    vowelsTwo.append(two.charAt(i));
                    break;
            }
        }
        return vowelsOne.toString().equals(vowelsTwo.toString());
    }

    /**
     * Returns true if the first number has 3 identical numbers in
     * row and the second number has 2 occurrences of the same
     * numbers in a row.
     * (9)
     * @param num1 first integer number
     * @param num2 second integer number
     * @return true if has
     */
    public static boolean trouble(long num1, long num2) {

        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        int times = 1;
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        char buff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == buff) {
                times++;
                if (times == 3) first.append(buff);
            } else {
                buff = str1.charAt(i);
                times = 1;
            }
        }
        times = 1;
        buff = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == buff) {
                times++;
                if (times == 2) second.append(buff);
            } else {
                buff = str2.charAt(i);
                times = 1;
            }
        }
        boolean res = false;
        char[] one = first.toString().toCharArray();
        char[] two = second.toString().toCharArray();
        Arrays.sort(two);
        for (int i = 0; i < one.length && !res; i++)
            if (Arrays.binarySearch(two, one[i]) != -1) res = true;

        return res;
    }

    /**
     * Counts the amount of unique chars between the two
     * occurrences of the given char
     * (10)
     * @param seq string to proceed
     * @param end char representing boundaries
     * @return amount of unique chars between boundaries
     */
    public static int countUniqueBooks(String seq, char end) {

        StringBuilder buff = new StringBuilder();
        StringBuilder books = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == end) {
                flag = !flag;
                if (!flag) books.append(buff);
            } else
            if (flag) buff.append(seq.charAt(i));
        }
        Set<Character> set = new HashSet<>();
        for (Character c : books.toString().toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

}

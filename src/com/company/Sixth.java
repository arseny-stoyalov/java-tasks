package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents the sixth pack of tasks
 * number in brackets (in commentaries) is a task No
 *
 * @author Stoyalov Arseny BVT1803
 */
public final class Sixth {

    /**
     * Finds Bell number at a given position
     * (1)
     *
     * @param n position
     */
    public static int bell(int n) {

        int[][] bell = new int[n + 1][];
        bell[0] = new int[1];
        bell[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            bell[i] = new int[i + 1];
            bell[i][0] = bell[i - 1][i - 1];
            for (int j = 1; j <= i; j++)
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
        }
        return bell[n][0];
    }

    private final static List<Character> vowels = List.of('a', 'o', 'i', 'e', 'u', 'A', 'O', 'I', 'E', 'U');

    /**
     * Translates English word to pig latin
     * (2)
     */
    public static String translateWord(String word) {

        if (word.length() < 1) return word;
        int[] vowelArray = word.chars().filter(c -> vowels.contains((char) c)).toArray();
        if (vowelArray.length == 0) return word.charAt(0) + word.substring(1).toLowerCase() + "ay";

        char first = Character.isUpperCase(word.charAt(0))
                ? Character.toUpperCase((char) vowelArray[0]) : (char) vowelArray[0];
        if (vowels.contains(word.charAt(0)))
            word = first + word.substring(1).toLowerCase() + "yay";
        else
            word = first + word.substring(word.indexOf(vowelArray[0]) + 1).toLowerCase()
                    + word.substring(0, word.indexOf(vowelArray[0])).toLowerCase() + "ay";
        return word;
    }

    /**
     * Translates English sentence to pig latin
     * (2)
     */
    public static String translateSentence(String sentence) {

        Matcher matcher = Pattern.compile("\\w+").matcher(sentence);
        return matcher.replaceAll(match -> translateWord(match.group()));
    }

    /**
     * Checks if given string may represent
     * rgb or rgba code
     * (3)
     */
    public static boolean validColor(String code) {

        String colorCode = "(1?\\d{1,2}|2[0-4]\\d|25[0-5])";
        String transparency = "([0-1]|(\\.\\d*)|[0-1](\\.\\d*))";
        Matcher rgb = Pattern.compile("rgb\\(" +
                "(" + colorCode + ",){2}" + colorCode +
                "\\)").matcher(code);
        Matcher rgba = Pattern.compile("rgba\\(" +
                "(" + colorCode + ",){3}" + transparency +
                "\\)").matcher(code);
        return rgb.matches() || rgba.matches();
    }

    /**
     * Takes string representing a URL,
     * deletes all repetitive parameters
     * and all parameters listed
     * (4)
     *
     * @param str      URL
     * @param toRemove array of parameters
     *                 names to be removed
     *                 from URL
     */
    public static String stripUrlParams(String str, String... toRemove) {

        String[] url = str.split("\\?");
        StringBuilder builder = new StringBuilder(url[0] + "?");
        String[] query = url[1].split("&");
        Map<String, String> map = new HashMap<>(query.length);
        for (String p : query) {
            String[] param = p.split("=");
            map.put(param[0], param[1]);
        }
        for (String param : toRemove)
            map.remove(param);
        for (String key : map.keySet()) {
            builder.append(key).append("=").append(map.get(key)).append("&");
        }
        return builder.subSequence(0, builder.length() - 1).toString();
    }

    /**
     * Finds three longest words in an article
     * and returns them as an array of hashtags
     * (5)
     *
     * @param article String value of an article
     */
    public static String[] getHashTags(String article) {

        String[] words = article.split(" ");
        String[] longest = new String[3];
        longest[0] = "";
        longest[1] = "";
        longest[2] = "";
        for (String word : words) {
            word = word.replaceAll("\\W", "");
            if (word.length() > longest[0].length()) {
                longest[2] = longest[1];
                longest[1] = longest[0];
                longest[0] = word;
            } else if (word.length() > longest[1].length()) {
                longest[2] = longest[1];
                longest[1] = word;
            } else if (word.length() > longest[2].length())
                longest[2] = word;
        }
        String[] hashtags = new String[words.length];
        for (int i = 0; i < hashtags.length; i++)
            hashtags[i] = "#" + longest[i].toLowerCase();
        return hashtags;
    }

    /**
     * Returns Ulam number at a given position
     * (6)
     *
     * @param n position
     */
    public static int ulam(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        int i = 3;
        while (list.size() < n) {

            int count = 0;
            for (int j = 0; j < list.size() - 1; j++) {

                for (int k = j + 1; k < list.size(); k++) {
                    if (list.get(j) + list.get(k) == i)
                        count++;
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1)
                list.add(i);
            i++;
        }
        return list.get(n - 1);
    }

    /**
     * Returns first longest sequence of
     * unique characters in a string
     * (7)
     *
     * @return longest substring with
     * no duplicating characters
     */
    public static String longestNonrepeatingSubstring(String str) {

        Set<Character> set = new HashSet<>();
        int buffStart = 0;
        char[] chars = new char[str.length()];
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
            if (!set.add(str.charAt(i))) {
                if (i - 1 - buffStart > end - start) {
                    start = buffStart;
                    end = i - 1;
                }
                buffStart = i;
                set = new HashSet<>();
                set.add(str.charAt(i));
            }
        }
        if (end == 0) end = chars.length - 1;

        return new String(chars, start, end - start + 1);
    }

    /**
     * Converts Arabic number (1 to 3999)
     * to a Roman equivalent
     * (8)
     *
     * @return String value of Roman number
     */
    public static String convertToRoman(int num) {

        if (num > 3999 || num < 1) return null;
        StringBuilder builder = new StringBuilder();
        Map<Integer, String> map = new HashMap<>(7);
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        int digit = 1;
        while (num / digit != 0) {
            int n = num % (digit * 10);
            n /= digit;
            if (n > 0 && n < 4)
                builder.append(map.get(digit).repeat(n));
            if (n == 4)
                builder.append(map.get(digit * 5)).append(map.get(digit));
            if (n > 4 && n < 9)
                builder.append(map.get(digit).repeat(n % 5)).append(map.get(digit * 5));
            if (n == 9)
                builder.append(map.get(digit * 10)).append(map.get(digit));

            digit *= 10;
        }
        return builder.reverse().toString();
    }

    /**
     * Checks if string value of
     * an equation is correct
     * (9)
     */
    public static boolean formula(String f) {

        String[] parts = f.split("=");
        int[] res = new int[parts.length];

        for (int k = 0; k < parts.length; k++) {

            String[] sum = parts[k].trim().replaceAll("-", "+-").split("\\+");
            int[] terms = new int[sum.length];
            for (int j = 0; j < sum.length; j++) {
                String[] operands = sum[j].trim().replaceAll("-\\s*", "-")
                        .replaceAll("\\s{2}", " ").split(" ");
                Integer[] term = new Integer[operands.length];
                for (int i = 1; i < operands.length - 1; i++) {
                    if (operands[i].equals("*") || operands[i].equals("/")) {
                        int first = 0;
                        int second = 0;
                        try {
                            first = term[i - 1] == null ? Integer.parseInt(operands[i - 1]) : term[i - 1];
                            second = Integer.parseInt(operands[i + 1]);
                        } catch (NumberFormatException e) {
                            return false;
                        }
                        term[i + 1] = operands[i].equals("*") ? first * second : first / second;
                    }
                }
                if (term.length == 1) {
                    try {
                        term[0] = Integer.parseInt(operands[0]);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }
                terms[j] = term[term.length - 1];
            }
            res[k] = Arrays.stream(terms).reduce(0, Integer::sum);
        }

        for (int i = 1; i < res.length; i++)
            if (res[i] != res[0]) return false;

        return true;
    }

    /**
     * Checks if number or any of its
     * descedants are palindromes
     * (10)
     */
    public static boolean palindromedescendant(long num) {

        String strNum = String.valueOf(num);
        if (strNum.length() == 1) return true;
        StringBuilder builder = new StringBuilder(strNum);

        while (strNum.length() > 1) {
            if (builder.toString().equals(builder.reverse().toString())) return true;
            strNum = builder.toString();
            builder.setLength(0);
            for (int i = 0; i < strNum.length() - 1; i += 2) {
                int first = Character.getNumericValue(strNum.charAt(i));
                int second = Character.getNumericValue(strNum.charAt(i + 1));
                builder.append(first + second);
            }
        }

        return false;
    }

}

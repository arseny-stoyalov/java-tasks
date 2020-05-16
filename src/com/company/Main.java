package com.company;

import java.util.Arrays;

import static com.company.Sixth.*;

/**
 * This project was made by BVT1803 student
 *
 * @author Stoyalov Arseny
 * This class is used for testing needs
 * while all the tasks are made within
 * separated classes (there is a class for each task).
 * All the methods are static, so that they could
 * be invoked with no instance of the class
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(bell(3));
        System.out.println(translateWord("Do"));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.println(validColor("rgba(0,0,0,1.5)"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", "c"));
        System.out.println(Arrays.toString(getHashTags("Visualizing Science")));
        System.out.println(ulam(206));
        System.out.println(longestNonrepeatingSubstring("abcd"));
        System.out.println(convertToRoman(3999));
        System.out.println(formula("16 * 10 = 160 = 40 + 120"));
        System.out.println(palindromedescendant(1));
    }

}

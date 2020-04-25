package com.company;

import java.util.Arrays;

import static com.company.Fourth.*;

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
        System.out.println(Arrays.toString(split("((()))(())()()(()())")));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(overTime(9, 17, 30, 1.5));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(bugger(4));
        System.out.println(toStarShorthand("abc"));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));

    }

}

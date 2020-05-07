package com.company;

import java.util.Arrays;

import static com.company.Fifth.*;

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
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[]{ 72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println(canMove("Queen", "C4", "D6"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println(Arrays.toString(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"})));
        System.out.println(validateCard(1234567890123452L));
        System.out.println(numToEng(5));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(1));
    }

}

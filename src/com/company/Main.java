package com.company;

/**
 * This project was made by BVT1803 student
 * @author Stoyalov Arseny
 * This class is used for testing needs
 * while all the tasks are made within
 * separated classes (there is a class for each task).
 * All the methods are static, so that they could
 * be invoked with no instance of the class
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Third.findZip("all zip files are compressed"));
        System.out.println(Third.isValidHexCode("#CD5C58C"));
        System.out.println(Third.same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
        System.out.println(Third.isKaprekar(297));
        System.out.println(Third.longestZero("11111"));
        System.out.println(Third.nextPrime(11));
        System.out.println(Third.rightTriangle(70, 130, 100));
    }

}

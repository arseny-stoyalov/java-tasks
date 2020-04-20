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
        System.out.println(Second.repeat("henlo", 2));
        System.out.println(Second.Fibonacci(7));
        System.out.println(Second.isValid("7322"));
        System.out.println(Second.boxSeq(3));
    }

}

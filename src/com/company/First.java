package com.company;

/**
 * This class represents the first pack of tasks
 * number in brackets (in commentaries) is a task No
 * @author Stoyalov Arseny BVT1803
 */
public final class First {

    /**
     * Returns remainder of the division
     * (1)
     * @param a first num
     * @param b second num
     * @return remainder
     */
    public static int remainder(int a, int b) {
        return a % b;
    }

    /**
     * Calculates area of a triangle
     * (2)
     * @param a triangle's side
     * @param h triangle's height
     * @return area
     */
    public static double triArea(double a, double h) {
        return a * h / 2;
    }

    /**
     * Counts all legs in herd
     * (3)
     * @param chick has 2 legs
     * @param cow has 4 legs
     * @param pig has 4 legs
     * @return amount of legs
     */
    public static int animals(int chick, int cow, int pig) {
        return chick * 2 + cow * 4 + pig * 4;
    }

    /**
     * Checks if game is profitable
     * (4)
     * @param prob probability of winning
     * @param prize amount of prize money
     * @param pay how much money is required
     * @return true if profitable
     */
    public static boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay;
    }

    /**
     * Find out what operation needs to be
     * applied so that first two params make
     * the third
     * (5)
     * @param a of int
     * @param b of int
     * @param n of int
     * @return String name of operation
     */
    public static String operation(int a, int b, int n) {
        if (a + b == n) return "added";
        if (a - b == n) return "subtracted";
        if (a * b == n) return "multiplied";
        if (a / b == n && a % b == 0) return "divided";
        return "none";
    }

    /**
     * Returns ASCII code of given symbol
     * (6)
     * @param sym of char
     * @return int code
     */
    public static int ctoa(char sym) {
        return sym;
    }

    /**
     * Takes a row of numbers, then picks last one
     * and counts the sum of all numbers from 0 to
     * the number picked
     * (6)
     * @param nums row of int
     * @return sum
     */
    public static int addUpTo(int... nums) {
        if (nums.length == 0) return -1;
        int last = nums[nums.length - 1];
        int res = 0;
        for (int i = 1; i <= last; i++) res += i;
        return res;
    }

    /**
     * The max length of third triangle edge
     * (8)
     * @param a first edge
     * @param b second edge
     * @return third edge
     */
    public static int nextEdge(int a, int b){
        return a + b - 1;
    }

    /**
     * Makes so that every element of array is
     * replaced with its value powered by 3
     * (9)
     * @param array to proceed
     * @return proceeded array
     */
    public static int sumOfCubes(int[] array){
        if (array == null || array.length == 0) return 0;
        int res = 0;
        for (int e : array) res += Math.pow(e, 3);
        return res;
    }

    /**
     * Add first arg to itself times second argument,
     * then checks if the result can be divided by third
     * arg
     * (10)
     * @param a first
     * @param b second
     * @param c third
     * @return true if the result of division is integer
     */
    public static boolean abcmath(int a, int b, int c){
        for (int i = 0; i < b; i++) {
            a = a + a;
        }
        return a % c == 0;
    }

}

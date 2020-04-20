package com.company;

public final class First {

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static double triArea(double a, double h) {
        return a * h / 2;
    }

    public static int animals(int chick, int cow, int pig) {
        return chick * 2 + cow * 4 + pig * 4;
    }

    public static boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay;
    }

    public static String operation(int a, int b, int n) {
        if (a + b == n) return "added";
        if (a - b == n) return "subtracted";
        if (a * b == n) return "multiplied";
        if (a / b == n && a % b == 0) return "divided";
        return "none";
    }

    public static int ctoa(char sym) {
        return sym;
    }

    public static int addUpTo(int... nums) {
        int last = nums[nums.length - 1];
        int res = 0;
        for (int i = 1; i <= last; i++) res += i;
        return res;
    }

    public static int nextEdge(int a, int b){
        return a + b - 1;
    }

    public static int sumOfCubes(int[] array){
        if (array == null) return 0;
        int res = 0;
        for (int e : array) res += Math.pow(e, 3);
        return res;
    }

    public static boolean abcmath(int a, int b, int c){
        for (int i = 0; i < b; i++) {
            a = a + a;
        }
        return a % c == 0;
    }

}

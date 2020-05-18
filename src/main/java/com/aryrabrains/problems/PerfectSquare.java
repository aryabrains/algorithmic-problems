package com.aryrabrains.problems;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        return checkPerfectSquare(num, 0, num-1);
    }

    private boolean checkPerfectSquare(int num, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midSq = 0;
            try {
                midSq = Math.multiplyExact(mid, mid);
            } catch (ArithmeticException ex) {
                return checkPerfectSquare(num, low, mid - 1);
            }
            if (midSq == num) return true;
            if (midSq > num) return checkPerfectSquare(num, low, mid - 1);
            if (midSq < num) return checkPerfectSquare(num, mid + 1, high);
        }
        return false;
    }

    public static void main(String[] args) {
        PerfectSquare ps = new PerfectSquare();
        System.out.println(ps.isPerfectSquare(2147395600));
    }
}

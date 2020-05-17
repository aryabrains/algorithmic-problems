package com.aryrabrains.problems;

/**
 * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
 */
public class NumberCompliment {

    public int findComplement(int num) {
        int maskingNumber = (1 << getNumberOfBits(num)) - 1;
        return num ^ maskingNumber;
    }

    private int getNumberOfBits(int num) {
        int count = 1;
        while(num != 1) {
            num = num/2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberCompliment numberCompliment = new NumberCompliment();
        System.out.println(numberCompliment.findComplement(5));
    }
}

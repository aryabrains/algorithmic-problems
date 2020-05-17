package com.aryrabrains.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChangeProblem {

    public static int countCoins(int[] arr, int sum, int size, int[][] d) {
        if(sum == 0)
            return 1;
        if(sum < 0)
            return 0;
        if(size <= 0 && sum > 0)
            return 0;

        if(d[sum][size] != -1) return d[sum][size];
        d[sum - arr[size-1]][size] = countCoins(arr, sum - arr[size-1], size, d);
        d[sum][size-1] = countCoins(arr, sum, size-1, d);
        return d[sum - arr[size-1]][size] + d[sum][size-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int d[][] = new int[6][arr.length+1];
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < arr.length + 1; j++) {
                d[i][j] = -1;
            }
        }
        System.out.println(countCoins(arr, 5, arr.length, d));
    }
}

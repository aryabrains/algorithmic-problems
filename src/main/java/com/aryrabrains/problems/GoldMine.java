package com.aryrabrains.problems;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
 * Initially the miner is at first column but can be at any row.
 * He can move only (right->,right up /,right down\) that is from a given cell,
 * the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right.
 * Find out maximum amount of gold he can collect.
 *
 * Asked in: [Flipkart, Amazon]
 */
public class GoldMine {

    public static int getMaxGold(int[][] mat) {
        int maxSum = 0;
        int dp[][] = new int[mat.length][mat[0].length];
        for(int i=0; i < dp.length; i++) {
            for(int j=0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i=0; i< mat.length; i++) {
            int sum = getMaxGoldUtil(mat, dp, i,0);
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
    private static int getMaxGoldUtil(int[][] mat, int[][] dp, int i, int j) {
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length){
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] =  mat[i][j] + Math.max(getMaxGoldUtil(mat, dp,i-1, j+1),
                Math.max(getMaxGoldUtil(mat, dp,i, j+1), getMaxGoldUtil(mat, dp,i+1, j+1)));
        return dp[i][j];
    }

    public static void main(String[] args) {
        int mat[][] = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
        System.out.println(getMaxGold(mat));
    }

}

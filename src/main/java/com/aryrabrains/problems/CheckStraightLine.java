package com.aryrabrains.problems;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 */
public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        float slope = getSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        for(int i=2; i < coordinates.length; i++) {
            float newSlope = getSlope(coordinates[i-1][0], coordinates[i-1][1], coordinates[i][0], coordinates[i][1]);
            if(slope != newSlope)
                return false;
        }
        return true;
    }

    private float getSlope(int x1, int y1, int x2, int y2) {
        int x = x2-x1;
        if(x == 0) return 0;
        int y = y2-y1;
        if(y == 0) return -1;
        return (float) y / x ;
    }

    public static void main(String[] args) {
        CheckStraightLine csl = new CheckStraightLine();
        int[][] coordinates = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {6,7}
        };
        System.out.println(csl.checkStraightLine(coordinates));
    }
}

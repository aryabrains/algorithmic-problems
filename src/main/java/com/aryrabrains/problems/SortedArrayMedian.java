package com.aryrabrains.problems;


import com.aryrabrains.problems.exception.NotFoundException;
import org.apache.commons.lang.ArrayUtils;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays
 */
public class SortedArrayMedian {

    /**
     * Solution1:
     *  Merge the given sorted array and then return the median element.
     * TimeComplexity:
     *  O(n+m)
     */
    public static double solution1(int[] num1, int[] num2) {
        if(ArrayUtils.isEmpty(num1) && ArrayUtils.isEmpty(num2)) {
            throw new NotFoundException("Both arrays are empty. No median found.");
        }
        if(ArrayUtils.isEmpty(num1)) {
            if(num1.length % 2 == 0) {
                return (num1[num1.length/2] + num1[num1.length/2 + 1])/2;
            } else {
                return num1[num1.length/2];
            }
        }
        if(ArrayUtils.isEmpty(num2)) {
            if(num2.length % 2 == 0) {
                return (num2[num2.length/2] + num1[num2.length/2 + 1])/2;
            } else {
                return num2[num2.length/2];
            }
        }

        int l1 = num1.length, l2 = num2.length, i = 0, j = 0;
        int medianIndex = (l1 + l2)/2;
        boolean isOdd = (l1 + l2)%2 != 0;
        int[] mergedArray = new int[l1+l2];
        int count = 0;
        while(i < l1 && j < l2) {
            if(num1[i] < num2[j]) {
                mergedArray[count++] = num1[i++];
            } else  {
                mergedArray[count++] = num2[j++];
            }
        }
        while(i < l1) {
            mergedArray[count++] = num1[i++];
        }

        while (j < l2) {
            mergedArray[count++] = num2[j++];
        }

        if(isOdd) {
            return mergedArray[medianIndex];
        } else {
            return (double) (mergedArray[medianIndex] + mergedArray[medianIndex-1])/2;
        }

    }


    /**
     * Optimized O(log(min(n,m)) if n is length 0f num1 array and m is length of num2 array.
     * Algorithm:
     *  Modification of binary search. We need to find a partition in num1 and num2 such that:
     *      1. All elements in left of num1 and num2 is less than all elements in right partition of num1 and num2
     *      2. Since these are sorted arrays we can check 4 elements for checking this.
     *          2a. maxLeftX, maxRightX, minRightX and minRightY.
     *          2b. if maxLeftX <= minRightY and maxRightY < minRightY this means all elements in left are equal to all elements in right partition.
     */
    public static double solution2(int[] n1, int[] n2) {
        //Do binary search in smaller array
        if(n1.length > n2.length)
            return solution2(n2, n1);

        int x = n1.length;
        int y = n2.length;

        int low = 0;
        int high = x;
        while(low <= high) {
            int partX = (low+high) / 2;
            int partY = ((x+y+1)/2) - partX;

            int maxLeftX = partX == 0 ? Integer.MIN_VALUE : n1[partX-1];
            int minRightX = partX == x ? Integer.MAX_VALUE: n1[partX];

            int maxLeftY = partY == 0 ? Integer.MIN_VALUE: n2[partY-1];
            int minRightY = partY == y ? Integer.MAX_VALUE: n2[partY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //Found the correct partition
                if((x+y) % 2 == 0) {
                    //even
                    return  (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    //odd
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partX -1;
            } else{
                low = partX + 1;
            }
        }
        //if arrays are not sorted we will come here
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        int[] num1 = {1,3,5,7};
        int[] num2 = {2,4,6,8,9};
        System.out.println(solution2(num1, num2));
    }


}

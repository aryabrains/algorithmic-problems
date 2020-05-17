package com.aryrabrains.problems;

import com.aryrabrains.problems.util.ArrayUtil;

import java.util.Arrays;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        int[] storage = new int[26];
        Arrays.fill(storage, -1);
        for(int i=0; i<s.length(); i++) {
            if(storage[s.charAt(i) - 'a'] != -1) {
                storage[s.charAt(i) - 'a'] = Integer.MAX_VALUE;
            } else {
                storage[s.charAt(i) - 'a'] = i;
            }
        }

        ArrayUtil.printArray(storage);
        int index = Integer.MAX_VALUE;
        for(int i=0; i < storage.length; i++) {
            if(storage[i] < index && storage[i] != -1) {
                index = storage[i];
            }
        }

        if(index == Integer.MAX_VALUE)
            return -1;
        return index;
    }


    public static void main(String[] args) {
        FirstUniqueCharacter sol = new FirstUniqueCharacter();
        System.out.println(sol.firstUniqChar("leetcode"));
    }
}

package com.aryrabrains.problems.util;

public class TreeUtil {

    public TreeNode createTreeFromArray(int[] arr, TreeNode root, int i) {
        if(i < arr.length) {
            TreeNode temp = new TreeNode();
            temp.val = arr[i];
            temp.left = null;
            temp.right = null;
            root = temp;

            root.left = createTreeFromArray(arr, root.left, 2*i+1);
            root.right = createTreeFromArray(arr, root.right, 2*i+2);
        }
        return root;
    }
}

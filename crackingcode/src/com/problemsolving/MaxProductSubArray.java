package com.problemsolving;

import java.util.Arrays;

/**
 * Given an array that contains both positive and negative integers, the task is to find the product of the maximum
 * product sub-array.
 * Examples:
 * Input: arr[] = {6, -3, -10, 0, 2}
 * Output:  180
 * Explanation: The sub-array is {6, -3, -10}
 * Input: arr[] = {-1, -3, -10, 0, 60}
 * Output:   60
 * Explanation: The sub-array is {60}*
 */

public class MaxProductSubArray {

    /**
     * find the sub-array with max product in an input array
     *
     * @param arr input integer array
     * @return sub array with max product
     */
    public int[] getMaxProductSubArrays(int[] arr) {
        int maxProduct = arr[0];
        int startIndex = 0;
        int endIndex = 0;
        int i, j = 0;
        for (i = 0; i < arr.length; ++i) {
            int product = arr[i];
            if (product > maxProduct) {
                startIndex = i;
                endIndex = j;
                maxProduct = product;
            }
            for (j = i + 1; j < arr.length; ++j) {
                product *= arr[j];
                if (product == 0) break;
                if (product > maxProduct) {
                    startIndex = i;
                    endIndex = j;
                    maxProduct = product;
                }
            }
        }
        return Arrays.copyOfRange(arr, startIndex, endIndex + 1);
    }

    /**
     * calculate the max product of a sub-array
     *
     * @param arr input integer array
     * @return max Product
     */
    public int getMaxProductSubArrayApproach1(int[] arr) {
        int maxProduct = arr[0];
        int i, j;
        for (i = 0; i < arr.length; ++i) {
            int product = arr[i];
            if (product > maxProduct) {
                maxProduct = product;
            }
            for (j = i + 1; j < arr.length; ++j) {
                product *= arr[j];
                if (product == 0) break;
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    public int getMaxProductSubArrayApproach2(int[] arr) {
        int pre = 1;
        int suf = 1;
        int ans = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
            pre = pre * arr[i];
            suf = suf * arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suf));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {-7, 0, 9, 12, -9, -33};
        MaxProductSubArray m = new MaxProductSubArray();
        int result = m.getMaxProductSubArrayApproach1(input);
        System.out.print(result);

        result = m.getMaxProductSubArrayApproach2(input);
        System.out.print(result);
    }
}

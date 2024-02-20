package com.problemsolving;

import java.util.Arrays;

public class MaxProductSubArray {
    /**
     * Given an array that contains both positive and negative integers, the task is to find the product of the maximum
     * product subarray.
     * Examples:
     * Input: arr[] = {6, -3, -10, 0, 2}
     * Output:  180
     * Explanation: The subarray is {6, -3, -10}
     * Input: arr[] = {-1, -3, -10, 0, 60}
     * Output:   60
     * Explanation: The subarray is {60}*
     */


    /**
     * find the sub-array with max product in an input array
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
     * calculate the max product of an sub-array
     * @param arr input integer array
     * @return max Product
     */
    public int getMaxProductSubArray(int[] arr) {
        int maxProduct = arr[0];
        int i, j = 0;
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

    public static void main(String[] args) {
        int[] input = {-7, 0, 9, 12, -9, -33};
        MaxProductSubArray m = new MaxProductSubArray();
        int result = m.getMaxProductSubArray(input);
        System.out.print(result);
    }
}

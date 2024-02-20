package com.problemsolving;

/**
 * Given an array of N integers, and an integer K, the task is to find the number of pairs of integers
 * in the array whose sum is equal to K.
 * Examples:
 * Input: arr[] = {1, 5, 7, -1}, K = 6
 * Output:  2
 * Explanation: Pairs with sum 6 are (1, 5) and (7, -1).
 * Input: arr[] = {1, 5, 7, -1, 5}, K = 6
 * Output:  3
 * Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).
 * Input: arr[] = {1, 1, 1, 1}, K = 2
 * Output:  6
 * Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
 * Input: arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, K = 11
 * Output:  9
 * Explanation: Pairs with sum 11 are (10, 1), (10, 1), (10, 1), (12, -1), (10, 1), (10, 1), (10, 1),(7,4),(6,5).
 */

public class IntegerPairForSum {

    /**
     * No limit to repeating pairs so O(N^2)
     *
     * @param input array of integers
     * @param sum   for the pairs
     * @return number of pairs with sum
     */
    public int getNumPairsForSum(int[] input, int sum) {
        int len = input.length;
        int numPairs = 0;
        boolean[] hit = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (input[i] + input[j] == sum) {
                    numPairs++;
                }
            }
        }
        return numPairs;
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 7, -1, 5};
        int sum = 6;
        IntegerPairForSum s = new IntegerPairForSum();
        System.out.println(s.getNumPairsForSum(input, sum));
    }
}

package com.problemsolving;

import java.util.Arrays;

/**
 * Partially completed
 * Need to improve the logic
 */
public class MergeOverlappingIntervals {
    public int[][] mergeOverlappingIntervals(int[][] input, int start, int end) {

        if (start == end) {
            System.out.print(input[0][0]);
            System.out.print(",");
            System.out.println(input[0][1]);
            return input;
        }
        //[L1,R1] overlapping [L2,R2] iff
        //L1<=L2 and L2<=R1
        if (end - start == 1) {
            int[][] res = new int[2][2];
            if ((input[0][0] <= input[1][0]) && (input[1][0] <= input[0][1])) {

                System.out.print(input[0][0]);
                System.out.print(",");
                System.out.println(input[1][1]);
                return new int[][]{new int[]{input[0][0], input[1][1]}};
            }
            if ((input[1][0] <= input[0][0]) && (input[0][0] <= input[1][1])) {

                System.out.print(input[1][0]);
                System.out.print(",");
                System.out.println(input[0][1]);
                return new int[][]{new int[]{input[1][0], input[0][1]}};
            }
        } else {
            int[][] input1 = mergeOverlappingIntervals(input, start, (start + end) / 2);
            System.out.println("input1 len=" + input1.length);
            int[][] input2 = mergeOverlappingIntervals(input, (start + end) / 2 + 1, end);
            System.out.println("input2 len=" + input2.length);
        }
        return input;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 5}, {4, 9}};

        MergeOverlappingIntervals m = new MergeOverlappingIntervals();
        arr = m.mergeOverlappingIntervals(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

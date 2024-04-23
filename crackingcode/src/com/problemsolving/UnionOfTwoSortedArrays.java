package com.problemsolving;

import java.util.*;

public class UnionOfTwoSortedArrays {

    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = start + 1;

        while (end < nums.length - 1) {
            if (nums[start] == nums[end]) {
                nums[end] = nums[end + 1];
                start++;
                end++;
            } else {
                start++;
                end++;
            }
        }
        return end;
    }

    public List<Integer> mergeSortedArrays(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;

        int aLen = removeDuplicates(a);
        int bLen = removeDuplicates(b);
        while ((pointerA < aLen - 1) || (pointerB < bLen - 1)) {
            if (a[pointerA] == b[pointerB]) {
                result.add(a[pointerA]);
                pointerA++;
                pointerB++;

            } else if (a[pointerA] < b[pointerB]) {
                result.add(a[pointerA]);
                pointerA++;
            } else if (a[pointerB] < b[pointerA]) {
                result.add(b[pointerB]);
                pointerB++;
            }
        }

        if (a[pointerA] < b[pointerB]) {
            result.add(a[pointerA]);
            result.add(b[pointerB]);
        } else if (a[pointerA] > b[pointerB]) {
            result.add(b[pointerB]);
            result.add(a[pointerA]);
        } else {
            result.add(a[pointerA]);
        }
        pointerA++;
        pointerB++;

        while (pointerA < aLen) {
            result.add(a[pointerA]);
            pointerA++;
        }

        while (pointerB < bLen) {
            result.add(b[pointerB]);
            pointerB++;
        }
        return result;
    }

    public static void main(String[] args) {

        UnionOfTwoSortedArrays mswp = new UnionOfTwoSortedArrays();
        List<Integer> res = mswp.mergeSortedArrays(new int[]{1, 2, 2, 3, 4, 6}, new int[]{2, 3, 5});

        /**
         * 1 2 3 4 6
         * 2 3 5
         *
         * 1 2 3 4 5 6
         */
        System.out.println(res);
    }
}

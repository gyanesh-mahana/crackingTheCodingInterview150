package com.problemsolving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NearestPalindromeNumber {

    /**
     *
     * @param num
     * @return
     */
    public boolean isPalindromeNumber(int num) {
        String number = String.valueOf(num);
        for (int i = 0, j = number.length() - 1; i < number.length() / 2; i++, j--) {
            if (number.charAt(i) != number.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param num
     * @return
     */
    public boolean isPalindromeNumberV2(int num) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int number = num;
        while(number>0){
            linkedList.add(number%10);
            number = number/10;
        }
        number = 0;
        while(!linkedList.isEmpty()){
            number = (linkedList.pop()+number)*10;
        }
        return number/10==num;
    }

    /**
     * 
     * @param num
     * @return
     */
    public int getNearestPalindrome(int num) {
        int nearestPalindromeNumber = num;
        int nextNum = num;
        int prevNum = num;
        if (isPalindromeNumberV2(num)) {
            return nearestPalindromeNumber;
        }
        while (true) {
            nextNum++;
            prevNum--;
            if (isPalindromeNumberV2(nextNum)) {
                nearestPalindromeNumber = nextNum;
                break;
            }
            if (isPalindromeNumberV2(prevNum)) {
                nearestPalindromeNumber = prevNum;
                break;
            }
        }

        return nearestPalindromeNumber;
    }

    public static void main(String[] args) {

        NearestPalindromeNumber n = new NearestPalindromeNumber();
        System.out.println(n.getNearestPalindrome(117));
    }
}

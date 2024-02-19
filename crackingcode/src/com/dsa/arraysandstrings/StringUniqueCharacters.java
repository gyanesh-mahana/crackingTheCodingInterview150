package com.dsa.arraysandstrings;

import java.util.HashMap;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * can not use additional data structures?
 */
public class StringUniqueCharacters {

    /**
     * First Approach
     *
     * @param inputString String to find unique characters
     * @return hasUniChar
     */
    public boolean hasUniqueCharsApproach1(String inputString) {
        boolean hasUniChar = true;
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : inputString.toCharArray()) {
            if (!charMap.containsKey(ch)) {
                charMap.put(ch, 1);
            } else {
                hasUniChar = false;
                break;
            }
        }
        return hasUniChar;
    }

    /**
     * Approach 2 where check for the repetition of the char second time
     *
     * @param inputString for finding the unique characters
     * @return hasUniChars
     */
    public boolean hasUniqueCharsApproach2(String inputString) {
        boolean hasUniChars = true;
        for (Character ch : inputString.toCharArray()) {
            int index1 = inputString.indexOf(ch);
            int index2 = inputString.indexOf(ch, index1 + 1, inputString.length());
            if (index1 < index2) {
                hasUniChars = false;
                break;
            }
        }
        return hasUniChars;
    }

    /**
     * Approach 3 where char set is assumed as ASCII
     *
     * @param inputString String to find the unique chars
     * @return true if unique else false
     */
    public boolean hasUniqueCharsApproach3(String inputString) {
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < inputString.length(); i++) {
            int asciiVal = inputString.charAt(i);
            if (charSet[asciiVal]) return false;
            charSet[asciiVal] = true;
        }
        return true;
    }

    /**
     * Approach4 using bit manipulation
     *
     * @param inputString to find unique chars assuming all the letters are small case
     * @return true if unique chars else false
     */
    public boolean hasUniqueCharsApproach4(String inputString) {
        int checker = 0;
        for (int i = 0; i < inputString.length(); i++) {
            int diffVal = inputString.charAt(i) - 'a';
            if ((checker & (1 << diffVal)) > 0) return false;
            checker |= (1 << diffVal);
        }
        return true;
    }

    public static void main(String[] args) {

        StringUniqueCharacters s = new StringUniqueCharacters();
//        if (s.hasUniqueCharsApproach1("kanha")) {
//            System.out.print("Unique Characters Found");
//        } else {
//            System.out.print("Unique Characters Not Found");
//
//        }
//        if (s.hasUniqueCharsApproach2("aman")) {
//            System.out.print("Unique Characters Found");
//        } else {
//            System.out.print("Unique Characters Not Found");
//
//        }
//        if (s.hasUniqueCharsApproach3("gyanesh")) {
//            System.out.print("Unique Characters Found");
//        } else {
//            System.out.print("Unique Characters Not Found");
//
//        }
        if (s.hasUniqueCharsApproach4("aba")) {
            System.out.print("Unique Characters Found");
        } else {
            System.out.print("Unique Characters Not Found");

        }
    }
}

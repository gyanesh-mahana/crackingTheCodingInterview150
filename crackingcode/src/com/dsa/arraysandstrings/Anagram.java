package com.dsa.arraysandstrings;

import java.util.*;

/**
 * Write a method to decide if two strings are anagrams or not.
 */
public class Anagram {

    /**
     * Approach 1 - Using 2 hashMaps to store the characters and their frequecies
     * and match them to get if they are anagram or not
     *
     * @param input1 first string
     * @param input2 second string
     * @return true if anagram else false
     */
    public boolean isAnagramApproach1(String input1, String input2) {
        if (input1.length() != input2.length()) return false;
        int len = input2.length();
        HashMap<Character, Integer> charMap1 = new HashMap<>();
        HashMap<Character, Integer> charMap2 = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (!charMap1.containsKey(input1.charAt(i))) {
                charMap1.put(input1.charAt(i), 1);
            } else {
                charMap1.put(input1.charAt(i), charMap1.get(input1.charAt(i)) + 1);
            }

            if (!charMap2.containsKey(input2.charAt(i))) {
                charMap2.put(input2.charAt(i), 1);
            } else {
                charMap2.put(input2.charAt(i), charMap2.get(input2.charAt(i)) + 1);
            }
        }
        return charMap2.equals(charMap1);
    }

    /**
     * Approach 2 - Count the character frequency of first string and match if
     * that is same as in second string
     *
     * @param input1 first string
     * @param input2 second string
     * @return
     */
    public boolean isAnagramApproach2(String input1, String input2) {
        if (input1.length() != input2.length()) return false;

        int[] charFreq = new int[256];
        for (int i = 0; i < input1.length(); ++i) {
            ++charFreq[input1.charAt(i)];
            --charFreq[input2.charAt(i)];
        }
        for (int j : charFreq)
            if (j != 0) return false;
        return true;
    }

    /**
     * Approach 3 - sort the characters of the strings and match if they are equal
     *
     * @param input1 first string
     * @param input2 second string
     * @return
     */
    public boolean isAnagramApproach3(String input1, String input2) {
        ArrayList<Character> str1 = new ArrayList<>();
        ArrayList<Character> str2 = new ArrayList<>();
        for (char ch1 : input1.toCharArray()) {
            str1.add(ch1);
        }
        for (char ch2 : input2.toCharArray()) {
            str2.add(ch2);
        }
        Collections.sort(str1);
        Collections.sort(str2);

        return String.valueOf(str1).equals(String.valueOf(str2));
    }

    /**
     * Approach 4 - count unique characters and match their frequency
     *
     * @param input1 first string
     * @param input2 second string
     * @return
     */
    public boolean isAnagramApproach4(String input1, String input2) {
        if (input1.length() != input2.length()) return false;

        int[] letters = new int[256];
        int numUniqueChars = 0;
        int numCompletedT = 0;
        char[] input1_arr = input1.toCharArray();
        for (char c : input1_arr) {
            if (letters[c] == 0) ++numUniqueChars; //count of unique characters
            ++letters[c]; //frequency of character
        }

        for (int i = 0; i < input2.length(); ++i) {
            if (letters[input2.charAt(i)] == 0) { //character which was not present in first string
                return false;
            }
            --letters[input2.charAt(i)]; //remaining characters count in second string
            if (letters[input2.charAt(i)] == 0) {
                ++numCompletedT; //count of completed characters in second string

                if (numUniqueChars == numCompletedT) {
                    //if unique characters found in first string
                    // matches the count in second string and string length is exhausted
                    return i == input2.length() - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Anagram a = new Anagram();
        String str1 = "shashi";
        String str2 = "ashish";
        if (a.isAnagramApproach1(str1, str2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }

        if (a.isAnagramApproach2(str1, str2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }

        if (a.isAnagramApproach3(str1, str2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
        if (a.isAnagramApproach4(str1, str2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }
}

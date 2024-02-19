package com.dsa.arraysandstrings;

/**
 * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
 * five characters, including the null character.)
 */
public class ReverseCStyleString {

    public String reverseStringApproach1(String inputString) {
        char[] charArray = inputString.toCharArray();
        for (int i = 0; i < (charArray.length - 1) / 2; i++) {
            char ch = charArray[i];
            charArray[i] = charArray[charArray.length - i - 2];
            charArray[charArray.length - i - 2] = ch;
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        ReverseCStyleString r = new ReverseCStyleString();
        System.out.println(r.reverseStringApproach1("abcd\0"));
    }
}

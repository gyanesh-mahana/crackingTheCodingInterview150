package com.dsa.arraysandstrings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of
 * another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
 * only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class StringRotation {


    /**
     * use isSubstring only once by checking if the string is concatenated twice
     * will have the original string as substring or not
     *
     * @param str1 original string
     * @param str2 rotated string
     * @return true if str2 is rotated string of str1
     */
    public boolean isStringRotated(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }
        return isSubstring(str2 + str2, str1);
    }

    /**
     * find if the given string is a substring of another or not
     *
     * @param s1 first string original
     * @param s2 second string sub string
     * @return
     */
    public static boolean isSubstring(String s1, String s2) {

        int i = 0, j = 0;
        do {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                j = 0;
            }
        } while (i < s1.length() && j < s2.length());
        if (j == s2.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        StringRotation s = new StringRotation();
        if (s.isStringRotated(str1, str2)) {
            System.out.print("String is rotated");
        } else {
            System.out.print("String is not rotated");
        }
    }

}

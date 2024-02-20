package com.dsa.arraysandstrings;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 */
public class ReplaceSpaces {

    /**
     * Approach 1 - used String class inbuilt replace method
     *
     * @param inputStr input string
     * @return
     */
    public String getReplacedStringApproach1(String inputStr) {
        if (inputStr == null) return inputStr;
        return inputStr.replace(" ", "%20");
    }

    /**
     * Approach 2 - create a string with increased length after calculating
     * number of spaces and put the updated characters into it
     *
     * @param inputStr input string as character array
     * @param len length of the string character array size
     * @return
     */
    public String getReplacedStringApproach2(char[] inputStr, int len) {
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (inputStr[i] == ' ') {
                spaceCount++;
            }
        }
        int newLen = len + 2 * spaceCount;
        char[] newStr = new char[newLen];
        for (int i = len - 1; i >= 0; --i) {
            if (inputStr[i] == ' ') {
                newStr[newLen - 1] = '0';
                newStr[newLen - 2] = '2';
                newStr[newLen - 3] = '%';
                newLen = newLen - 3;
            } else {
                newStr[newLen - 1] = inputStr[i];
                newLen--;
            }
        }
        return String.valueOf(newStr);
    }

    public static void main(String[] args) {
        String str = "I am a boy";
        ReplaceSpaces r = new ReplaceSpaces();
        System.out.println(r.getReplacedStringApproach1(str));
        System.out.println(r.getReplacedStringApproach2(str.toCharArray(), str.length()));
    }
}

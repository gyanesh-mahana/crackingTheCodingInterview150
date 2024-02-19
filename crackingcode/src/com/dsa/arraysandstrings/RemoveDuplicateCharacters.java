package com.dsa.arraysandstrings;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer. NOTE: One or two additional variables are fine.
 * An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 */
public class RemoveDuplicateCharacters {

    /**
     * Approach 1 to shift the characters leftwards if any duplicate is found
     * Time - O(N^2)
     * Space - O(1)
     *
     * @param input string
     * @return updated string without any duplicates
     */
    public String removeDuplicateCharsApproach1(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    input = shiftCharsLeft(input, j, input.length());
                    j--; //because the characre is shifted left we need to start with the same index as previous
                }
            }
        }
        return input;
    }

    /**
     * Approach 2 - Have a boolean array of constant size and perform the shifting if duplicate found
     * Time = O(N^2)
     *
     * @param input string
     * @return updated string without any duplicates
     */
    public String removeDuplicateCharsApproach2(String input) {
        boolean[] charBoolean = new boolean[256];
        for (int i = 0; i < input.length(); i++) {
            if (!charBoolean[input.charAt(i)]) {
                charBoolean[input.charAt(i)] = true;
            } else {
                input = shiftCharsLeft(input, i, input.length());
                i--;
            }
        }
        return input;
    }

    /**
     * Approach 3 - No need to shift the whole trailing substring just replace the non-matching character
     * with the tail character
     * Time O(N^2)
     *
     * @param input string
     * @return updated string without any duplicates
     */
    public String removeDuplicateCharsApproach3(String input) {
        if (input == null) return null;
        if (input.length() < 2) return null;
        char[] str = input.toCharArray();
        int tail = 1;
        //run for all the characters
        for (int i = 1; i < str.length; ++i) {
            int j;
            // run till we find a duplicate or hit the tail character
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            // if we hit the tail replace the tail with the unique character till tail
            // and increase the tail index
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        return String.valueOf(str, 0, tail);

    }

    /**
     * Approach 4 - Having a constant size boolean array for each ASCII character duplicate
     * if a unique character found replace it with tail otherwise run till the length of the string
     * Time - O(N)
     * Space - O(1)
     *
     * @param input string
     * @return updated string without any duplicates
     */
    public String removeDuplicateCharsApproach4(String input) {
        char[] str = input.toCharArray();
        boolean[] hit = new boolean[256];//false by default
        hit[str[0]] = true;
        int tail = 1;
        for (int i = 1; i < str.length; ++i) {
            if (!hit[str[i]]) {
                str[tail] = str[i];
                ++tail;
                hit[str[i]] = true;
            }
        }
        return String.valueOf(str, 0, tail);

    }

    /**
     * Method to shift the characters of a string from stat index to end index
     *
     * @param input      string
     * @param startIndex starting index
     * @param lastIndex  end index
     * @return updated string without any duplicates
     */
    public static String shiftCharsLeft(String input, int startIndex, int lastIndex) {
        char[] charArray = input.toCharArray();
        for (int i = startIndex; i < lastIndex - 1; i++) {
            charArray[i] = charArray[i + 1];
        }
        return String.valueOf(charArray, 0, lastIndex - 1);
    }

    public static void main(String[] args) {
        RemoveDuplicateCharacters r = new RemoveDuplicateCharacters();
        String input = null;
        input = "avalanche";
        /**
         * test Cases:
         * 1. null string
         * 2. empty string
         * 3. no duplicate characters in string
         * 4. all duplicate characters in string
         * 5. consecutive duplicate characters in the string
         * 6. non-consecutive duplicate characters in string
         */
        System.out.println(r.removeDuplicateCharsApproach1(input));
        System.out.println(r.removeDuplicateCharsApproach2(input));
        System.out.println(r.removeDuplicateCharsApproach3(input));
        System.out.println(r.removeDuplicateCharsApproach4(input));
    }
}
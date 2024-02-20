package com.dsa.arraysandstrings;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateImage {

    /**
     * Rotate the image by 90 degrees
     * Space - O(N^2)
     * Time - O(N^2)
     *
     * @param image in form of N*N 2 D integer array
     * @return rotated 2D array
     */
    public int[][] rotateImageBy90DegreesApproach1(int[][] image) {
        //right rotation
        int[][] result = new int[image.length][image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = image.length - 1; j >= 0; j--) {
                result[i][image.length - j - 1] = image[j][i];
            }
        }

//        //left rotation
//        for (int j = image.length - 1; j >= 0; j--) {
//            for (int i = 0; i < image.length; i++) {
//                result[image.length - j - 1][i] = image[i][j];
//            }
//        }
        return result;
    }


    /**
     * Approach 2 layer by layer rotation done inline without any additional space
     * A[i][j] = A[j][len-i-1] for left rotation
     * A[i][j] = A[len-j-1][i] for right rotation
     * Time - O(N^2)
     * Space - O(1)
     *
     * @param image in 2D array of N*N
     * @return rotated image
     */
    public int[][] rotateImageBy90DegreesApproach2(int[][] image) {
        //left rotation
        for (int i = 0; i < (image.length / 2); i++) {
            for (int j = i; j < (image.length - i - 1); j++) {
                int temp = image[i][j];
                image[i][j] = image[j][image.length - i - 1];
                image[j][image.length - i - 1] = image[image.length - i - 1][image.length - j - 1];
                image[image.length - i - 1][image.length - j - 1] = image[image.length - j - 1][i];
                image[image.length - j - 1][i] = temp;
            }
        }

//        //right rotation
//        for (int i = 0; i < image.length / 2; i++) {
//            for (int j = i; j < (image.length - i - 1); j++) {
//                int temp = image[i][j];
//                image[i][j] = image[image.length - j - 1][i];
//                image[image.length - j - 1][i] = image[image.length - i - 1][image.length - j - 1];
//                image[image.length - i - 1][image.length - j - 1] = image[j][image.length - i - 1];
//                image[j][image.length - i - 1] = temp;
//            }
//        }
        return image;
    }

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        int[][] image = {
                {1, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] result = r.rotateImageBy90DegreesApproach2(image);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

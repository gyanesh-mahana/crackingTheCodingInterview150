package com.dsa.arraysandstrings;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column is set to 0.
 */
public class MatrixUpdateZeroRowColumn {

    /**
     * Approach 1 - store the row and columns and thereafter update the row and column item to 0
     * Time - O(M*N)
     *
     * @param matrix input
     * @param rowLen length of rows
     * @param colLen length of columns
     * @return updated matrix
     */
    public int[][] updateMatrixWithZero(int[][] matrix, int rowLen, int colLen) {
        boolean[] rowHit = new boolean[rowLen];
        boolean[] colHit = new boolean[colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rowHit[i] = true;
                    colHit[j] = true;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (rowHit[i] || colHit[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3},
                {6, 5, 4},
                {1, 0, 0},
                {1, 5, 8}};

        MatrixUpdateZeroRowColumn m = new MatrixUpdateZeroRowColumn();
        input = m.updateMatrixWithZero(input, input.length, input[0].length);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }
    }
}

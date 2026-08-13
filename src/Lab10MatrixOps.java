/*
 * COSC 1173 Programming Lab - Lab 10: Matrix Operations
 * Textbook reference: Liang, Chapter 8 (Multidimensional Arrays)
 *
 * Student name: [TYPE YOUR NAME HERE]
 * Date:         [TYPE TODAY'S DATE HERE]
 *
 * DO NOT change any method name, parameter list, or return type.
 * REQUIREMENT: every executable statement you write must carry a line comment.
 *
 * Reminder: for a 2-D array m, m.length is the number of ROWS and
 * m[r].length is the number of COLUMNS in row r.
 */
public class Lab10MatrixOps {

    /**
     * STEP 1 - Returns an array whose element r is the sum of row r.
     * A 3-row matrix produces an array of length 3.
     */
    public static int[] rowSums(int[][] m) {
        return new int[0]; // placeholder
    }

    /**
     * STEP 2 - Returns an array whose element c is the sum of column c.
     * The result length is the number of columns, m[0].length.
     * TODO: the OUTER loop must run over columns and the INNER loop over rows.
     */
    public static int[] columnSums(int[][] m) {
        return new int[0]; // placeholder
    }

    /**
     * STEP 3 - Returns the transpose: element [r][c] of the result equals
     * element [c][r] of the input. An m-by-n matrix transposes to n-by-m.
     */
    public static int[][] transpose(int[][] m) {
        return new int[0][0]; // placeholder
    }

    /**
     * STEP 4 - Returns the matrix product a * b.
     * result[i][j] is the sum over k of a[i][k] * b[k][j].
     * Return null when the shapes do not conform, that is when the number of
     * columns in a differs from the number of rows in b.
     * TODO: three nested loops - i over rows of a, j over columns of b, k over the shared dimension.
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        return null; // placeholder
    }

    /**
     * STEP 5 - Reports whether a square matrix equals its own transpose,
     * that is m[r][c] == m[c][r] for every pair. A non-square matrix is not symmetric.
     */
    public static boolean isSymmetric(int[][] m) {
        return false; // placeholder
    }

    /**
     * STEP 6 - Returns the largest single value anywhere in the matrix.
     * Return Integer.MIN_VALUE when the matrix is null or has no elements.
     */
    public static int largest(int[][] m) {
        return Integer.MIN_VALUE; // placeholder
    }

    /** STEP 7 - TODO: build a sample matrix and print the result of each method. */
    public static void main(String[] args) {
        int[][] sample = {{1, 2, 3}, {4, 5, 6}}; // 2 rows, 3 columns
        System.out.println("Largest: " + largest(sample)); // example call
    }
}

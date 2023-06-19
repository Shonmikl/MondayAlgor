package _2023_06_19;

public class Matrix {
    public boolean searchMatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;

        while (i < m && j >= 0) {
            if(matrix[i][j] == k) {
                return true;
            }
            if(matrix[i][j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}

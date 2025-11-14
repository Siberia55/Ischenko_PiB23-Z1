package academy.tochkavhoda.introduction;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroSteps4 {
    public int min(int[][] matrix) {
        if (matrix.length == 0) {
            return Integer.MAX_VALUE;
        }

        int min = matrix[0][0];

        for (int[] arr : matrix) {
            for (int num : arr) {
                if (min > num) {
                    min = num;
                }
            }
        }

        return min;
    }

    public int max(int[][] matrix) {
        if (matrix.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = matrix[0][0];

        for (int[] arr : matrix) {
            for (int num : arr) {
                if (max < num) {
                    max = num;
                }
            }
        }

        return max;
    }

    public boolean find(int[][] matrix, int value) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                if (num == value) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 1; i < row.length; i++) {
                if (row[i] >= row[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hasNoZeroRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            boolean hasZero = false;
            for (int element : row) {
                if (element == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (!hasZero) {
                count++;
            }
        }
        return count;
    }

    public boolean hasFullZeroRow(int[][] matrix) {
        for (int[] row : matrix) {
            if (row.length == 0) {
                continue;
            }

            boolean isZeroRow = true;
            for (int num : row) {
                if (num != 0) {
                    isZeroRow = false;
                    break;
                }
            }
            if (isZeroRow) {
                return true;
            }
        }

        return false;
    }

    public boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int mainDiagonalMax(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            if (max < matrix[i][i]) {
                max = matrix[i][i];
            }
        }

        return max;
    }

    public int mainDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;

        if (matrix.length != 0 && matrix[0].length != 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] > 0) {
                    sum += matrix[i][i];
                }
            }
        }

        return sum;
    }

    public int secondaryDiagonalMax(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[i][matrix.length - 1 - i];
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[i][matrix.length - 1 - i];
            if (value > 0) {
                sum += value;
            }
        }
        return sum;
    }

    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int maxRows = Math.max(matrix1.length, matrix2.length);

        int[][] result = new int[maxRows][];

        for (int i = 0; i < maxRows; i++) {
            int length1 = (i < matrix1.length) ? matrix1[i].length : 0;
            int length2 = (i < matrix2.length) ? matrix2[i].length : 0;

            result[i] = new int[Math.max(length1, length2)];

            for (int j = 0; j < result[i].length; j++) {
                int value1 = (j < length1) ? matrix1[i][j] : 0;
                int value2 = (j < length2) ? matrix2[i][j] : 0;
                result[i][j] = value1 + value2;
            }
        }
        return result;
    }

    public void transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void interchange(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        for (int i = 0; i < matrix.length; i += 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    public int[] toLinearByRow(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int totalElements = 0;

        for (int[] row : matrix) {
            totalElements += row.length;
        }

        int[] result = new int[totalElements];
        int index = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                result[index++] = value;
            }
        }

        return result;
    }

    public int[] toLinearByColumn(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int n = matrix.length;
        int totalElements = n * n;
        int[] result = new int[totalElements];

        int index = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                result[index++] = matrix[i][j];
            }
        }

        return result;
    }

    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int n = matrix.length;
        ArrayList<Integer> upperTriangleElements = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                upperTriangleElements.add(matrix[i][j]);
            }
        }

        int[] result = new int[upperTriangleElements.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = upperTriangleElements.get(i);
        }

        return result;
    }

    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        return Arrays.stream(matrix)
                .mapToInt(row -> {
                    int sum = 0;
                    for (int value : row) {
                        if (value == barrier) {
                            break;
                        }
                        sum += value;
                    }
                    return sum;
                })
                .sum();
    }

    public int sumUntilNotFound(int[][] matrix, int barrier) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == barrier) {
                    return sum;
                }
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

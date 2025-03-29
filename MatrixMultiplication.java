import java.io.*;
import java.util.*;

public class MatrixMultiplication {
    public static void main(String[] args) throws IOException{
        if (args.length == 2){
            int [] [] matrix_1 = readMatrixFile(args[0]);
            int [] [] matrix_2 = readMatrixFile(args[1]);
            int [] [] result = multiplyMatrices(matrix_1, matrix_2);
            writeMatrixToFile("result.txt", result);
    } else if (args.length == 1) {
        try {
            int size = Integer.parseInt(args[0]);
            int [] [] matrix_1 = generateRandomMatrix(size, size);
            int [] [] matrix_2 = generateRandomMatrix(size, size);
            writeMatrixToFile("matrix_1.txt", matrix_1);
            writeMatrixToFile("matrix_2.txt", matrix_2);
            int [] [] result = multiplyMatrices(matrix_1, matrix_2);
            writeMatrixToFile("result.txt", result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid size argument. Please provide a valid integer.");
        }
    } else {
        System.out.println("Usage: java MatrixMultiplication <matrix_1_file> <matrix_2_file>");
        System.out.println("or");
        System.out.println("java MatrixMultiplication <size>");
        System.out.println("java MatrixMultiplication <size>");
    }
}
    private static int[][] readMatrixFile(String fileName) throws IOException {
        List<int[]> matrix = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split("\\s+");
                int[] row = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
                matrix.add(row);
            }
        }
        return matrix.toArray(new int[0][]);
    }

    private static void writeMatrixToFile(String filename, int[][] matrix) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int[] row : matrix) {
                for (int num : row) {
                    bw.write(num + " ");
                }
                bw.newLine();
            }
        }
    }

    private static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random values 0-9
            }
        }
        return matrix;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}    
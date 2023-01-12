package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixAddition {

    private static void printMatrix(List<List<Integer>> matrix) {
        int rows = matrix.size();
        if (rows == 0) {
            System.out.println("Matrix is empty");
            return;
        }
        int cols = matrix.get(0).size();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> addMatrix(List<List<Integer>> matrix1, List<List<Integer>> matrix2) {
        List<List<Integer>> resultMatrix = new ArrayList<>();
        if ((matrix1.size() != matrix2.size()) || (matrix1.size() == 0) || (matrix2.size() == 0) || (matrix1.get(0).size() != matrix2.get(0).size())) {
            return resultMatrix;
        }
        int rows = matrix1.size();
        int cols = matrix1.get(0).size();

        for (int row = 0; row < rows; row++) {
            List<Integer> rowSum = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowSum.add(matrix1.get(row).get(col) + matrix2.get(row).get(col));
            }
            resultMatrix.add(rowSum);
        }
        return resultMatrix;
    }

    private static List<List<Integer>> createAndAddMatrix(String fileName) {
        // First create the two matrices by reading from the file line by line
        // First line will contain rows and columns
        // After that matrices will be given
        int rows = 0, cols = 0;
        List<List<Integer>> matrix1 = new ArrayList<>();
        List<List<Integer>> matrix2 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int lineCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isBlank()) {
                    System.out.println("Line is empty. Moving to next line.");
                    continue;
                }
                List<String> splitLine = Arrays.asList(line.split(","));

                // First line contains rows and columns
                if (lineCount == 0) {
                    // Set the rows and columns
                    rows = Integer.parseInt(splitLine.get(0).trim());
                    cols = Integer.parseInt(splitLine.get(1).trim());
                    System.out.println("Rows are " + rows + " and cols are " + cols);
                } else {
                    List<Integer> rowList = new ArrayList<>();
                    for (int index = 0; index < splitLine.size(); index++) {
                        rowList.add(Integer.parseInt(splitLine.get(index).trim()));
                    }
                    // First n lines contain matrix 1
                    if (lineCount <= rows) {
                        matrix1.add(rowList);
                    } else {
                        matrix2.add(rowList);
                    }
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the matrices
        System.out.println("Print the matrix");
        printMatrix(matrix1);

        System.out.println("Print the matrix");
        printMatrix(matrix2);

        return addMatrix(matrix1, matrix2);
    }

    public static void main(String[] args) {
        String fileName = "input/matrix-add.txt";
        List<List<Integer>> sumMatrix = createAndAddMatrix(fileName);
        // Print the resultant sum matrix
        System.out.println("The sum matrix is ");
        printMatrix(sumMatrix);
    }
}
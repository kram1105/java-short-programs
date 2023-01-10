import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

// Read from a file and write it's content to an output file
// Step 1 - write a function to get file content
// Step 2 - Write a function to write the content in a file
public class Question2 {

    private static String getFileContent(String inputFileName) {
        String fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(inputFileName)));
        } catch (IOException e) {
            System.out.println("Unable to read the file.");
            e.printStackTrace();
        }
        return fileContent;
    }

    private static void writeInFile(String inputFileName, String outputFilePath) {
        try {
            String fileContent = getFileContent(inputFileName);
            if (Objects.isNull(fileContent) || fileContent.isBlank()) {
                System.out.println("File is empty.");
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to write in a file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Input File is present
        String inputFileName = "input/input.txt";
        String outputFileName = "output.txt";
        writeInFile(inputFileName, outputFileName);

        // Input file is not present
        String missingInputFileName = "missing-input.txt";
        String missingOutputFileName = "missing-output.txt";
        writeInFile(missingInputFileName, missingOutputFileName);

        // Input File is empty
        String emptyInputFileName = "input/empty-file.txt";
        String emptyOutputFileName = "empty-output.txt";
        writeInFile(emptyInputFileName, emptyOutputFileName);
    }
}

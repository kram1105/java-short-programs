import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Question3 {

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

    private static int addNumbersFromFile(String inputFileName) {
        String fileContent = getFileContent(inputFileName);
        if (Objects.isNull(fileContent) || fileContent.isBlank()) {
            System.out.println("File is empty.");
            return 0;
        }
        List<String> numbers = Arrays.asList(fileContent.split(","));
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += Integer.parseInt(numbers.get(i).trim());
        }
        return sum;
    }
    public static void main(String[] args) {
        // When input file is present
        String inputFile = "input/sum-input.txt";
        int sum = addNumbersFromFile(inputFile);
        System.out.println("The sum is " + sum);

        // When input file is missing sum should be 0
        String missingInputFile = "missing-input.txt";
        sum = addNumbersFromFile(missingInputFile);
        System.out.println("The sum is " + sum);

        // Space separated input
        String spaceSeparatedFile = "input/comma-space-separated-number.txt";
        sum = addNumbersFromFile(spaceSeparatedFile);
        System.out.println("The sum is " + sum);
    }
}

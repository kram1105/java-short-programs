import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// The class name of a java program should start from Capital letter
// Read a file and print it's content on the console
public class Question1 {

    private static void readAndPrintFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file is not present at the given location.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error while reading the file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        // When input file exists
        String fileName = "input/input.txt";
        readAndPrintFile(fileName);

        // When input file is not present
        readAndPrintFile("missing-input.txt");
    }
}

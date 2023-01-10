import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Question4 {

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

    private static String getStringInBothList(List<String> list1, List<String> list2) {
        // Add list 1 elements in Set
        Set<String> stringSet = new HashSet<>();
        for (int index = 0; index < list1.size(); index++) {
            stringSet.add(list1.get(index));
        }
        System.out.println("Hash set containing list 1 is " + stringSet);
        StringBuilder res = new StringBuilder();

        // Iterate on the second list and append it to the result
        for (int index = 0; index < list2.size(); index++) {
            if (stringSet.contains(list2.get(index))) {
                System.out.println("common word of list " + list2.get(index));
                res.append(list2.get(index));
                res.append("\n");
            }
        }
        return res.toString();
    }

    private static void writeInFile(String fileContent) {
        try {
            if (Objects.isNull(fileContent) || fileContent.isBlank()) {
                System.out.println("No common line is present.");
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("common-file.txt"));
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to write in a file.");
            e.printStackTrace();
        }
    }

    private static void getIntersectionOfFiles(String inputFile1, String inputFile2) {
        String fileContent1 = getFileContent(inputFile1);
        System.out.println(fileContent1);
        System.out.println("===========");
        String fileContent2 = getFileContent(inputFile2);
        System.out.println(fileContent2);
        System.out.println("============");
        if (Objects.isNull(fileContent2) || Objects.isNull(fileContent1) || fileContent1.isBlank() || fileContent2.isBlank()) {
            System.out.println("One of the file is empty.");
            return;
        }
        // Split the content by new line
        List<String> list1 = Arrays.asList(fileContent1.split("\\r?\\n"));
        System.out.println("List1 is " + list1);
        List<String> list2 = Arrays.asList(fileContent2.split("\\r?\\n"));
        System.out.println("List2 is " + list2);
        String commonString = getStringInBothList(list1, list2);
        System.out.println("common string is ");
        System.out.println(commonString);
        writeInFile(commonString);
    }

    public static void main(String[] args) {
        String inputFile1 = "input/input1.txt";
        String inputFile2 = "input/input2.txt";
        getIntersectionOfFiles(inputFile1, inputFile2);
    }
}

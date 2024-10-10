package Lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class StreamOperator{
    final static String DEFAULT_DELIMETER = ",";
    final static String WORD_REGEX = "[0-9a-zA-z\\-]+";
    final static String NUMBER_REGEX = "\\d+";
    final static String ALLOWED_EXTENSIONS_REGEX = "csv|txt";
    final static String PATH_REGEX = "(" + WORD_REGEX + "\\/)*" + WORD_REGEX + "\\.(" + ALLOWED_EXTENSIONS_REGEX + ")";

    public static List<String[]> readCsv(String filename, String delimeter) throws IOException {
        List<String[]> values = new ArrayList<>();

        Path csvPath = Paths.get(filename);
        for (String line: Files.readAllLines(csvPath)){
            values.add(line.split(delimeter));
        }
        return values;
    }

    public static List<String[]> readCsv(String filename) throws IOException {
        return readCsv(filename, DEFAULT_DELIMETER);
    }

    public static void writeCsv(String filename, Map<String, List<String>> map, String delimeter) throws IOException {
        List<String> content = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()){
            for (String item: entry.getValue()){
                content.add(String.join(delimeter, entry.getKey(), item));
            }
        }

        Path csvPath = Paths.get(filename);
        Files.write(csvPath, content);
    }

    public static void writeCsv(String filename, Map<String, List<String>> map) throws IOException{
        writeCsv(filename, map, ",");
    }

    public static String readValidatedInput(String prompt, String validator){
        String result;
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.print(prompt + ": ");
            try {
                if ((result = stdin.readLine()).matches(validator)){
                    return result;
                }
                System.err.println("Value you enetered is incorrect, try again");
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    public static int readInt(String prompt, int lowerBound, int upperBound){
        int result;

        result = Integer.parseInt(readValidatedInput(prompt, NUMBER_REGEX));
        while (result > upperBound || result < lowerBound){
            System.err.println("Your choice is incorrect, try again");
            result = Integer.parseInt(readValidatedInput(prompt, NUMBER_REGEX));
        }

        return result;
    }
}
package Lab5old;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ConvertData {
    public static int convertData(String inputFile, String outputFile){
        int writtenCount = 0;
        try {
            File toRead = new File(System.getProperty("user.dir") + "/" + inputFile);
            Scanner scanner = new Scanner(toRead);
            FileWriter toWrite = new FileWriter(outputFile);
            MyData prevData = new MyData(0, 0, 0, ""), currentData;
            
            while (scanner.hasNextLine()) {
                currentData = MyData.fromString(scanner.nextLine());
                if (!currentData.equals(prevData)){
                    toWrite.write(currentData.toString().concat("\n"));
                    writtenCount++;
                    prevData = currentData;
                }
            }
            
            scanner.close();
            toWrite.close();
        } catch (Exception e) {
            System.err.println("File " + e.toString() + " not found");
            e.printStackTrace();
        }

        return writtenCount;
    }

    public static void main(String[] args) {
        String inputFile = "Lab5/InputData.txt", outputFile = "Lab5/MyData.txt";
        if (args.length >= 1)
            inputFile = args[0];
        if (args.length >= 2)
            outputFile = args[1];

        System.out.println("Saved " + convertData(inputFile, outputFile) + " lines");
    }
}

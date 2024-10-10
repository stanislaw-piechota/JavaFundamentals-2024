package Lab7;
import Lab5.StreamOperator;

public class AddVectors {
    private static Vector readVector(){
        String input = StreamOperator.readValidatedInput("\nEnter vector coordinates", ".*");
        return Vector.fromString(input);
    }

    public static void run(){
        Vector vectorSum = null, newVector;
        while (true){
            try {
                newVector = readVector();
                System.out.println("Read vector " + newVector.toString());
                if (vectorSum != null)
                    System.out.println("Vector sum is " + vectorSum.toString());
                vectorSum = (vectorSum == null ? newVector : Vector.add(vectorSum, newVector));
                System.out.println("New vector sum is " + vectorSum.toString());
            } catch (DifferentVectorsLengthException e) {
                System.err.println(e.getMessage());
                System.err.println("Try again");
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}

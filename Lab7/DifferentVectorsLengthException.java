package Lab7;

public class DifferentVectorsLengthException extends Exception {
    final static String ERROR_FORMAT = "Vector %s of length %d cannot be added to vector %s of length %d";
    public DifferentVectorsLengthException(Vector v1, Vector v2){
        super(String.format(ERROR_FORMAT, v1.toString(), v1.getLength(), v2.toString(), v2.getLength()));
    }
}

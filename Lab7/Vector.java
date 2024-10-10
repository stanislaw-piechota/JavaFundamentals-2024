package Lab7;

import java.util.List;
import java.util.ArrayList;

public class Vector {
    final static String DEFAULT_DELIMETER = ",";
    final static String NUMBER_REGEX = "-?\\d+";
    private List<Integer> dimensions;
    private int length = 0;

    public Vector(List<Integer> dimensions){
        this.dimensions = dimensions;
        this.length = dimensions.size();
    }

    public String toString(){
        String result = "[ ";
        for (int item: this.dimensions){
            result += item + " ";
        }
        return result + "]";
    }

    public static Vector fromString(String vectorString, String delimeter){
        List<Integer> result = new ArrayList<>();
        for (String inputElement: vectorString.split(delimeter)){
            if (inputElement.matches(NUMBER_REGEX)){
                result.add(Integer.parseInt(inputElement));
            }
        }
        return new Vector(result);

    }

    public static Vector fromString(String vectorString){
        return fromString(vectorString, DEFAULT_DELIMETER);
    }

    public int getLength(){
        return this.length;
    }

    public int getDimension(int index){
        return this.dimensions.get(index);
    }

    public static Vector add(Vector v1, Vector v2) throws DifferentVectorsLengthException {
        if (v1.length != v2.length){
            throw new DifferentVectorsLengthException(v1, v2);
        }

        List<Integer> newDimensions = new ArrayList<>();
        for (int i=0; i<v1.length; i++){
            newDimensions.add(v1.getDimension(i) + v2.getDimension(i));
        }

        return new Vector(newDimensions);
    }
}

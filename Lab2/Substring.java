package Lab2;
import java.lang.IllegalArgumentException;
import java.lang.StringIndexOutOfBoundsException;

public class Substring {
    private String string;
    private int startIndex, endIndex;

    public Substring(String[] args){
        this.checkArgsLength(args);

        this.string = args[0];
        this.startIndex = Integer.parseInt(args[1]);
        this.endIndex = Integer.parseInt(args[2]);

        this.checkIndexErrors();
    }

    private void checkArgsLength(String args[]){
        if (args.length != 3) {
            throw new IllegalArgumentException("You must specify only 3 arguments");
        }
    }

    private void checkIndexErrors(){
        if (this.startIndex > this.endIndex){
            throw new IllegalArgumentException("Start index cannot be greater than end index");
        }

        if (this.startIndex < 0 || this.endIndex < 0){
            throw new IllegalArgumentException("Indexes cannot be negative");
        }

        if (this.startIndex >= this.string.length()){
            throw new StringIndexOutOfBoundsException("Start index is not pointing to a character in string");
        }

        if (this.endIndex + 1 > this.string.length()){
            throw new StringIndexOutOfBoundsException("End index is not pointing to a character in string");
        }

        if (!this.string.matches("^[a-zA-z]+$")){
            throw new IllegalArgumentException("String must contain only characters");
        }
    }

    public String getSubstring(){
        // range from [start, end] instead of [start, end)
        return this.string.substring(this.startIndex, this.endIndex+1);
    }

    public static void main(String[] args) {
        try {
            Substring substring = new Substring(args);
            System.out.println("Result: " + substring.getSubstring());
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}

package Lab1;
import java.lang.Math;

public class Polynomial {
    private int A, B, C;
    private double delta;
    
    public Polynomial(String[] args){
        this.setA(args[0]);
        this.setB(args[1]);
        this.setC(args[2]);
        this.delta = 0;
    }
    
    public void setA(String value){
        this.A = Integer.parseInt(value);
    }

    public void setB(String value) {
        this.B = Integer.parseInt(value);
    }
    
    public void setC(String value) {
        this.C = Integer.parseInt(value);
    }

    private void calculateDelta(){
        double deltaSquared = Math.pow(this.B, 2) - 4 * this.A * this.C;
        if (deltaSquared < 0) {
            System.err.println("Delta^2 is negative, there are no roots");
            throw new IllegalArgumentException();
        }
        this.delta = Math.sqrt(deltaSquared);
    }

    public double calculateRoot(int sign){
        return (-B + sign * this.delta) / (2 * A);
    }
    
    public static void main(String[] args){
        if (args.length != 3) {
            System.err.println("Only 3 arguments!");
            throw new IllegalArgumentException();
        }

        Polynomial squareEquation = new Polynomial(args);
        squareEquation.calculateDelta();

        System.out.println("Root x1 = " + squareEquation.calculateRoot(-1));
        System.out.println("Root x1 = " + squareEquation.calculateRoot(1));
    }
}
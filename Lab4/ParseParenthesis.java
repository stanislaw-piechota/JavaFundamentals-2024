package Lab4;
import java.util.Scanner;

public class ParseParenthesis {
    // syntax validators
    static String numberRegex = "(-?\\d+(\\.\\d+)?)", signRegex = "( *[+\\-/*] *)";
    static String baseSyntaxRegex = "(\\(*(" + numberRegex + signRegex + ")*" + numberRegex + "\\)*)";
    static String fullSyntaxRegex = "^(" + baseSyntaxRegex + signRegex + ")*" + baseSyntaxRegex + "$";
    
    private Scanner scanner;
    private String expression;

    public ParseParenthesis(){
        this.scanner = new Scanner(System.in);
    }

    public void setExpression(){
        System.out.print("Give en arithmetic expression to parse: ");
        this.expression = this.scanner.nextLine();
    }

    public void setExpression(String value){
        this.expression = value;
    }

    private boolean isSyntaxCorrect(){
        return this.expression.matches(fullSyntaxRegex);
    }

    private boolean areParenthesisMatched(){
        int level = 0;
        for (char c : this.expression.toCharArray()) {
            if (c == '(')
                level++;
            else if (c == ')')
                level--;

            if (level < 0)
                return false;
        }

        if (level != 0)
            return false;
        return true;
    }

    public boolean isExpressionCorrect(){
        // no division by 0 error support

        if (!this.isSyntaxCorrect()){
            System.err.println("Expression syntax is also mismatched");
            return false;
        }

        return this.areParenthesisMatched();
    }

    public boolean isExpressionCorrect(String expression){
        this.setExpression(expression);
        return this.isExpressionCorrect();
    }

    public static void main(String[] args) {
        ParseParenthesis parser = new ParseParenthesis();
        if (args.length == 1)
            parser.setExpression(args[0]);
        else
            parser.setExpression();

        System.out.println(parser.isExpressionCorrect() ? "MATCHED" : "MISMATCHED");

        // close stream scanner at the end of the program
        parser.scanner.close();
    }
}

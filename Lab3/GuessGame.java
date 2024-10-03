package Lab3;
import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    // constants
    int MAX_NUMBER = 100;

    private int tries;
    private Scanner scanner;

    public GuessGame(){
        this.tries = 0;
        this.scanner = new Scanner(System.in);
    }

    public void runGame(){
        System.out.println("\nStarting new game!");

        this.tries = 0;
        Random rand = new Random();
        int toGuess = rand.nextInt(MAX_NUMBER+1), userGuess;

        do {
            userGuess = this.getInput();
            this.tries++;
            this.printHint(toGuess, userGuess);
        } while(userGuess != toGuess);
    }

    private void printHint(int toGuess, int userGuess){
        if (userGuess < toGuess){
            System.out.println("Your guess is to small");
        } else if (userGuess > toGuess) {
            System.out.println("Your guess is to big");
        } else {
            System.out.println("You guessed correctly after "+ this.tries + " tries");
        }
    }

    private int parseInput(String input){
        if (!input.matches("^\\d+$")){
            System.err.println("Input you provided was wrong, try again!");
            return -1;
        }

        int result = Integer.parseInt(input);
        if (result > MAX_NUMBER){
            System.err.println("Input you provided was wrong, try again!");
            return -1;
        }
        
        return result;
    }

    private int getInput(){
        String inpuString = "";
        int inputNumber;

        do {
            System.out.print("Give a number to guess: ");
            inpuString = this.scanner.nextLine();
        } while ((inputNumber = this.parseInput(inpuString)) < 0);

        return inputNumber;
    }

    private boolean getChoiceContinue(){
        String inpuString;

        do {
            System.out.print("Would you like to pay again [Y/N]: ");
            inpuString = this.scanner.nextLine();
        } while(!inpuString.matches("^[YN]$"));

        return inpuString.equals("Y");
    }

    public static void main(String[] args) {
        GuessGame game = new GuessGame();

        do {
            game.runGame();
        } while (game.getChoiceContinue());
        System.out.println("\nThank you for your time! See you again!");

        // close stream after game is finished
        game.scanner.close();
    }
}

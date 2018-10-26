/**
 * A program that guesses at a number based on
 * a range provided by the user. Binary search
 * will be used to to guess the number, with
 * the user inputting if the guess is too low
 * or too high. Cheating will be checked
 * for, and violators will have their games
 * terminated.
 *
 * @author Elliott Ruebush
 */
import java.util.Scanner;
public class GuessingGame{
    public static void main (String args []){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the guessing game!");
        System.out.println("Choose a minimum number for the range");
        int min = userInput.nextInt();
        System.out.println("Choose a maximum number for the range");
        int max = userInput.nextInt();

        boolean guessed = false;
        int mid;
        String userAns;
        int turnCnt = 1;

        //Binary search that takes user inputs for determining if the number being searched for is lower or the guessed number
        while(!guessed){
            System.out.println(" \nNext turn...");
            mid = min + ((max - min) / 2);
            System.out.println("Is the number you're thinking of " + mid + "? (y / n)");
            userAns = userInput.next();
            if(userAns.equalsIgnoreCase("n")){
                System.out.println("Is the number the computer guessed higher(h) or lower(l) than the number you're thinking of?");
                userAns = userInput.next();
                if(userAns.equals("l")){
                    max = mid;
                }else if(userAns.equals("h")){
                    min = mid;
                }
                if(max - min < 1){
                    System.out.println("YOU DIRTY CHEATER... \nYou decided to play " + turnCnt + " turns. Then, you decided to CHEAT."
                            + "\nThere is only one available number left, and you said it's not your number...");
                    System.exit(0);
                }
            } else if(userAns.equalsIgnoreCase("y")) {
                System.out.println("The computer guessed your number in " + turnCnt + " turn(s). Good game.");
                guessed = true;
            }
            turnCnt++;
        }
    }
}
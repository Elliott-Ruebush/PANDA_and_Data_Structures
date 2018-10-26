/**
 * Reads two .txt files into two linked lists of integers(each representing a reversed number), which are then passed
 * into a method from the ListAdder class that adds them together.
 *
 * @author Elliott Ruebush
 *
 */
import java.util.Scanner;
import java.io.*;
public class InfinitititeAdder {
    public static void main(String args[]){
        try{
            //Initialize our scanners and linked lists for our inputs
            Node headOne = new Node();
            Node currentOne = headOne;
            Scanner scanOne = new Scanner(new BufferedReader(new FileReader("ifnums1.txt")));
            while(scanOne.hasNextInt()){
                currentOne.setData(scanOne.nextInt());
                currentOne.setNext(new Node());
                currentOne = currentOne.getNext();
            }
            Node headTwo = new Node();
            Node currentTwo = headTwo;
            Scanner scanTwo = new Scanner(new BufferedReader(new FileReader("ifnums2.txt")));
            while(scanTwo.hasNextInt()){
                currentTwo.setData(scanTwo.nextInt());
                currentTwo.setNext(new Node());
                currentTwo = currentTwo.getNext();
            }

            //Practicing good practices
            ListAdder adder = new ListAdder();
            adder.run(headOne, headTwo);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Takes an alphabetically sorted array of strings read from a .txt file and uses the binary search algorithm to
 * find the user inputted word being searched for. Letter case will be ignored.
 *
 * @quthor Elliott Ruebush
 *
 */
public class BinarySearch{
    public static void main (String args []) {
        /* Kramer wants his example code to be used for the file reading
         * try{
        Scanner FileInput = new Scanner(new BufferedReader(new FileReader("bs.txt")));
        String[] strArr = new String[5];
        //Using arrays because the description didn't mention any use of ArrayList
        while(FileInput.hasNext()){
        if(i < strArr.length){
        strArr[i] = FileInput.next();
        }else{
        //Double size of array if there aren't any elements left.
        strArr = Arrays.copyOf(strArr, (2*strArr.length));                    
        }
        }
        } catch(Exception e){

        }*/
        try {
            //Kramer code begins
            Scanner scan = new Scanner(new BufferedReader(new FileReader("words.txt")));
            int size = 0;
            while (scan.hasNext()) {
                size++;
                scan.next();
            }
            String[] words = new String[size];
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("words.txt")));
            int count = 0;
            while (scan.hasNext()) {
                words[count] = scan.next();
                count++;
            }
            //Kramer code ends

            Arrays.sort(words); //Flexibility for different files not alphabetically organized
            Scanner userInput = new Scanner(System.in);
            System.out.println("What word are you searching for?");
            String searchWord = userInput.next();

            int min = 0;
            int max = words.length - 1;
            int mid;
            boolean searching = true;
            while (searching) {
                mid = min + ((max - min) / 2);
                //System.out.println("Words[mid]: " + words[mid]);
                if (words[mid].equalsIgnoreCase(searchWord)) {
                    System.out.println("The word you're searching for: '" + searchWord + "', is the " + (mid + 1) + rightEnding((mid + 1))
                            + " word in the file");
                    searching = false;
                    //Could change this to add a tracker for words that occur multiple times
                } else if (!(words[mid].equalsIgnoreCase(searchWord))) {

                    if (words[mid].compareToIgnoreCase(searchWord) > 0) {
                        max = mid - 1;
                    } else if (words[mid].compareToIgnoreCase(searchWord) < 0) {
                        min = mid + 1;
                    }
                    if (max < min) {
                        System.out.println("word was not found in the file...");
                        searching = false;
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("have a helpful error message, this program isn't workin'" + e.getMessage());
        }
    }

    /**
     * Finds the right ending for a number using by filtering out exceptions to rules and modding by 10
     *
     * @param num
     * @return a string ending corresponding a numeric order indicator ("st", "nd", "rd", "th")
     */
    private static String rightEnding(int num) {
        //Overcomplicated if statements are fun!!!!....
        if((num % 10 == 1) && !(num == 10) && !(num == 11) && !(num == 12)){
            return "st";
        }else if(num % 10 == 2){
            return "nd";
        }

        return (((num % 10) > 3) || (num == 0) || (num == 10) || (num == 11) || (num == 12)) ? "th" : "rd";
    }
}


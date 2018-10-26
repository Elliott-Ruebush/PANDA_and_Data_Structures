import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 */
public class InsertionSort{
    public static void main (String args []){
        try{
            Scanner FileInput = new Scanner(new BufferedReader(new FileReader("sortproject.txt")));
            String[] strArr = new String[5];

            int z = 0;
            while(FileInput.hasNext()){
                if(z < strArr.length){
                    strArr[z] = FileInput.next();
                }else{
                    //Double size of array if there aren't any elements left.
                    strArr = Arrays.copyOf(strArr, (2*(strArr.length - 1)));
                    strArr[z] = FileInput.next();
                }
                z++;
            }
            int nullCount = 0;
            for(int j = 0; j < strArr.length; j++){
                if(strArr[j] == null){
                    nullCount++;
                }
            }
            strArr = Arrays.copyOf(strArr, (strArr.length - nullCount));
            System.out.println(Arrays.toString(strArr));

            String temp;
            int y;
            for(int j = 1; j < (strArr.length); j++){

                temp = strArr[j];
                for(y = j - 1; y >= 0; y--){
                    strArr[y + 1] = strArr[y];
                }

                strArr[y + 1] = temp;

                System.out.println("Cycle " +  j + " " +  Arrays.toString(strArr));




            }

            System.out.println(Arrays.toString(strArr));
        } catch(Exception e){
            System.out.println("Something went wrong, " + e.getMessage());
        }

    }
}
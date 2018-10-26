import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 */
public class SelectionSort{
    public static void main (String args []){
        try{
            Scanner FileInput = new Scanner(new BufferedReader(new FileReader("sortprojectints.txt")));
            int[] intArr = new int[5];

            int i = 0;
            while(FileInput.hasNextInt()){
                if(i < intArr.length){
                    intArr[i] = FileInput.nextInt();
                }else{
                    //Double size of array if there aren't any elements left.
                    intArr = Arrays.copyOf(intArr, (2*(intArr.length - 1)));
                    intArr[i] = FileInput.nextInt();
                }
                i++;
            }
            int nullCount = 0;
            for(int j = 0; j < intArr.length; j++){
                if(intArr[j] == 0){
                    nullCount++;
                }
            }
            intArr = Arrays.copyOf(intArr, (intArr.length - nullCount));
            System.out.println(Arrays.toString(intArr));

            int minInd;
            int temp;
            for(int j = 0; j < intArr.length - 1; j++){
                minInd = j;
                for(int y = j + 1; y < intArr.length; y++){
                    if(intArr[y] < intArr[minInd]){
                        minInd = y;
                    }
                }
                if(intArr[minInd] != intArr[j]){
                    temp = intArr[j];
                    intArr[j] = intArr[minInd];
                    intArr[minInd] = temp;
                }
            }

            System.out.println("Sorted array below...");
            System.out.println(Arrays.toString(intArr));

        } catch(Exception e){
            System.out.println("Something went wrong, " + e.getMessage());
        }

    }
}
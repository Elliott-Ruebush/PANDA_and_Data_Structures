package MazeProject;


import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Elliott Ruebush
 */
public class MazeMain {
    public static void main(String args []){
            ArrayList<String> maze = readIn("maze.txt");
            MazeSolver SolverOne = new MazeSolver(maze);
            System.out.println("Testing printing...");
            SolverOne.printMaze();
            SolverOne.findSolutions();
    }

    /**
     * Reads in a .txt file to an arraylist maze.
     * (Would be best to have this function in another object, but submitting multiple objects on schoology is annoying.
     * Probably would be better to just put this code in the main if I'm not putting it in another method, but I'm not
     * sure what exactly to do.)
     * @param fileName
     * @return maze
     */
    public static ArrayList<String> readIn(String fileName){
        ArrayList<String> maze = new ArrayList<>();
        try {
            Scanner mazeIn = new Scanner(new BufferedReader(new FileReader(fileName)));
            //We made things harder for ourselves by using an arraylist instead of array and writing our own object for coordinates.
            for (int k = 0; mazeIn.hasNext(); k++) {
                maze.add(mazeIn.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return maze;
    }
}
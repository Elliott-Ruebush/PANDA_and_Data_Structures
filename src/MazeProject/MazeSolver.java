package MazeProject;
/**
 *
 * @author Elliott Ruebush
 */

import java.util.ArrayList;


public class MazeSolver {
    //We love class variables, so we use lots. This is OOP, not functional programming.
    private ArrayList<String> maze;
    private BetterPoint startPoint;
    private BetterPoint endPoint;
    private BetterPoint cur;
    private BetterPoint temp;
    private GenericStack<BetterPoint> solStack;

    /**
     * Constructs a MazeSolver object, needs to have maze passed for it to solve.
     *
     * @param maze
     */
    public MazeSolver(ArrayList<String> maze) {
        this.maze = maze;
    }

    /**
     * Prints out the maze.
     */
    public void printMaze() {
        for (String x : maze) {
            System.out.println(x);
        }
    }

    /**
     * Reads the data from the objects we used for the nodes in the stack into an arraylist, and outputs that arraylist
     * backwards to print out the order in which points were traversed.
     */
    public void printSolutions(){
        System.out.println("Printing solution(Zero-based coords)...");
        ArrayList<String> sol = new ArrayList<>();
        while (solStack.peek() != null) {
            sol.add(solStack.pop().print());
        }
        System.out.println("Start: ");
        for (int i = sol.size() - 1, k = 1; i >= 0; i--, k++) {
            System.out.println(k + ". " + sol.get(i));
        }
        System.out.print("End.");
    }

    /**
     * Using the provided start and end points, finds a path connecting the start and end points of a solvable maze.
     * Essentially implements a depth-first search and will solve any solvable maze, but will not find the quickest path.
     */
    public void findSolutions() {
        startPoint = findPoint(maze, "@");
        endPoint = findPoint(maze, "$");
        solStack = new GenericStack<BetterPoint>();
        temp = startPoint;
        solStack.push(temp);
        cur = startPoint;
        int itNum = 1;
        while (solStack.peek() != null && !(cur.equals(endPoint))) {
            cur = solStack.peek();
            System.out.println("\nIteration " + itNum + "...");
            itNum++;
            this.printMaze();
            if (hasOpenSpace()) {

            } else {
                cur = solStack.pop();
            }
        }
        if(solStack.peek() == null){
            System.out.println("This algorithm can't solve the maze...");
            return;
        }
        solStack.push(cur);
        printSolutions();
    }

    /**
     * Returns if a valid open space is available, and handles pushing of open points in the maze(from your current position)
     * to the solution stack.
     *
     * @return true
     */
    public boolean hasOpenSpace() {
        //This method is ugly because I decided to torture myself by not using a 2D array and doing dumb stuff.
        boolean isValid = false;
        //Could probably match with one regex instead of OR-ing two comparisons but java regexes are annoying to work with
        if (cur.getY() + 1 < maze.get(cur.getX()).length()) {
            if (maze.get(cur.getX()).substring(cur.getY() + 1, cur.getY() + 2).equals(".")
                    || maze.get(cur.getX()).substring(cur.getY() + 1, cur.getY() + 2).equals("$")) {
                StringBuilder tempBuild = new StringBuilder(maze.get(cur.getX()));
                tempBuild.setCharAt(cur.getY() + 1, '*');
                maze.set(cur.getX(), tempBuild.toString());
                temp = new BetterPoint(cur);
                temp.setY(temp.getY() + 1);
                solStack.push(temp);
                isValid = true;
            }
        }
        if (cur.getX() + 1 < maze.size()) {
            if (maze.get(cur.getX() + 1).substring(cur.getY(), cur.getY() + 1).equals(".")
                    || maze.get(cur.getX() + 1).substring(cur.getY(), cur.getY() + 1).equals("$")) {
                StringBuilder tempBuild = new StringBuilder(maze.get(cur.getX() + 1));
                tempBuild.setCharAt(cur.getY(), '*');
                maze.set(cur.getX() + 1, tempBuild.toString());
                temp = new BetterPoint(cur);
                temp.setX(temp.getX() + 1);
                solStack.push(temp);
                isValid = true;
            }
        }
        if (cur.getY() > 0) {
            if (maze.get(cur.getX()).substring(cur.getY() - 1, cur.getY()).equals(".")
                    || maze.get(cur.getX()).substring(cur.getY() - 1, cur.getY()).equals("$")) {
                StringBuilder tempBuild = new StringBuilder(maze.get(cur.getX()));
                tempBuild.setCharAt(cur.getY() - 1, '*');
                maze.set(cur.getX(), tempBuild.toString());
                temp = new BetterPoint(cur);
                temp.setY(temp.getY() - 1);
                solStack.push(temp);
                isValid = true;
            }
        }
        if (cur.getX() > 0) {
            if (maze.get(cur.getX() - 1).substring(cur.getY(), cur.getY() + 1).equals(".")
                    || maze.get(cur.getX() - 1).substring(cur.getY(), cur.getY() + 1).equals("$")) {
                StringBuilder tempBuild = new StringBuilder(maze.get(cur.getX() - 1));
                tempBuild.setCharAt(cur.getY(), '*');
                maze.set(cur.getX() - 1, tempBuild.toString());
                temp = new BetterPoint(cur);
                temp.setX(temp.getX() - 1);
                solStack.push(temp);
                isValid = true;
            }
        }
        return isValid;
    }

    /**
     * Takes a maze, and a String to find in the maze and returns a BetterPoint with the zero-based coordinates
     * of the String being searched for.
     *
     * @param maze
     * @param str
     * @return startPoint
     */
    public BetterPoint findPoint(ArrayList<String> maze, String str) {
        BetterPoint point = new BetterPoint();
        for (int k = 0; k < maze.size(); k++) {
            if (maze.get(k).contains(str)) {
                for (int i = 1; i < maze.get(k).length(); i++) {
                    if (maze.get(k).substring(i - 1, i).equals(str) || maze.get(k).substring(i).equals(str)) {
                        point.setLocation(k, i - 1);
                    }
                }
            }
        }
        System.out.println("Your Point(" + str + ")[with zero-based values] is: " + point.print());
        return point;
    }
}



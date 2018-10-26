
/**
 * Class with methods used for performing actions on the board and checking win conditions, no constructor is included
 * as construction of the board is only one line of code regardless, and I feel the construction would be redundant in
 * this project (A constructor would be of more use in a scenario where different board dimensions and properties would
 * be required in the same
 *
 * @author Elliott Ruebush
 * @version (a version number or a date)
 */
public class CFourBoard
{

    /**
     * Prints out 2D Array to the console
     * @param board
     */
    public static void printBoard(String[][] board){
        System.out.print("  0");
        for(int i = 0; i < board.length + 1; i++){
            System.out.print("  " + (i + 1));
        }
        System.out.println("");
        for(int i = 0; i < board.length; i++){
            System.out.print("  " + (i + 1) + " ");
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Changes all elements in a 2D array to " - "
     * @param board
     */
    public static void resetBoard(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int x = 0; x < board[i].length; x++){
                board[i][x] = " - ";
            }
        }
    }

    //These for loops should be simplifiable into a smaller number of loops
    /**
     * Method of the class CFourBoard that checks to see if any connect four win conditions have been satisfied
     *
     * @param board
     * @param sym
     * @param name
     * @return True if a win condition has been met, false if not
     */
    public static boolean checkWin(String[][] board, String sym, String name){
        //Given example code for UL to LR diagonals
        for(int startRow = 0; startRow < 3; startRow++) {
            for(int startCol = 0; startCol < 4; startCol++) {
                String check = board[startRow][startCol];
                if(check.equals(sym) && check.equals(board[startRow+  1][startCol+1]) &&
                        check.equals(board[startRow + 2][startCol + 2]) && check.equals(board[startRow + 3][startCol + 3])) {
                    System.out.println(name + " (" + sym + ") has won the game!");
                    return true;
                }
            }
        }
        //LL to UR diagonals (needs changed)
        for(int startRow = 0; startRow < 3; startRow++) {
            for(int startCol = 6; startCol >= 3; startCol--) {
                String check = board[startRow][startCol];
                if(check.equals(sym) && check.equals(board[startRow + 1][startCol - 1]) &&
                        check.equals(board[startRow + 2][startCol - 2]) && check.equals(board[startRow + 3][startCol - 3])) {
                    System.out.println(name + " (Color:" + sym + ") has won the game!");
                    return true;
                }
            }
        }
        //Horizontal
        for(int startRow = 0; startRow < 6; startRow++){
            for(int startCol = 0; startCol < 4; startCol++){
                String check = board[startRow][startCol];
                if(check.equals(sym) && check.equals(board[startRow][startCol + 1]) &&
                        check.equals(board[startRow][startCol + 2]) && check.equals(board[startRow][startCol + 3])) {
                    System.out.println(name + " (Color:" + sym + ") has won the game!");
                    return true;
                }
            }
        }
        //Vertical
        for(int startRow = 0; startRow < 3; startRow++){
            for(int startCol = 0; startCol < 7; startCol++){
                String check = board[startRow][startCol];
                if(check.equals(sym) && check.equals(board[startRow + 1][startCol]) &&
                        check.equals(board[startRow + 2][startCol]) && check.equals(board[startRow + 3][startCol])) {
                    System.out.println(name + " (Color:" + sym + ") has won the game!");
                    return true;
                }
            }
        }
        return false;
    }
}

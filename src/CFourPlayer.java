import java.util.Scanner;
/**
 * A class that is used for creating player ojects to store player data and for part of the steps of
 *
 * @author Elliott Ruebush
 * @version (a version number or a date)
 */
public class CFourPlayer
{
    public String name;
    public String pieceColor;
    public String colorSym;
    public static int pNumber = 0;

    /**
     * Constructor for player objects
     *
     * @param name
     * @param color
     */
    public CFourPlayer(String name, String color )
    {
        this.name = name;
        this.pieceColor = color;
        this.colorSym = (color.equalsIgnoreCase("white")) ? " W " : " B ";
    }

    /**
     * Method of the class CFourPlayer that allows a player to choose the connect four column in which they would like
     * to put their piece/make their move.
     *
     * @param board
     * @return The board with a player's chosen move applied
     */
    public String[][] makeAMove(String[][] board, int col)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\n" + this.name + "'s turn: What row would you like to play in?");
        if(col == -1){
            col = userInput.nextInt();
        }
        for(int i = board.length; i > 0; i--){
            for(int j = board[i - 1].length; j > 0; j--){
                if(board[i - 1][col - 1].equals(" - ")){
                    board[i - 1][col - 1] = this.colorSym;
                    return board;
                }
            }
        }
        System.out.println("Something went wrong, try again...");
        return this.makeAMove(board, -1);
    }



}

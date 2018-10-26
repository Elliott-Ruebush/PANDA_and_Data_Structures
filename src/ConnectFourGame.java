import java.util.Scanner;

public class ConnectFourGame{
    public static void main (String args []){
        boolean running = true;
        while(running){
            String[][] board = new String[6][7];
            CFourBoard.resetBoard(board);

            CFourBoard.printBoard(board);

            Scanner pScanner = new Scanner(System.in);
            System.out.println("Are 1 or 2 players playing?");
            CFourPlayer.pNumber = pScanner.nextInt();

            if(CFourPlayer.pNumber == 1){
                System.out.println("What is player one's name?");
                String nOne = pScanner.next();
                System.out.println("What color will player one be playing as? (white / black)");
                String cOne = pScanner.next();

                CFourPlayer POne = new CFourPlayer(nOne, cOne);
                String botName = Integer.toString((int) (Math.random()* 10000));
                String botColor = (cOne.equalsIgnoreCase("white")) ? "black" : "white";
                CFourPlayer BotOne = new CFourPlayer("Rando-bot#" + botName, botColor);
                System.out.println("Welcome to Connect Four " + POne.name + "(P1). You will be playing vs. "
                        + BotOne.name);
                boolean playing = true;
                int botCol;
                CFourBoard.printBoard(board);
                while(playing){
                    board = POne.makeAMove(board, -1);
                    System.out.println("P1 makes a move... ");
                    CFourBoard.printBoard(board);
                    playing = !CFourBoard.checkWin(board, POne.colorSym, POne.name);
                    if(playing) {
                        botCol = (int) ((Math.random() * 7) + 1);
                        board = BotOne.makeAMove(board, botCol);
                        System.out.println("Bot makes a move... ");
                        CFourBoard.printBoard(board);
                        playing = !CFourBoard.checkWin(board, BotOne.colorSym, BotOne.name);
                    }
                }
            }else if(CFourPlayer.pNumber == 2){
                System.out.println("What is player one's name?");
                String nOne = pScanner.next();
                System.out.println("What color will player one be playing as? (white / black)");
                String cOne = (pScanner.next().equalsIgnoreCase("white")) ? "white" : "black";
                System.out.println("What is player two's name?");
                String nTwo = pScanner.next();
                String cTwo = (cOne.equalsIgnoreCase("white")) ? "black" : "white";

                CFourPlayer POne = new CFourPlayer(nOne, cOne);

                CFourPlayer PTwo = new CFourPlayer(nTwo, cTwo);

                System.out.println("Welcome to Connect Four " + POne.name + "(P1, Color: " + POne.pieceColor + ") and "
                        + PTwo.name + "(P2, Color: " + PTwo.pieceColor +")");

                boolean playing = true;
                System.out.println();
                CFourBoard.printBoard(board);
                while(playing){
                    board = POne.makeAMove(board, -1);
                    System.out.println("P1 makes a move... ");
                    CFourBoard.printBoard(board);
                    playing = !CFourBoard.checkWin(board, POne.colorSym, POne.name);
                    if(playing) {
                        board = PTwo.makeAMove(board, -1);
                        System.out.println("P2 makes a move... ");
                        CFourBoard.printBoard(board);
                        playing = !CFourBoard.checkWin(board, PTwo.colorSym, PTwo.name);
                    }
                }
            }
            running = keepPlaying();
        }
    }
    /**
     * Prompts the player to input if they would like to keep playing or not
     * @param
     * @return true if the player wants to keep playing(YES), false if they don't want to(NO)
     */
    public static boolean keepPlaying(){
        Scanner YesOrNo = new Scanner(System.in);
        System.out.println("\nWould you like to play again? (Yes / No)");
        String answer = YesOrNo.next();
        if(answer.equalsIgnoreCase("yes")){
            return true;
        }else if(answer.equalsIgnoreCase("no")){
            return false;
        }else{
            System.out.println("Invalid entry");
            return keepPlaying();
        }
    }
}



/**
 * Created by Elliott on 10/30/2016.
 */

    import java.util.Scanner;

    /**
     * @author Elliott Ruebush <ruebush.elliott@charterschool.org>
     */
//TO BE REWRITTEN LATER WITH PLAYER AND BOT CLASSES
    public class TicTacToe{
        public static void main (String args []){

            boolean running = true;
            while(running){
                running = menu();
            }
        }

        /**
         * Prints game information and menu options, taking input using Scanner
         * @param Nothing
         * @return true if the player wants to keep playing, false if they choose to exit
         */
        public static boolean menu(){
            String [][] gameBoard = new String [3][3];

            resetBoard(gameBoard);

            Scanner menuAnswer = new Scanner(System.in);
            System.out.println("\nWelcome to console tic-tac-toe, enter START if you want to play, enter EXIT to stop the program");//Add HELP if you feel like it, also add option for one or two player
            String selectedOption = menuAnswer.next();

            if(selectedOption.equalsIgnoreCase("START")){
                String[] playerArr = playerSelect();
                boolean keepGoing = runGame(gameBoard, playerArr.length, playerArr);
                if(keepGoing){
                    resetBoard(gameBoard);
                    return menu();
                }else{
                    System.out.println("\nExiting program...");
                    return false;
                }
            }else if(selectedOption.equalsIgnoreCase("EXIT")){
                return false;
            }else{
                System.out.println("Invalid Option: Please Re-enter");
                if(menu() == false){
                    System.out.println("\nExiting program...");
                    return false;
                }else{
                    System.out.println("\nExiting program...");
                    return true;
                }
            }
        }

        /**
         * Takes input for number of players and player names using Scanner, returns an array of the player name/s
         * @param Nothing
         * @return An array of players' names
         */
        public static String[] playerSelect(){
            Scanner playerScanner = new Scanner(System.in);
            System.out.println("Are 1 or 2 players playing?");
            int numOfPlayers = playerScanner.nextInt();
            if(numOfPlayers == 2){
                System.out.println("What is player one's name?");
                String playersOne = playerScanner.next();
                System.out.println("What is player two's name?");
                String playersTwo = playerScanner.next();
                System.out.println("Welcome to tic-tac-toe " + playersOne + "(P1) and " + playersTwo + "(P2)");
                String[] playersArr = {playersOne, playersTwo};
                return playersArr;
            }else if(numOfPlayers == 1){
                System.out.println("What is player one's name?");
                String playersOne = playerScanner.next();
                System.out.println("Welcome to tic-tac-toe " + playersOne + "(P1). You will be playing vs. randomPickBot.");
                String[] playersArr = {playersOne};
                return playersArr;
            }else{
                System.out.println("\nInvalid number of players, please select a valid number of 1 or 2...");
                menu();
            }

            return null;
        }

        /**
         * Prints out 2D Arrray
         * @param The tic tac toe board's 3x3 2D array
         * @return Nothing
         */
        public static void printBoard(String[][] board){
            System.out.print("  0");
            for(int i = 0; i < board.length; i++){
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
         * While loop that the game runs in that prompts player/s for coordinate input and/or makes an AI move
         * @param Tic tac toe board 2D array, the number of players, the array of player names
         * @return true if the player wants to keep playing, false if they want to exit
         */
        public static boolean runGame(String[][] board, int numOfPlayers, String[] players){
            int coordX;
            int coordY;
            boolean playingGame = true;
            while(playingGame){
                if(numOfPlayers == 1){
                    System.out.println("\n" + players[0] + "'s(P1) turn.");
                    printBoard(board);
                    Scanner userInput = new Scanner(System.in);
                    System.out.println("Input X coordinate (Number between 1 and 3)");
                    coordX = (userInput.nextInt()) - 1;
                    System.out.println("Input Y coordinate (Number between 1 and 3)");
                    coordY = (userInput.nextInt()) - 1;
                    if(board[coordY][coordX].equals(" - ")){
                        board[coordY][coordX] = " X ";
                    }else{
                        System.out.println("Doesn't work (You probably tried to play in an occupied space), bailing out...");
                        return false;
                    }

                    if(checkWin(board, " X ")){
                        System.out.println("\n" + players[0] + "(P1) has won! You beat the bot!");
                        return keepPlaying();
                    }
                    if(checkFinished(board)){
                        return keepPlaying();
                    }
                    System.out.println("\nAI makes a move...");
                    board = mediocreAiMove(board);
                    if(checkWin(board, " O ")){
                        System.out.println("\nThe AI has won! You were beaten by the bot...");
                        printBoard(board);
                        return keepPlaying();
                    }
                    if(checkFinished(board)){
                        return keepPlaying();
                    }
                }else if(numOfPlayers == 2){
                    System.out.println("\n" + players[0] + "'s(P1) turn.");
                    printBoard(board);
                    Scanner userInput = new Scanner(System.in);
                    System.out.println("Input X coordinate (Number between 1 and 3)");
                    coordX = (userInput.nextInt()) - 1;
                    System.out.println("Input Y coordinate (Number between 1 and 3)");
                    coordY = (userInput.nextInt()) - 1;
                    if(board[coordY][coordX].equals(" - ")){
                        board[coordY][coordX] = " X ";
                    }else{
                        System.out.println("Doesn't work(You probably tried to play in an occupied space), bailing out...");
                        return false;
                    }

                    if(checkWin(board, " X ")){
                        System.out.println("\n" + players[0] + "(P1) has won!");
                        printBoard(board);
                        return keepPlaying();
                    }
                    if(checkFinished(board)){
                        return keepPlaying();
                    }

                    System.out.println("\n" + players[1] + "'s(P2) turn.");
                    printBoard(board);
                    System.out.println("Input X coordinate (Number between 1 and 3)");
                    coordX = (userInput.nextInt()) - 1;
                    System.out.println("Input Y coordinate (Number between 1 and 3)");
                    coordY = (userInput.nextInt()) - 1;
                    if(board[coordY][coordX].equals(" - ")){
                        board[coordY][coordX] = " O ";
                    }else{
                        System.out.println("Doesn't work(You probably tried to play in an occupied space), bailing out...");
                        return false;
                    }

                    if(checkWin(board, " O ")){
                        System.out.println( "\n" + players[1] + "(P2) has won!");
                        return keepPlaying();
                    }
                    if(checkFinished(board)){
                        return keepPlaying();
                    }
                }
            }
            return false;
        }

        /**
         * Changes all elements in a 2D array to " - "
         * @param Any 2D array
         * @return Nothing
         */
        public static void resetBoard(String[][] board){
            for(int i = 0; i < board.length; i++){
                for(int x = 0; x < board[i].length; x++){
                    board[i][x] = " - ";
                }
            }
        }

        /**
         * rudimentary AI that looks at the board and checks if it can win, or if it has to block, otherwise it will play in the best available place
         * @param The tic tac toe board 2D array
         * @return The board changed to account for the AI's move
         */
        public static String[][] mediocreAiMove(String[][] board){
            //SO MANY IF STATEMENTS
            for(int i = 0; i < board.length; i++){
                //Statements for winning
                if((board[i][0].equals(" O ") && board[i][1].equals(" O ")) && checkIfFree(board[i][2])){
                    board[i][2] = " O ";
                    return board;
                }
                if((board[i][1].equals(" O ") && board[i][2].equals(" O ")) && checkIfFree(board[i][0])){
                    board[i][0] = " O ";
                    return board;
                }
                if(board[i][0].equals(" O ") && board[i][2].equals(" O ") && checkIfFree(board[i][1])){
                    board[i][1] = " O ";
                    return board;
                }
                if((board[0][i].equals(" O ") && board[1][i].equals(" O ")) && checkIfFree(board[2][i])){
                    board[2][i] = " O ";
                    return board;
                }
                if((board[1][i].equals(" O ") && board[2][i].equals(" O ")) && checkIfFree(board[0][i])){
                    board[0][i] = " O ";
                    return board;
                }
                if(board[0][i].equals(" O ") && board[2][i].equals(" O ") && checkIfFree(board[1][i])){
                    board[1][i] = " O ";
                    return board;
                }
                if((board[0][0].equals(" O ") && board[1][1].equals(" O ")) && checkIfFree(board[2][2])){
                    board[2][2] = " O ";
                    return board;
                }
                if((board[1][1].equals(" O ") && board[2][2].equals(" O ")) && checkIfFree(board[0][0])){
                    board[0][0] = " O ";
                    return board;
                }
            }

            for(int i = 0; i < board.length; i++){
                //Statements for blocking player win
                if((board[i][0].equals(" X ") && board[i][1].equals(" X ")) && checkIfFree(board[i][2])){
                    board[i][2] = " O ";
                    return board;
                }
                if((board[i][1].equals(" X ") && board[i][2].equals(" X ")) && checkIfFree(board[i][0])){
                    board[i][0] = " O ";
                    return board;
                }
                if((board[0][i].equals(" X ") && board[1][i].equals(" X ")) && checkIfFree(board[2][i])){
                    board[2][i] = " O ";
                    return board;
                }
                if((board[1][i].equals(" X ") && board[2][i].equals(" X ")) && checkIfFree(board[0][i])){
                    board[0][i] = " O ";
                    return board;
                }
                if((board[1][i].equals(" X ") && board[2][i].equals(" X ")) && checkIfFree(board[0][i])){
                    board[0][i] = " O ";
                    return board;
                }
                if(board[0][i].equals(" X ") && board[2][i].equals(" X ") && checkIfFree(board[1][i])){
                    board[1][i] = " O ";
                    return board;
                }
                if((board[0][0].equals(" X ") && board[1][1].equals(" X ")) && checkIfFree(board[2][2])){
                    board[2][2] = " O ";
                    return board;
                }
                if((board[1][1].equals(" X ") && board[2][2].equals(" X ")) && checkIfFree(board[0][0])){
                    board[0][0] = " O ";
                    return board;
                }
            }
            //Statements for playing if no win or block is available

            //Center
            if(checkIfFree(board[1][1])){
                board[1][1] = " O ";
                return board;
            }
            //Opposite corners
            for(int i = 0; i < board.length; i++){
                if(!(i == 1) && board[i][0].equals(" X ") && checkIfFree(board[0][i])){
                    board[0][i] = " O ";
                    return board;
                }
                if(!(i == 1) && board[0][i].equals(" X ") && checkIfFree(board[i][0])){
                    board[i][0] = " O ";
                    return board;
                }
                //Empty corners
                if(!(i == 1) && board[i][0].equals(" - ")){
                    board[i][0] = " O ";
                    return board;
                }
                if(!(i == 1) && board[0][i].equals(" - ")){
                    board[0][i] = " O ";
                    return board;
                }
            }

            //Empty sides(too lazy to do the if statement, so will just do any left over side)
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j].equals(" - ")){
                        board[i][j] = " O ";
                        return board;
                    }
                }
            }
            System.out.println("Error: AI unable to make a move...");
            return board;
        }

        /**
         * Checks to see if the player/ai who last played has won the game with that move
         * @param tic tac toe board 2D array, symbol of the player who last went
         * @return true if the player whose symbol was supplied has won, false if win conditions are not met
         */
        public static boolean checkWin(String[][] board, String playerSymbol){
            for(int i = 0; i < board.length; i++){
                if(board[i][0].equals(playerSymbol) && board[i][1].equals(playerSymbol) && board[i][2].equals(playerSymbol)) {
                    return true;
                }

                if(board[0][i].equals(playerSymbol) && board[1][i].equals(playerSymbol) && board[2][i].equals(playerSymbol)) {
                    return true;
                }

                if(board[0][0].equals(playerSymbol) && board[1][1].equals(playerSymbol) && board[2][2].equals(playerSymbol)) {
                    return true;
                }

                if(board[0][2].equals(playerSymbol) && board[1][1].equals(playerSymbol) && board[2][0].equals(playerSymbol)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Checks if the space supplied is available for being played on
         * @param An element of an array to be checked against the currently existing space
         * @return true if the space is free, false if it is not free
         */
        public static boolean checkIfFree(String checkedSpace){
            //changed method but not enough time to go back and change it in the AI's code, don't need this method at all
            return checkedSpace.equals(" - ");

        }

        /**
         * Prompts the player to input if they would like to keep playing or not
         * @param Nothing
         * @return true if the player wants to keep playing("YES"), false if they don't want to("NO")
         */
        public static boolean keepPlaying(){
            Scanner YesOrNo = new Scanner(System.in);
            System.out.println("\nWould you like to play again? ('YES' or 'NO')");
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

        /**
         * checks if the board has run out of viable spaces
         * @param board two dimensional array, the tic-tac-toe board
         * @return false if viable spaces remain, true if no viable spaces remain
         */
        public static boolean checkFinished(String[][] board){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j].equals(" - ")){
                        return false;
                    }
                }
            }
            printBoard(board);
            System.out.println("The game ends in a draw. No one wins.");
            return true;
        }
}

/**
 * Created by Elliott on 12/6/2016.
 * Monte Carlo sim for 10,000 dice rolls. Records the number of times each die total occurs.
 */
public class MonteCarloSim {
    public static void main (String args[]) {
        int dieOne;
        int dieTwo;
        int twos = 0; int threes = 0; int fours = 0; int fives = 0; int sixes = 0; int sevens = 0;
        int eights = 0; int nines = 0; int tens = 0; int elevens = 0; int twelves = 0;
        for (int i = 0; i < 10000; i++) {
            dieOne = (int) (Math.random() * 6) + 1;
            dieTwo = (int) (Math.random() * 6) + 1;
            switch(dieOne + dieTwo){
                case 2: twos++;
                    break;
                case 3: threes++;
                    break;
                case 4: fours++;
                    break;
                case 5: fives++;
                    break;
                case 6: sixes++;
                    break;
                case 7: sevens++;
                    break;
                case 8: eights++;
                    break;
                case 9: nines++;
                    break;
                case 10: tens++;
                    break;
                case 11: elevens++;
                    break;
                case 12: twelves++;
                    break;
                default: System.out.println("That doesn't add up...");
            }
        }
        System.out.println("Totals... \nTwos: " + twos + "\nThrees: " + threes + "\nFours: " + fours + "\nFives: " + fives
        + "\nSixes: " + sixes + "\nSevens: " + sevens + "\nEights: " + eights + "\nNines: " + nines + "\nTens: " + tens
        + "\nElevens: " + elevens + "\nTwelves: " + twelves);
    }
}

/*
 * Author: Zerone
 * Date: 2016-9-14
 *
 * This is a simple guess-number game, which will make a random number that
 * from 1 to 99 and gives players ten chances to guess.
 */

import javax.swing.JOptionPane;

public class Guess {
    public static void main(String[] args) {
        // Generate a random number from 1 to 99
        int ans = (int) (Math.random() * 99 + 1);

        int times = 10;         // The rest of chances
        int guessNum = 0;       // The number that players guess
        boolean win = false;    // Indicate if players wins

        // Show basic message
        JOptionPane.showMessageDialog(null, "Guess the Number (1-99)\n" +
                "You will have ten chances.\n");

        // When chances run out, the while loop terminates
        while (times > 0)  {
            //Prompt players to input a number and display the rest of chances
            String guess = JOptionPane.showInputDialog(null,
                    "Please input a number :", "You only have " + times + "chances");

            //If String doesn't contain a valid integer, solve the exception
            try {
                guessNum = Integer.parseInt(guess);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input !\n");
                continue; // Proceed with the next iteration of the loop
            }

            if (guessNum < ans) {
                JOptionPane.showMessageDialog(null, "Smaller than the answer !");
            } else if (guessNum > ans) {
                JOptionPane.showMessageDialog(null, "Larger than the answer !");
            }

            else {
                /* When guess the right number, assign win with true
                   and exit from the while loop */
                win = true;
                break;
            }
            --times; // Reduce the chances
        } // End while loop

        // Show the answer and data
        String message = String.format("The answer is %d\n" +
                "Guess times: %d", ans, 10 - times);
        if (win) {
            JOptionPane.showMessageDialog(null, "Good job !\n" + message);
        }
        else {
            JOptionPane.showMessageDialog(null, "Game over !\n" + message);
        }
    } // End main method
} //End class Guess


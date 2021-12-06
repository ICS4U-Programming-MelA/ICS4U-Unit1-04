// Copywright (c) 2021 Mel Aguoth All rights reserved.
//
// Created By: Mel Aguoth
// Date: December 6, 2021
/* Generates a random number between 1 and 6 which the user has to guess for. If the guess is
 * wrong, it displays as such, and when finished it will tell them how many tries it took.
 */
// Imports modules.
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class DiceGame {
  public static void main(String[] args) {

    // Declare variables.
    int counter = 0;
    int userNumber = 0;
    Random random = new Random();
    int randomInt = random.nextInt(7);

    // Introduce the program.
    System.out.print("This program has a random number between 1 and 6 which you have to guess for."
                   + " It will keep going until you get the right number, and upon guessing"
                   + " correctly, displays how many tries you took.");
    Scanner input = new Scanner(System.in);
    do {
      try {

        // Get the user's number.
        System.out.print("\n" + "Enter a number between 1 and 6: ");
        userNumber = input.nextInt();

        // Check and display if the user's number is correct or incorrect.
        if (userNumber < 1 || userNumber > 6) {
          System.out.print("\n" + userNumber + " is out of range. Please try again.");
        } else if (userNumber == randomInt) {
          System.out.print("\n" + "You guessed correctly! It took you " + (counter + 1)
                         + " attempt(s).");
          input.close();
          break;
        } else {
          if (userNumber > randomInt) {
            System.out.print("\n" + "You guessed too high. Please try again.");
          } else {
            System.out.print("\n" + "You guessed too low. Please try again.");
          }
        }

        // Increment the counter.
        counter = counter + 1;

        // Catch and display when the user's number is invalid.
      } catch (InputMismatchException e1) {
        System.out.print("\n" + "That isn't an integer. Please try again.");
        counter = counter + 1;
        input.reset();
        input.next();
      }
    } while (userNumber != randomInt);
    System.out.print("\n");
  }
}

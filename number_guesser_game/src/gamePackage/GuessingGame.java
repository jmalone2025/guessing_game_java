package gamePackage;

import java.util.Scanner;

/**
 * Creates a number guessing game between 1-100, giving hints to the player.
 * 
 * @author jmalone2025
 */
public class GuessingGame {

	public static void main(String[] args) {
		int computerNumber; // NEW
		int userAnswer; // NEW
		int count = 1;
		int highestScore;
		boolean gameOver = false;

		while (gameOver == false) {
			computerNumber = (int) (Math.random() * 100 + 1); // First: at the end of the current loop, both numbers are
																// the same;
			userAnswer = 0; // you need to reset both of them at the beginning of the next loop
			highestScore = 0;

			while (userAnswer != computerNumber) {
				System.out.println("Enter a number between 1-100 to guess!");
				Scanner scanner = new Scanner(System.in);
				userAnswer = scanner.nextInt();
				count++;

				if (userAnswer == computerNumber) {
					System.out.println("You got it! It took you " + count + " turns!");
					if (userAnswer > highestScore) {
						highestScore = userAnswer;
					}
				} else if (userAnswer < computerNumber) {
					System.out.println("Your guess was lower than the number!");
				} else if (userAnswer > computerNumber) {
					System.out.println("Your guess was higher than the number!");
				}
			}
			System.out.println("Play again? y/n");
			Scanner playAgain = new Scanner(System.in);
			char yesOrNo = playAgain.next().charAt(0);
			if (yesOrNo == 'n') { // Second: my theory is that NONE of the branches of this if-statement was being
									// reached, so the reason it kept
									// working was because gameOver was never true. Instead, you were trying to
									// compare "n\n" (string of n with newline) to the string "n",
									// which obviously isn't going to match. I think you need to compare the
									// characters together.
				gameOver = true;
			} else if (yesOrNo == 'y') { // Third of all: it helps to keep things like this branched, also consider
											// adding a general else statement that asks the question again.
											// You could also condense this into a ternary statement
				gameOver = false;
			}
		}

	}
}

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;

        do {
            int randomNumber = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A random number between " + RANGE_START + " and " + RANGE_END + " has been generated.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    score += (MAX_ATTEMPTS - attempts + 1); // Higher score for fewer attempts
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    System.out.println("It took you " + attempts + " attempts.");
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}

package Encryptrix.task1;
import java.util.Random;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int rounds = 0;
        while (true) {
            int attempts = playGame(scanner);
            totalScore += attempts;
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("Thank you for playing! You played " + rounds + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;

        System.out.println("Welcome to the Number Game!");
        System.out.println("I have generated a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the correct number " + numberToGuess + " in " + attempts + " attempts.");
                break;
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
        }

        return attempts;
    }
}

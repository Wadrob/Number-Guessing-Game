package cli;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGameCLI {

    private final Scanner scanner;

    public NumberGuessingGameCLI() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int number = ThreadLocalRandom.current().nextInt(1, 101);

        System.out.println("""
                Welcome to the Number Guessing Game!
                I'm thinking of a number between 1 and 100.
                                
                Please select the difficulty level:
                1. Easy (10 chances)
                2. Medium (5 chances)
                3. Hard (3 chances)
                """);

        while (true) {
            System.out.println("Enter your choice:");
            int choice;

            try {
                choice = checkChoice(scanner.nextInt());
            } catch (InputMismatchException ex) {
                System.out.println("Choice must be a number");
                scanner.nextLine();
                continue;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> game("Easy", 10, number);
                case 2 -> game("Medium", 5, number);
                case 3 -> game("Hard", 3, number);
            }

            break;
        }
    }

    private void game(String difficulty, int maxAttempts, int number) {

        System.out.printf("Great! You have selected the %s difficulty level. Let's start the game! %n", difficulty);

        int counter = 0;

        while (counter < maxAttempts) {
            System.out.print("Enter your guess:");
            int guess;

            try {
                guess = checkGuess(scanner.nextInt());
            } catch (InputMismatchException ex) {
                System.out.println("Guess must be a number");
                scanner.nextLine();
                counter++;
                continue;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                scanner.nextLine();
                counter++;
                continue;
            }

            counter++;

            if (guess == number) {
                System.out.printf("Congratulations! You guessed the correct number in %d attempts.%n", counter);
                return;
            } else if (guess > number) {
                System.out.printf("Incorrect! The number is less than %d.%n", guess);
            } else {
                System.out.printf("Incorrect! The number is greater than %d%n", guess);
            }
        }

        System.out.printf("Game over! Try again! The number was %d", number);
    }


    int checkGuess(int guess) {
        if (guess < 1 || guess > 100) {
            throw new IllegalArgumentException("Guess must be between 1 and 100");
        }

        return guess;
    }


    int checkChoice(int choice) {
        if (choice < 1 || choice > 3) {
            throw new IllegalArgumentException("Choice must be between 1 and 3");
        }

        return choice;
    }
}

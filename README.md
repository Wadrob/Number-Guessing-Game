# Number Guessing Game CLI

A simple command-line number guessing game written in Java.

The computer randomly selects a number between 1 and 100, and the player must guess it within a limited number of attempts.

## Features

- Random number generation between 1 and 100
- Three difficulty levels:
    - **Easy** — 10 attempts
    - **Medium** — 5 attempts
    - **Hard** — 3 attempts
- Input validation
- Feedback indicating whether the secret number is higher or lower
- Unit tests using JUnit 5

## Requirements

- Java 17 or newer
- Gradle (the included Gradle Wrapper can be used)

## How to Play

1. Start the application.
2. Select a difficulty level by entering `1`, `2`, or `3`.
3. Enter a number between 1 and 100.
4. Follow the hints to determine whether the secret number is higher or lower.
5. Guess the number before you run out of attempts!

## Technologies

- Java 17
- Gradle
- JUnit 5

## Project Status

This project was created as a beginner-friendly Java exercise for https://roadmap.sh/projects/number-guessing-game to practise control flow, input validation, exception handling, and unit testing.

package main;

import util.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int length = 0;
        int specialPatternLength = 0;
        boolean retry = true;

        PatternFinder patternFinder = new PatternFinder();  // Move PatternFinder instantiation outside the loop

        while (retry) {
            try {
                retry = false;

                System.out.println("Length of the random string that will be used in the rest of the program (between 100,000 and 1 billion):");
                length = getUserInputInRange(keyboard, 100000, 1000000000);

                System.out.println("Maximum length of the special patterns that the program looks for (between 3 and 15):");
                specialPatternLength = getUserInputInRange(keyboard, 3, 15);

                // Generate a random string
                String randomString = PatternFinder.randomStringGenerator(length);

                // Call the string miners to find special patterns
                PatternFinder.singletonMiner(randomString, specialPatternLength);

                PatternFinder.ArithmeticStringIncreasingMiner(randomString, specialPatternLength);

                PatternFinder.ArithmeticStringDecreasingMiner(randomString, specialPatternLength);

                PatternFinder.tripartiteStringMiner(randomString, specialPatternLength);

                PatternFinder.bipartiteStringMiner(randomString, specialPatternLength);

                PatternFinder.palindromeStringMiner(randomString, specialPatternLength);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers within the specified ranges.");
                retry = true;
            } catch (Exception exp) {
                System.out.println(exp.getMessage());
            }
        }
    }

    // Helper method to get user input within a specified range
    private static int getUserInputInRange(Scanner keyboard, int min, int max) throws NumberFormatException {
        int userInput = Integer.parseInt(keyboard.nextLine());  // Read the entire line to handle Enter key
        if (userInput < min || userInput > max) {
            throw new NumberFormatException();
        }
        return userInput;
    }
}

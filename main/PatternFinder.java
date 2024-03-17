package main;

import util.*;
import java.util.*;

public class PatternFinder {
    public static String randomStringGenerator(int length) {// generates a string made of randomly generated lowercase
        // letters
        Random random = new Random(System.nanoTime());
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = (char) ('a' + random.nextInt(26));
        return new String(array);
    }

    static void singletonMiner(String mine, int length) throws SingletonException{
         for (int start = 0; start < mine.length() - length; start++) {
             int i;
             for (i = start + 1; i < start + length; i++)
                 if (mine.charAt(i) != mine.charAt(i - 1))
                     break;
             if (i == start + length)
                 throw new SingletonException(mine.substring(start, start + length), start);
             }
         }
    public static void ArithmeticStringIncreasingMiner(String mine, int length) throws ArithmeticStringIncreasingException {
        int start = 0;
        while (start < mine.length()) {
            int end = start + 1;
            while (end < mine.length() && mine.charAt(end) == mine.charAt(end - 1) + 1) {
                end++;
            }
            int foundLength = end - start;
            if (foundLength == length) {
                throw new ArithmeticStringIncreasingException(mine.substring(start, end), start);
            }
            start = end;
        }
    }
    public static void ArithmeticStringDecreasingMiner(String mine, int length) throws ArithmeticStringDecreasingException {
        int start = 0;
        while (start < mine.length()) {
            int end = start + 1;
            while (end < mine.length() && mine.charAt(end) == mine.charAt(end - 1) - 1) {
                end++;
            }
            int foundLength = end - start;
            if (foundLength == length) {
                throw new ArithmeticStringDecreasingException(mine.substring(start, end), start);
            }
            start = end;
        }
    }
    public static void tripartiteStringMiner(String mine, int length) throws TripartiteStringException {
        int stringLength = mine.length();

        // Check if length is divisible by 3
        if (length % 3 != 0) {
            return;
        }

        int partLength = length / 3; // The length of each part of the tripartite string

        // Ensure the string is long enough to potentially contain a tripartite string of the specified length
        if (stringLength < length) {
            return;
        }

        for (int start = 0; start <= stringLength - length; start++) {
            String firstPart = mine.substring(start, start + partLength);
            String secondPart = mine.substring(start + partLength, start + partLength * 2);
            String thirdPart = mine.substring(start + partLength * 2, start + length);

            if (firstPart.equals(secondPart) && firstPart.equals(thirdPart)) {
                throw new TripartiteStringException(mine.substring(start, start + length), start);
            }
        }
    }

    public static void bipartiteStringMiner(String mine, int length) throws BipartiteStringException {
        int stringLength = mine.length();

        // Check if length is divisible by 2
        if (length % 2 != 0) {
            return;
        }

        int partLength = length / 2; // The length of each part of the bipartite string

        // Ensure the string is long enough to potentially contain a bipartite string of the specified length
        if (stringLength < length) {
            return;
        }

        for (int start = 0; start <= stringLength - length; start++) {
            String firstPart = mine.substring(start, start + partLength);
            String secondPart = mine.substring(start + partLength, start + length);

            if (firstPart.equals(secondPart)) {
                throw new BipartiteStringException(mine.substring(start, start + length), start);
            }
        }
    }
    public static void palindromeStringMiner(String mine, int total) throws PalindromeStringException {
        int length = mine.length();

        while (total > 0) {
            for (int start = 0; start <= length - total; start++) {
                if (isPalindrome(mine, start, start + total - 1)) {
                    throw new PalindromeStringException(mine.substring(start, start + total), start);
                }
            }
            total--;
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

}

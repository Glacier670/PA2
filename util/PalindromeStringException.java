package util;

public class PalindromeStringException extends Exception{//e.g. "level", "asdfgfdsa", "lol"
    private String PalindromeString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return PalindromeString + " is a palindrome string that is found at index " + (occurrenceIndex + 1) + "!";
    }
    public PalindromeStringException(String palindromeString, int index) {
        this.PalindromeString = palindromeString;
        occurrenceIndex = index;
    }
    public String getPattern() {
        return PalindromeString;
    }
}


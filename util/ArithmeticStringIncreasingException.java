package util;

public class ArithmeticStringIncreasingException extends Exception{//e.g. "abcdefg", "jklm", "xy"
    private String ArithmeticStringIncreasing;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return ArithmeticStringIncreasing + " is a increasing arithmetic string that is found at index " + (occurrenceIndex + 1) + "!";
    }
    public ArithmeticStringIncreasingException(String arithmeticStringIncreasing, int index) {
        this.ArithmeticStringIncreasing = arithmeticStringIncreasing;
        occurrenceIndex = index;
    }
    public String getPattern() {
        return ArithmeticStringIncreasing;
    }
}


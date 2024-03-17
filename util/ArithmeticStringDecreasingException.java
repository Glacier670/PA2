package util;

public class ArithmeticStringDecreasingException extends Exception{//e.g. "gfedcba", "zyxw", "ut"
    private String ArithmeticStringDecreasing;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return ArithmeticStringDecreasing + " is a decreasing arithmetic string that is found at index " + (occurrenceIndex + 1) + "!";
    }
    public ArithmeticStringDecreasingException(String arithmeticStringDecreasing, int index) {
        this.ArithmeticStringDecreasing = arithmeticStringDecreasing;
        occurrenceIndex = index;
    }
    public String getPattern() {
        return ArithmeticStringDecreasing;
    }
}


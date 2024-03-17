package util;

public class TripartiteStringException extends Exception{//e.g. "bobbobbob", "mmm", "smokesmokesmoke"
    private String TripartiteString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return TripartiteString + " is a bipartite string that is found at index " + (occurrenceIndex + 1) + "!";
    }
    public TripartiteStringException(String tripartiteString, int index) {
        this.TripartiteString = tripartiteString;
        occurrenceIndex = index;
    }
    public String getPattern() {
        return TripartiteString;
    }
}


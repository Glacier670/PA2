package util;

public class BipartiteStringException extends Exception{//e.g. "levellevel", "axeaxe", "nn"
    private String BipartiteString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return BipartiteString + " is a bipartite string that is found at index " + (occurrenceIndex + 1) + "!";
    }
    public BipartiteStringException(String bipartiteString, int index) {
        this.BipartiteString = bipartiteString;
        occurrenceIndex = index;
    }

    public String getPattern() {
        return BipartiteString;
    }
}


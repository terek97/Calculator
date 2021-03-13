package acttions;

public class Division implements Calculating {
    @Override
    public int makeAction(int first, int second) {
        return first / second;
    }
}

// ДЕЛЕНИЕ
package calculator;

public class DividerImpl implements Divider {

    private final Multiplier multiplier;
    private final Subtractor subtractor;

    public DividerImpl(Multiplier multiplier, Subtractor subtractor) {
        this.multiplier = multiplier;
        this.subtractor = subtractor;
    }

    @Override
    public int divide(int a, int b) {
        return 0;
    }

    @Override
    public int remainder(int a, int b) {
        return 0;
    }
}

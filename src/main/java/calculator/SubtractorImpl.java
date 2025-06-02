package calculator;

public class SubtractorImpl implements Subtractor {

    private final Flipper flipper;
    private final Adder adder;

    public SubtractorImpl(Flipper flipper, Adder adder) {
        this.flipper = flipper;
        this.adder = adder;
    }

    @Override
    public int subtract(int a, int b) {
        b = flipper.flip(b);

        return adder.add(a,b);
    }
}

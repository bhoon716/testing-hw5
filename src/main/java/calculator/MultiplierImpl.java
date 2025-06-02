package calculator;

public class MultiplierImpl implements Multiplier {

    private final Flipper flipper;
    private final Adder adder;

    public MultiplierImpl(Flipper flipper, Adder adder) {
        this.flipper = flipper;
        this.adder = adder;
    }

    @Override
    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        boolean isNegative = false;
        if(a < 0) {
            isNegative = true;
            a = flipper.flip(a);
        }
        if(b < 0) {
            isNegative = !isNegative;
            b = flipper.flip(b);
        }

        int result = 0;
        for (int i = 0; i < b; i++) {
            result = adder.add(result, a);
        }

        return isNegative ? flipper.flip(result) : result;
    }
}

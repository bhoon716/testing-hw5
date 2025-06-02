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
        if(b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없음.");
        }

        int q = 0;
        while(a >= 0) {
            a = subtractor.subtract(a, b);
            if(a < 0) {
                break;
            }
            q++;
        }
        return q;
    }

    @Override
    public int remainder(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없음.");
        }

        int d = divide(a, b);

        return a - (multiplier.multiply(d, b));
    }
}

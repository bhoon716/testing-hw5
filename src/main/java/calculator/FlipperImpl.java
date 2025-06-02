package calculator;

public class FlipperImpl implements Flipper {

    @Override
    public int flip(int a) {
        // 1의 보수 + 1 = 2의 보수
        return ~a + 1;
    }
}

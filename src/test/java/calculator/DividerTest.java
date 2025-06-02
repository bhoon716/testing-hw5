package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DividerTest {

    Flipper flipper = new FlipperImpl();
    Adder adder = new AdderImpl();
    Multiplier multiplier = new MultiplierImpl(flipper, adder);
    Subtractor subtractor = new SubtractorImpl(flipper, adder);
    Divider divider = new DividerImpl(multiplier, subtractor);

    @Test
    @DisplayName("나누기 테스트")
    void testDivide() {
        //given
        int a = 10;
        int b = 3;
        int expected = 3;

        //when
        //then
        assertThat(divider.divide(a, b)).isEqualTo(expected);
    }

    @Test
    @DisplayName("나머지 연산 테스트")
    void testRemainder() {
        //given
        int a = 10;
        int b = 3;
        int expected = 1;

        //when
        //then
        assertThat(divider.remainder(a, b)).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나누면 실패")
    void divideByZeroTest() {
        //given
        int a = 10;
        int b = 0;

        //when
        //then
        assertThatThrownBy(() -> divider.divide(a, b))
                .isInstanceOf(ArithmeticException.class);
    }
}
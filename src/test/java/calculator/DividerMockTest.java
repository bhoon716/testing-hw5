package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DividerMockTest {

    Divider divider;
    Multiplier multiplier;
    Subtractor subtractor;

    @BeforeEach
    void setUp() {
        multiplier = mock(Multiplier.class);
        subtractor = mock(Subtractor.class);
        divider = new DividerImpl(multiplier, subtractor);
    }

    @Test
    @DisplayName("나누기 Mock 테스트")
    void testDivide() {
        //given
        int a = 10;
        int b = 3;
        int expected = 3;

        //when
        when(subtractor.subtract(10, 3)).thenReturn(7);
        when(subtractor.subtract(7, 3)).thenReturn(4);
        when(subtractor.subtract(4, 3)).thenReturn(1);
        when(subtractor.subtract(1, 3)).thenReturn(-2);

        //then
        assertThat(divider.divide(a, b)).isEqualTo(expected);
    }

    @Test
    @DisplayName("나머지 연산 Mock 테스트")
    void testRemainder() {
        //given
        int a = 10;
        int b = 3;
        int expected = 1;

        //when
        when(subtractor.subtract(10, 3)).thenReturn(7);
        when(subtractor.subtract(7, 3)).thenReturn(4);
        when(subtractor.subtract(4, 3)).thenReturn(1);
        when(subtractor.subtract(1, 3)).thenReturn(-2);
        when(multiplier.multiply(3, 3)).thenReturn(9);

        //then
        assertThat(divider.remainder(a, b)).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나누면 실패 Mock")
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
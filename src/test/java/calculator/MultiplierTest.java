package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MultiplierTest {

    Flipper flipper = new FlipperImpl();
    Adder adder = new AdderImpl();
    Multiplier multiplier = new MultiplierImpl(flipper, adder);

    @ParameterizedTest
    @CsvSource(value = {
            "2, 3, 6",
            "-2, 3, -6",
            "-2, -3, 6"
    })
    @DisplayName("곱셈 테스트")
    void testMultiply(int a, int b, int expected) {

        assertThat(multiplier.multiply(a, b)).isEqualTo(expected);
    }
}
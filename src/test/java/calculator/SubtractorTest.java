package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SubtractorTest {

    Flipper flipper = new FlipperImpl();
    Adder adder = new AdderImpl();
    Subtractor subtractor = new SubtractorImpl(flipper, adder);

    @ParameterizedTest
    @CsvSource(value = {
            "10, 3, 7",
            "1, 5, -4"
    })
    @DisplayName("뺄셈 테스트")
    void testSubtract(int a, int b, int expected) {

        assertThat(subtractor.subtract(a, b)).isEqualTo(expected);
    }
}
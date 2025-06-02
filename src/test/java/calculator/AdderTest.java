package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AdderTest {

    Adder adder = new AdderImpl();

    @ParameterizedTest
    @CsvSource(value = {
            "2, 5, 7",
            "-2, 5, 3"
    })
    @DisplayName("덧셈 테스트")
    void testAdd(int a, int b, int expected) {
        //given
        //when
        //then
        assertThat(adder.add(a, b)).isEqualTo(expected);
    }
}
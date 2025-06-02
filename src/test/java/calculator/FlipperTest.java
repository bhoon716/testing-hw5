package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FlipperTest {

    Flipper flipper = new FlipperImpl();

    @ParameterizedTest
    @CsvSource(value = {
            "-5, 5",
            "5, -5",
            "0, 0"
    })
    @DisplayName("부호 반전 테스트")
    void testFlipper(int a, int expected) {
        //given
        //when
        //then
        assertThat(flipper.flip(a)).isEqualTo(expected);
    }
}
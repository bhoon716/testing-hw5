package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SubtractorMockTest {

    Subtractor subtractor;
    Flipper flipper;
    Adder adder;

    @BeforeEach
    void setUp() {
        flipper = mock(Flipper.class);
        adder = mock(Adder.class);
        subtractor = new SubtractorImpl(flipper, adder);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10, 3, 7",
            "1, 5, -4"
    })
    @DisplayName("뺄셈 테스트")
    void testSubtract(int a, int b, int expected) {
        //given
        //when
        when(flipper.flip(3)).thenReturn(-3);
        when(flipper.flip(5)).thenReturn(-5);
        when(adder.add(10, -3)).thenReturn(7);
        when(adder.add(1, -5)).thenReturn(-4);

        //then
        assertThat(subtractor.subtract(a, b)).isEqualTo(expected);
    }
}
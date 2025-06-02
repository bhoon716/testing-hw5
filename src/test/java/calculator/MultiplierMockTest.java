package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MultiplierMockTest {

    Multiplier multiplier;
    Flipper flipper;
    Adder adder;

    @BeforeEach
    void setUp() {
        flipper = mock(Flipper.class);
        adder = mock(Adder.class);
        multiplier = new MultiplierImpl(flipper, adder);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 3, 6",
            "-2, 3, -6",
            "-2, -3, 6"
    })
    @DisplayName("곱셈 테스트")
    void testMultiply(int a, int b, int expected) {
        //given
        //when
        when(adder.add(0, 2)).thenReturn(2);
        when(adder.add(2, 2)).thenReturn(4);
        when(adder.add(4, 2)).thenReturn(6);
        when(flipper.flip(-2)).thenReturn(2);
        when(flipper.flip(-3)).thenReturn(3);
        when(flipper.flip(6)).thenReturn(-6);
        when(flipper.flip(-6)).thenReturn(6);

        //then
        assertThat(multiplier.multiply(a, b)).isEqualTo(expected);
    }
}
package sample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class that tests the validity of conversion form roman to numeral
 */
class RomanNumeralTest {
    private RomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }

    @Test
    void singleNumber() {
        int result = roman.convert("I");
        assertEquals(1, result);
    }
}
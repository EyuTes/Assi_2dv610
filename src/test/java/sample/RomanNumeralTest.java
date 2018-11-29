package sample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("For single roman number")
    @Test
    void singleNumber() {
        int result = roman.convert("I");
        assertEquals(1, result);
    }
    @DisplayName("For roman number with multiple digit")
    @Test
    void NumberWithMultipleDigits() {
        int result = roman.convert("VIII");
        assertEquals(8, result);
    }
    @DisplayName("For roman number with different digit")
    @Test
    void numberWithDifferentDigits() {
        int result = roman.convert("XVI");
        assertEquals(16, result);
    }
    @DisplayName("For roman number with subtractive notation")
    @Test
    void numberWithSubtractiveNotations() {
        int result = roman.convert("IX");
        assertEquals(9, result);
        //Assertions.assertEquals(9, result);
    }
    @DisplayName("For roman number with digit & subtractive notation")
    @Test
    void numberWithDigitAndSubtractiveNotaions() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XIX");
        assertEquals(19, result);
    }
    @DisplayName("For roman number with subtractive notation")
    @Test
    public void numberWithSubtractiveNotation() {
        int result = roman.convert("IV");
        assertEquals(4, result);
    }
    @DisplayName("For roman number with out subtractive notation")
    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.convert("XLIV");
        assertEquals(44, result);
    }
}
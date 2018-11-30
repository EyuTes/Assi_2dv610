package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator=new Calculator();
    }

    @DisplayName("Get sum of Array of integer using assert all")
    @Test

     void testValidSumOfNumbers() {
        assertEquals(10,calculator.sum(new int[]{1,2,3,4}));
    }


}
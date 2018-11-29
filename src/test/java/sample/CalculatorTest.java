package sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator=new Calculator();
    }
    @Test
    void getSumOfNumbers() {
        int actual=calculator.sum(1,4);
        int expected=5;
        Assertions.assertEquals(5,actual);
    }
}
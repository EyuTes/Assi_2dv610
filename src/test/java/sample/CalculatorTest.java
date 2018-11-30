package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator=new Calculator();
    }

    @DisplayName("Get sum of Array of integer using assert all")
    @Test

     void getSumOfNumbers() {
        assertAll("sums of different integers",
                ()->assertEquals(10,calculator.sum(new int[]{1,2,3,4})),
                ()->assertEquals(40,calculator.sum(new int[]{9,12,15,4})),
                ()->assertEquals(400,calculator.sum(new int[]{200,100,50,40,10,0})),
                ()->assertEquals(8,calculator.sum(new int[]{-10,20,-50,40,0,8}))
        );

    }


}
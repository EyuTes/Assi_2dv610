package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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

     void testValidSumOfNumbers() {
        assertAll("sums of different integers",
                ()->assertEquals(10,calculator.sum(new int[]{1,2,3,4})),
                ()->assertEquals(40,calculator.sum(new int[]{9,12,15,4})),
                ()->assertEquals(400,calculator.sum(new int[]{200,100,50,40,10,0})),
                ()->assertEquals(8,calculator.sum(new int[]{-10,20,-50,40,0,8}))
        );
    }
    @DisplayName("Get even numbers filtered form the list")
    @Test
    void getSumOfEvenFilteredNumbers() {

        Predicate<Integer> even=i -> i %2== 0;
        List<Integer> integerList=Arrays.asList(1,10,200,101,-1,0);
        List<Integer> actual=calculator.filters(integerList,even);
        List<Integer> expected=Arrays.asList(10,200,0);
        assertAll("even numbers filtered",
                ()->assertEquals(expected,actual)
        );
    }

}
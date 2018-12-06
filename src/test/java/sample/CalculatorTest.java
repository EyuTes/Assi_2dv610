package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator=new Calculator();
    }

    @DisplayName("Test Not implemented sum()")
    @Test
    void testNotImplementedSum(){
        assertThrows(NotImplementedException.class, () -> {
            calculator.sum(3,5);
        });
    }
    @DisplayName("Test implemented sum() with parameterized")
    @ParameterizedTest
    @CsvSource({
            "1, 12, 12",
            "2, 6, 12",
            "3, 4, 12"
    })
    @Test
    void testSum(int num1, int num2, int sum){
        int actual=calculator.product(num1,num2);
        assertEquals(actual,sum);
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
    @DisplayName("Get different types numbers filtered form the list based on the criteria")
    @Test
    void getSumOfEvenFilteredNumbers() {

        Predicate<Integer> even=i -> i %2== 0;
        Predicate<Integer> odd=i -> i %2!= 0;
        Predicate<Integer> positive= i -> i > 0;
        Predicate<Integer> negative= i -> i < 0;

        List<Integer> integerList=Arrays.asList(1,10,200,101,-1,0);

        List<Integer> expectedEven=Arrays.asList(10,200,0);
        List<Integer> expectedOdd=Arrays.asList(1,101,-1);
        List<Integer> expectedPositive=Arrays.asList(1,10,200,101);
        List<Integer> expectedNegative=Arrays.asList(-1);

        assertAll("Filtered numbers based on the predicate",
                ()->assertEquals(expectedEven,calculator.filters(integerList,even)),
                ()->assertEquals(expectedOdd,calculator.filters(integerList,odd)),
                ()->assertEquals(expectedPositive,calculator.filters(integerList,positive)),
                ()->assertEquals(expectedNegative,calculator.filters(integerList,negative))
        );
    }

}
package sample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumuberFinderTest {
    private NumuberFinder numberFinder;
    @BeforeEach
    void setUp() {
        numberFinder=new NumuberFinder();
    }
    @Test
    void getSmallestWhenArrayIsRandom() {
        numberFinder.find(new int[]{4,25,7,9});
        Assertions.assertEquals(4,numberFinder.getSmallest());
    }
    @Test
    void getSmallestWhenArrayIsInIncreasingOrder() {
        numberFinder.find(new int[]{1,7,12,18});
        Assertions.assertEquals(4,numberFinder.getSmallest());
    }
}
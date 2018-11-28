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
    void getLargestWhenArrayIsRandom() {
        numberFinder.find(new int[]{100,-12,0,45,1,-25});
        Assertions.assertEquals(100, numberFinder.getLargest());
    }
    @Test
    void getSmallestWhenArrayIncreasingOrder(){
        numberFinder.find(new int[]{-2,0,12,30,45});
        Assertions.assertEquals(-2, numberFinder.getSmallest());
    }
    @Test
    void getLargestWhenArrayIncreasingOrder(){
        numberFinder.find(new int[]{-2,0,12,30,45,120});
        Assertions.assertEquals(120, numberFinder.getLargest());
    }
    @Test
    void getLargestWhenArrayDecreasingOrder(){
        numberFinder.find(new int[]{300,100,12,5,0,-12,-90});
        Assertions.assertEquals(-90, numberFinder.getSmallest());
    }
    @Test
    void getSmallestWhenArrayDecreasingOrder(){
        numberFinder.find(new int[]{350,300,100,12,5,0,-12,-90});
        Assertions.assertEquals(350, numberFinder.getLargest());
    }


}
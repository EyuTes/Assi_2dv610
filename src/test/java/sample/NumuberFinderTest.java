package sample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

class NumuberFinderTest {
    private NumuberFinder numberFinder;
    @BeforeEach
    void setUp() {
        numberFinder=new NumuberFinder();
    }
    @DisplayName("Get the smallest number for random array")
    @Test
    void getSmallestWhenArrayIsRandom() {
        numberFinder.find(new int[]{4,25,7,9});
        Assertions.assertEquals(4,numberFinder.getSmallest());
    }
    @DisplayName("Get the largest number for random array")
    @Test
    void getLargestWhenArrayIsRandom() {
        numberFinder.find(new int[]{100,-12,0,45,1,-25});
        Assertions.assertEquals(100, numberFinder.getLargest());
    }
    @DisplayName("Get the smallest number when array is in increasing order")
    @Test
    void getSmallestWhenArrayIncreasingOrder(){
        numberFinder.find(new int[]{-2,0,12,30,45});
        Assertions.assertEquals(-2, numberFinder.getSmallest());
    }
    @DisplayName("Get the largest number when array is in increasing order")
    @Test
    void getLargestWhenArrayIncreasingOrder(){
        numberFinder.find(new int[]{-2,0,12,30,45,120});
        Assertions.assertEquals(120, numberFinder.getLargest());
    }
    @DisplayName("Get the largest number when array is in decreasing order")
    @Test
    void getLargestWhenArrayDecreasingOrder(){
        numberFinder.find(new int[]{300,100,12,5,0,-12,-90});
        Assertions.assertEquals(-90, numberFinder.getSmallest());
    }
    @DisplayName("Get the smallest number when array is in decreasing order")
    @Test
    void getSmallestWhenArrayDecreasingOrder(){
        numberFinder.find(new int[]{350,300,100,12,5,0,-12,-90});
        Assertions.assertEquals(350, numberFinder.getLargest());
    }
    @DisplayName("Get the smallest number when array contains the same numbers")
    @Test
    void getSmallestWhenArraySameNumber(){
        numberFinder.find(new int[]{7,7,7,7,7});
        Assertions.assertEquals(7, numberFinder.getSmallest());
    }
    @DisplayName("Get the largest number when array contains the same numbers")
    @Test
    void getLargestWhenArraySameNumber(){
        numberFinder.find(new int[]{0,0,0,0,0,0});
        Assertions.assertEquals(0, numberFinder.getLargest());
    }
    @DisplayName("Get the smallest& largest number when array random")
    @Test
    void getSmallesAndLargest(){
        Map<Integer,Integer> numFind=numberFinder.findNum(new int[]{12,15,7,3,30});
        Assertions.assertEquals(30, numberFinder.getLargest());
        Assertions.assertEquals(3, numberFinder.getSmallest());
    }

}
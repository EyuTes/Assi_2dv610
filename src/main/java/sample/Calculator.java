package sample;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class acts as a calculator to sum, subtract, multiply numbers or array of numbers
 */
public class Calculator {

    public int sum(int [] numbers){
       int sum=0;
       for(int num:numbers){
           sum+=num;
       }
       return sum;
    }
    public List<Integer> filters(List<Integer> integerList, Predicate<Integer> predicate){
          return integerList.stream().filter(predicate).collect(Collectors.toList());
   }

}

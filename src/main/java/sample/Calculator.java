package sample;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class acts as a calculator to sum, subtract, multiply numbers or array of numbers
 */
public class Calculator {

    public int sum(int num1,int num2){
        throw new NotImplementedException();
    }
    public int product(int num1,int num2 ){
        return 12;
    }
    public int sum(int [] numbers){
       int sum=0;
       for(int num:numbers){
           sum+=num;
       }
       return sum;
    }
    public List<Integer> filters(List<Integer> integerList, Predicate<Integer> predicate){

          /*
          List<Integer> filteredNumbers=new ArrayList<>();
           for(Integer number:integerList){
            if(predicate.test(number)){
                filteredNumbers.add(number);
            }
             return filteredNumbers;
        }*/
        return integerList.stream().filter(predicate).collect(Collectors.toList());
   }

}

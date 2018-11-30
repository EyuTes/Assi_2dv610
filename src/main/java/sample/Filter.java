package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Filter {


    public static void main(String [] args){
        printSquareRoot();
        printFilter();
    }
    private static void printSquareRoot(){
        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
        numbers.stream().filter(e->e%2==0).forEach(System.out::println);
    }
    private static void printFilter() {
        Predicate<Integer> positive= i -> i > 0;
        Predicate<Integer> even=i -> i %2== 0;
        Predicate<Integer> odd=i -> i %2!= 0;
        List<Integer> integerList=Arrays.asList(1,10,200,101,-1,0);
        List<Integer> filteredPositiveList=filters(integerList,positive);
        filteredPositiveList.forEach(System.out::println);

        List<Integer> filteredEvenList=filters(integerList,even);
        filteredEvenList.forEach(System.out::println);

        List<Integer> filteredOddList=filters(integerList,odd);
        filteredOddList.forEach(System.out::println);
    }

    private static List<Integer> filters(List<Integer> integerList, Predicate<Integer> predicate){
        List<Integer> filteredNumbers=new ArrayList<>();
        for(Integer number:integerList){
            if(predicate.test(number)){
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }
}

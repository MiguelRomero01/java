package RoadTo_SpringBot.BasicConcepts.Streams_Lambda.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class numbersStream {
     public static void main(String[] args) {
          List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20); //Numbers list

          List<Integer> evenNumbers =  numbers.stream() //stream
                                   .filter(number -> number % 2 == 0) //filter the number through of a condition
                                   .collect(Collectors.toList()); //collect it as a list and add to "evenNumbers"

          List<Integer> EvenNumbers_exp = evenNumbers.stream()
                                   .map(numExp -> numExp*numExp) //make an math operation
                                   .collect(Collectors.toList());

          //print both arrays
          System.out.println("Even numbers: "+evenNumbers);
          System.out.println("Even numbers raised to 2: "+EvenNumbers_exp);
     }
}

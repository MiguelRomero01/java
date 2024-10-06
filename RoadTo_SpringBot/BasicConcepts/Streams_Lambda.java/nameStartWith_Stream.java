package RoadTo_SpringBot.BasicConcepts.Streams_Lambda.java;

import java.util.Arrays;
import java.util.List;

public class nameStartWith_Stream{
     public static void main(String[] args) {
          List <String> names = Arrays.asList("Mario", "Ana", "aria", "Miguel", "Juan", "Mateo","anuel");

          long x = names.stream()
               .filter(name -> name.toLowerCase().startsWith("a"))
               .count();

          System.out.println("Number of names begin with the letter a: "+ x);
     }
}
     
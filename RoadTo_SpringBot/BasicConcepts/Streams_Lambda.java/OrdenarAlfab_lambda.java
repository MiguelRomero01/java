package RoadTo_SpringBot.BasicConcepts.Streams_Lambda.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenarAlfab_lambda {
     public static void main(String[] args) {
          List<String> names = Arrays.asList("Ana", "Pedro", "Maria", "Juan", "Sara");
          
          //Lambda
          Runnable task = () ->{
               Collections.sort(names, (nombre1, nombre2) -> nombre1.compareTo(nombre2));
               System.out.println(names);
          };

          //se crea el objecto que va a ejecutar el lambda
          Thread thread = new Thread(task);
          thread.start();
     }
}

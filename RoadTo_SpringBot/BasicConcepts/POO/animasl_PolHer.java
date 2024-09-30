package RoadTo_SpringBot.BasicConcepts.POO;

import java.util.ArrayList;
import java.util.List;

public class animasl_PolHer{
     
     class Animal{
          protected String sound;
          
          public Animal(String sound){
               this.sound = sound;
          }

          public void doSound(){
               System.out.println("Soy un animal y hago "+ sound);
          }
     }

     class Dog extends Animal{
          public Dog (String sound){
               super(sound);
          }

          @Override
          public void doSound(){
               System.out.println("Soy un perro y hago "+ sound);
          }
     }

     class Cow extends Animal{
          public Cow (String sound){
               super(sound);
          }

          @Override
          public void doSound(){
               System.out.println("Soy una vaca y hago "+sound);
          }
     }

     class Cat extends Animal{
          public Cat (String sound){
               super(sound);
          }

          @Override
          public void doSound(){
               System.out.println("Soy un gato y hago "+sound);
          }
     }

     public static void main(String[] args) {
          List<Animal> animals_List = new ArrayList<>();

          animasl_PolHer animalsZoo = new animasl_PolHer();

          animals_List.add(animalsZoo.new Dog("wau"));
          animals_List.add(animalsZoo.new Cat("miau"));
          animals_List.add(animalsZoo.new Cow("muu"));

          for (var animal: animals_List){
               animal.doSound();
          }
     }
}


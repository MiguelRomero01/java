package RoadTo_SpringBot.BasicConcepts.POO;

import java.util.HashMap;
import java.util.Scanner;

public class Students {
     //This function makes the menu to show the user
     public static void ShowMenu(){
          System.out.println("");
          System.out.println("1. Add Student");
          System.out.println("2. Get information about student");
          System.out.println("3. Get students");
          System.out.println("4. Delete student");
          System.out.println("5. Get class average");
          System.out.println("6. Exit");
     }

     //this function finishes the program
     public static void Exit(){
          System.out.println("Thanks for watching");
          System.exit(0);
     }
          
     //This class create a 1 student
     class Student{
          HashMap<String, Object> studentData= new HashMap<>(); //dictionary to save all data about student

          public Student(String name, int age, double average){
               this.studentData= new HashMap<>();
               studentData.put("Name",name);
               studentData.put("Age",age);
               studentData.put("Average",average);
          }

          //get the student data (dictionary)
          public HashMap<String, Object> getStudentData(){
               return this.studentData;
          }
     }

     //this class create a classroom
     class ClassRoom{
          HashMap<String, HashMap<String,Object>> classData = new HashMap<>(); //dictionary to save all data about students
     
          public ClassRoom(){
               this.classData = new HashMap<>();
          }

          //make the Student's average (classroom)
          public void classAverage(Scanner scanner_classAverage){
               double sum_measure_classroom = 0;
               int counter = 0;

               for (String documentNum : getClassStudents().keySet()) {
                    HashMap<String, Object> studentData = getClassStudents().get(documentNum);
                    
                    if (studentData.containsKey("Average")) {
                         Object measure_student = studentData.get("Average");
                         double measure_student_double = (double) measure_student;

                         sum_measure_classroom = sum_measure_classroom + measure_student_double;
                         counter += 1;
                    } else {
                         System.out.println("Student with Document Number: " + documentNum + " does not have a Average.");
                    }
               }

               double measure_classroom = sum_measure_classroom / counter;
               System.out.println("Average: "+measure_classroom);
          }

          //Add the student from the class Student to classRoom
          public void setStudent(String documentNum,Student student){
               this.classData.put(documentNum,student.getStudentData());
          }

          public HashMap<String, HashMap<String,Object>> getClassStudents(){
               return this.classData;
          }
     }

     class UserLogic {
          private ClassRoom classRoom; // Almacenamos ClassRoom como atributo
          
          // Pasamos una instancia de ClassRoom en el constructor
          public UserLogic(ClassRoom classRoom) {
               this.classRoom = classRoom;
          }
          
          // Metod to add a student
          public void addStudent(Students studentsClass,Scanner scanner_AddStudent) {
              // Basic Student's data
               System.out.println("Enter the document number");
               String documentNum = scanner_AddStudent.nextLine();
          
               System.out.println("Enter the name");
               String name = scanner_AddStudent.nextLine();
          
               System.out.println("Enter the age");
               int age = scanner_AddStudent.nextInt();

               //--Calculate the average about student
               double average = averageStudent(scanner_AddStudent);
               
               //Create a new instance of student
               Student student = studentsClass.new Student(name, age, average);
          
               // Add a student to class (ClassRoom)
               classRoom.setStudent(documentNum, student);
          }

          //Metod to calculate the student's average
          public double averageStudent(Scanner scanner_Average){
               System.out.println("--Average--\n");

               System.out.println("Enter note 1:");
               double note1 = scanner_Average.nextDouble();
          
               System.out.println("Enter note 2:");
               double note2 = scanner_Average.nextDouble();
          
               System.out.println("Enter note 3:");
               double note3 = scanner_Average.nextDouble();
          
               scanner_Average.nextLine(); //clean the buffer
               
               // Calculate the average and round to 2 decimals
               double averageStudent = (int) (((note1 + note2 + note3) / 3) * 100) / 100.0; 

               return averageStudent;
          }

          //Metod to delete a student
          public void deleteStudent(Scanner scanner_DeleteStudent){
               //get the student to remove
               System.out.println("Enter the Student's Document number");
               String docNum_remove = scanner_DeleteStudent.nextLine();

               //delete the student
               if (classRoom.getClassStudents().containsKey(docNum_remove)) {
                    classRoom.getClassStudents().remove(docNum_remove); //it removes the student
                    System.out.println("Student with document number "+docNum_remove+" was removed succesfully");
               } else {
                    System.out.println("Student not found.");
               }
          }

          //Metod to get Student's information
          public void getInformationStudent(Scanner scanner_getStudent){
               //get the student to get the information
               System.out.println("Enter the Student's Document number");
               String docNum_getStudent = scanner_getStudent.nextLine();

               //delete the student
               if (classRoom.getClassStudents().containsKey(docNum_getStudent)) {
                    System.out.println("Student:" +classRoom.getClassStudents().get(docNum_getStudent));
               } else {
                    System.out.println("Student not found.");
               }
          }

          //Get and show all students
          public void showAll_Students(){
               System.out.println(classRoom.getClassStudents());
          }
     }

     public static void main(String[] args) {
          //objects creation
          Students studentsClass = new Students(); //main class

          ClassRoom classRoom = studentsClass.new ClassRoom();
          UserLogic ProgramLogic = studentsClass.new UserLogic(classRoom);


          try(Scanner scanner = new Scanner(System.in)){
               //loop to execute the options for user
               while (true) { 
                    //The user will choose one option
                    ShowMenu();
                    int userOption = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (userOption) {
                         case 1 -> ProgramLogic.addStudent(studentsClass,scanner);
                         case 2 -> ProgramLogic.getInformationStudent(scanner);
                         case 3 -> ProgramLogic.showAll_Students();
                         case 4 -> ProgramLogic.deleteStudent(scanner);
                         case 5 -> classRoom.classAverage(scanner);
                         case 6 -> Exit();
                    }
               }

          }catch (Exception e){
                    System.err.println("Error: "+e);
          }
     }
}

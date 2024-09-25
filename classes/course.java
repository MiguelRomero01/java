package classes;
import java.util.HashMap;

public class course {
    class Student {
        private int id;
        private String name;
        private HashMap<String, Double> grades;

        public Student(int id, String name, HashMap<String, Double> grades) {
            this.id = id;
            this.name = name;
            this.grades = grades;
        }

        // Método para agregar una nota al HashMap
        public void addGrade(String subject, double grade) {
            grades.put(subject, grade);
        }

        public String getName(){
          return name;
        }

        // Método para obtener las notas
        public HashMap<String, Double> getGrades() {
            return grades;
        }
    }

    public static void main(String[] args) {
        course course = new course();

        // Crear un HashMap para las notas del estudiante
        HashMap<String, Double> studentGrades = new HashMap<>();

        // Crear un objeto Student con el HashMap de notas
        Student student1 = course.new Student(1, "Miguel", studentGrades);

        // Agregar otra nota usando el método de la clase Student
        student1.addGrade("nota1", 4.0);
        student1.addGrade("nota2", 5.0);

        // Imprimir las notas del estudiante
        System.out.println(student1.getName() + ": " + student1.getGrades());
    }
}

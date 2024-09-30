package RoadTo_SpringBot.BasicConcepts.POO;

import java.util.ArrayList;
import java.util.List;

public class empleado_PolHer {

     class Employee {
          protected String name;
          protected double salaryBase;

          public Employee(String name, double salaryBase) {
               this.name = name;
               this.salaryBase = salaryBase;
          }

          public double calculateSalary() {
               return this.salaryBase;
          }

          public void getFinalSalary() {
               System.out.println("Empleado: " + name + ", Salario Final: " + calculateSalary());
          }
     }

     class HourEmployee extends Employee {
          private double salaryPerHour;
          private int hoursWorked;

          public HourEmployee(String name, double salaryPerHour, int hoursWorked) {
               super(name, 0); 
               this.salaryPerHour = salaryPerHour;
               this.hoursWorked = hoursWorked;
          }

          @Override
          public double calculateSalary() {
               return salaryPerHour * hoursWorked;
          }
     }

     class SalaryEmployee extends Employee {
          private double performanceBonus;

          public SalaryEmployee(String name, double salaryBase, double performanceBonus) {
               super(name, salaryBase);
               this.performanceBonus = performanceBonus;
          }

          @Override
          public double calculateSalary() {
               return salaryBase + performanceBonus;
          }
     }

     class CommissionEmployee extends Employee {
          private double totalSales;
          private double commissionRate;

          public CommissionEmployee(String name, double salaryBase, double totalSales, double commissionRate) {
               super(name, salaryBase);
               this.totalSales = totalSales;
               this.commissionRate = commissionRate;
          }

          @Override
          public double calculateSalary() {
               return salaryBase + (totalSales * commissionRate / 100);
          }
     }

     public static void main(String[] args) {
          List<Employee> employeesList = new ArrayList<>();

          empleado_PolHer company = new empleado_PolHer();

          employeesList.add(company.new SalaryEmployee("Pablo", 2000.0, 500.0));
          employeesList.add(company.new CommissionEmployee("Miguel", 1500.0, 3000.0, 10.0));
          employeesList.add(company.new HourEmployee("Hernan", 20.0, 40));

          for (Employee emp : employeesList) {
               emp.getFinalSalary();
          }
     }
}

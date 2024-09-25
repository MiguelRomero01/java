package Functions;

import java.util.HashMap;
import java.util.Scanner;

public class cajero {
     static Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
          System.out.println("Bienvenido al banco");

          HashMap<String, String> datos = UserData();// Obtener los datos de UserData para pasarlo a datarequire
          dataRequire(datos); //pasa la funcion UserData a la funcion datarequire que valida la informacion

          scanner.close();
     }

     public static HashMap<String,String> UserData(){
          HashMap<String, String> UserData_Dict = new HashMap<>();
          UserData_Dict.put("documento","12345");
          UserData_Dict.put("cvv","123");
          UserData_Dict.put("money","300.0");
          
          return UserData_Dict;
     }

     public static void dataRequire(HashMap<String, String> datos){
          //datos obtenidos de la funcion "UserData"
          String documento = datos.get("documento");
          String cvv = datos.get("cvv");
          double money = Double.parseDouble(datos.get("money"));

          System.out.println("Inserte su documento y clave\n");

          //bucle para pedir los datos si estan erroneos
          while (true){
               System.out.println("Documento de identidad: ");
               String userDocument = scanner.nextLine();

               System.out.println("Clave: ");
               String userCvv = scanner.nextLine();

               try{
                    if (userDocument.equals(documento) && userCvv.equals(cvv)){
                         UserOption(datos);
                         break;
                    }else{
                         System.out.println("Datos erroneos. Intente nuevamente\n");
                    }
               }catch(Exception e){
                    System.out.println("Error: "+e);
               }
          }
     }

     public static void UserOption(HashMap<String, String> datos){
          double money = Double.parseDouble(datos.get("money"));

          //pedir al usuario una funcion
          System.out.println("Escoja una función: ");
          System.out.println("1. Consultar saldo");
          System.out.println("2. Retirar dinero");
          String userOption = scanner.nextLine();

          switch(userOption){
               case "1" -> System.out.println("Tu saldo es: "+money);
               case "2" -> {
                    System.out.println("Cuanto dinero deseas retirar?");
                    double amountOff = scanner.nextDouble();
                    
                    money = money - amountOff;
                    datos.put("money", Double.toString(money));
                    System.out.println("Tu nuevo saldo es: "+datos.get("money"));
               }

               default -> System.out.println("Opcion no reconocida");
          }
     }


}

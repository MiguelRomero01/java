package classes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class concesionario {
     //-----------------------------------Vehicle Object------------------------------------------
     class Vehicle{
          HashMap<String, Object> VehicleData = new HashMap<>(); //Hashmap who will store the Data of vehicle

          public Vehicle(String brand,String type,double price,boolean available){ //el modelo será la llave en el diccionario del inventario
               this.VehicleData = new HashMap<>();

               //pass data to VehicleData
               VehicleData.put("Brand",brand);
               VehicleData.put("Type",type);
               VehicleData.put("Price",price);
               VehicleData.put("Availability",available);
          }

          //---get vehicle hashmap 
          public HashMap<String,Object> getVehicleData_HashMap(){
               return this.VehicleData;
          }
     }

     //-----------------------------------------Dealership Object --------------------------------------------
     class DealerShip{
          HashMap<String, HashMap<String,Object>> Inventory = new HashMap<>(); //Hashmap to store the inventroy of dealership

          public DealerShip(){
               this.Inventory = new HashMap<>();
          }

          //---Show menu function
          public void showMenu(){
               System.out.println("\nEnter a option: ");
               System.out.println("1. See all products");
               System.out.println("2. Filter");
               System.out.println("3. Add product");
               System.out.println("4. Exit");
          }

          public void dealerShip_Options(Scanner scannerUser, DealerShip dealerShip){

               while(true){
                    showMenu();
                    int Option_Chosen_ByUser = scannerUser.nextInt();
                    scannerUser.nextLine();

                    switch (Option_Chosen_ByUser) {
                         case 1-> getInventory();
                         
                         case 2 -> filter(scannerUser,dealerShip);

                         case 3 -> AddProduct(scannerUser);
                         
                         case 4 -> exit();
                         
                         default-> throw new AssertionError();
                    }
               }
          }


          //---Get inventory 
          public HashMap<String,HashMap<String,Object>> getInventory(){
               System.out.println(this.Inventory);
               return this.Inventory;
          }
          

          //---Show menu about filter
          public void ShowMenu_Filter(){
               System.out.println("Choose one option: ");
               System.out.println("Filter by brand: ");
               System.out.println("Filter by type: ");
               System.out.println("Filter by price: ");
               System.out.println("Filter by availability: ");
          }


          //---filter options
          public void filter(Scanner scannerUser, DealerShip dealerShip){
               ShowMenu_Filter();
               int Filter_ByUser = scannerUser.nextInt();

               switch(Filter_ByUser){
                    case 1 -> filterBrand(scannerUser, dealerShip);
                    case 3 -> filterPrice(scannerUser, dealerShip);
               }
          }

          //---filter by price
          public void filterPrice(Scanner scannerUser, DealerShip dealerShip){
               scannerUser.nextLine();
               System.out.println("Valor mayor a: ");
               BigDecimal filter_price_bigDecimal = scannerUser.nextBigDecimal();
               scannerUser.nextLine();

               //CONTINUAR BUCLE DE FILTRAR POR PRECIO DESPUES
               
          }

          //---filter by brand
          public void filterBrand(Scanner scanner, DealerShip dealerShip){
               scanner.nextLine();
               System.out.println("Enter your brand: ");
               String filter_brand = scanner.nextLine();

               //loop to filter the brand in all dictionary
               for (var entry : dealerShip.getInventory().entrySet()) {
                         String model = entry.getKey(); // get key

                         if(filter_brand.equals(model)){
                         HashMap<String, Object> vehicleData = entry.getValue(); // get value
                    
                         //print vehicle data
                         System.out.println("Modelo: " + model);
                         System.out.println("Datos del vehículo: " + vehicleData);
                    }
                }
                
          }

          //---filter by type
          public void filterType(Scanner scanner, DealerShip dealerShip){
               System.out.println("Enter your vehicle type");
               String filter_Type = scanner.nextLine();

               //crear bucle para filtrar por tipo
          }

          //---filter by availability
          public void filterAvailability(Scanner scanner, DealerShip dealerShip){
               System.out.println("Enter the Vehicle Availability");
               String filter_Availability = scanner.nextLine();

               //crear bucle para filtar por disponibilidad
          }


          //---Add Vehicle function
          public void AddProduct(Scanner scannerUser){

               //model
               System.out.println("Enter the model: ");
               String Vehicle_Model = scannerUser.nextLine();

               //brand
               System.out.println("Enter the brand: ");
               String Vehicle_Brand = scannerUser.nextLine();

               //type
               System.out.println("Enter the type: ");
               String Vehicle_Type = scannerUser.nextLine();

               //price
               System.out.println("Enter the price: ");
               double Vehicle_Price = scannerUser.nextDouble();

               scannerUser.nextLine();

               //availability
               System.out.println("Enter the availability: (y/n)");
               String vehicleAvailabilityInput = scannerUser.nextLine();
               boolean Vehicle_Availability;

              //condition to know if the Vehicle is available (true/false)
               Vehicle_Availability = vehicleAvailabilityInput.equals("y");
               
               Vehicle newVehicle = new Vehicle(Vehicle_Brand, Vehicle_Type, Vehicle_Price, Vehicle_Availability); //object creation
               
               setInventorty_HashMap(newVehicle.getVehicleData_HashMap(),Vehicle_Model); //(Hashmap <string,object> from the class "Vehicle",Vehicle model by user)
          }

          //---Set the new vehicle in the actualInventory
          public void setInventorty_HashMap(HashMap<String, Object> Send_To_Inventory,String model){
               this.Inventory.put(model, Send_To_Inventory);
          }

          //---exit function
          public void exit(){
               System.out.println("Thanks. Come back soon");
               System.exit(0);
          }
     }

     public static void main(String[] args) {
          concesionario concesionario = new concesionario(); //main object creation

          //try execute program
          try (Scanner scannerUser = new Scanner(System.in)){
               DealerShip dealerShip = concesionario.new DealerShip(); //Dealeship object creation
               dealerShip.dealerShip_Options(scannerUser,dealerShip); 
          } 
          catch (Exception e) { System.out.println("Erroe encontrado: "+e);}
     }
}
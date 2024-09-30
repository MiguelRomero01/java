package classes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class concesionario {
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

          public HashMap<String,Object> getVehicleData_HashMap(){
               return this.VehicleData;
          }
     }

     class DealerShip{
          HashMap<String, HashMap<String,Object>> Inventory = new HashMap<>(); //Hashmap to store the inventroy of dealership

          public DealerShip(){
               this.Inventory = new HashMap<>();
          }

          //Show menu function
          public void showMenu(){
               System.out.println("\nEnter a option: ");
               System.out.println("1. See all products");
               System.out.println("2. Filter");
               System.out.println("3. Add product");
               System.out.println("4. Exit");
          }

<<<<<<< Updated upstream
          //MAIN FUNCTION: Show all the user options and connect the other objects for getting information for inventory
          public void dealerShip_Options(Scanner scannerUser){

=======
          //---Logic of options
          public void dealerShip_Options(Scanner scannerUser, DealerShip dealerShip){
               
               //loop that will be executing until the user choose the option 4
>>>>>>> Stashed changes
               while(true){
                    showMenu();
                    int Option_Chosen_ByUser = scannerUser.nextInt();
                    scannerUser.nextLine();

                    switch (Option_Chosen_ByUser) {
                         case 1-> System.out.println(getInventory());
                         
                         case 2 -> filter(scannerUser);

                         case 3 -> AddProduct(scannerUser);
                         
                         case 4 -> exit();
                         
                         default-> throw new AssertionError();
               }
               }
          }


          //Get inventory 
          public HashMap<String,HashMap<String,Object>> getInventory(){
               return this.Inventory;
          }
          

<<<<<<< Updated upstream
          //Show menu abot filter
=======
          //----------------Show menu about filter---------------------------
>>>>>>> Stashed changes
          public void ShowMenu_Filter(){
               System.err.println("Choose one option: ");
               System.err.println("Filter by brand: ");
               System.err.println("Filter by type: ");
               System.err.println("Filter by price: ");
               System.err.println("Filter by availability: ");
          }


          //filter
          public void filter(Scanner scannerUser){
               ShowMenu_Filter();
               int Filter_ByUser = scannerUser.nextInt();
               scannerUser.nextLine();

               switch(Filter_ByUser){
<<<<<<< Updated upstream
                    case 3 -> filterPrice(scannerUser);
               }
          }

          //filter by price
          public void filterPrice(Scanner scannerUser){
=======
                    case 1 -> filterBrand(scannerUser, dealerShip);
                    case 2 -> filterType(scannerUser, dealerShip);
                    case 3 -> filterPrice(scannerUser, dealerShip);
                    case 4 -> filterAvailability(scannerUser, dealerShip);
               }
          }

          //---filter by price
          public void filterPrice(Scanner scannerUser, DealerShip dealerShip){
>>>>>>> Stashed changes
               System.out.println("Valor mayor a: ");
               BigDecimal filter_price_bigDecimal = scannerUser.nextBigDecimal();
               scannerUser.nextLine();

<<<<<<< Updated upstream
               
          }

          //Add Vehicle function
=======
               for (var entry: dealerShip.getInventory().entrySet()){
                    HashMap<String,Object> vehicleData = entry.getValue();

                    BigDecimal bigDecimal_price = new BigDecimal(((Number) vehicleData.get("price")).doubleValue());

                    if(filter_price_bigDecimal.compareTo(bigDecimal_price)>0){
                         System.out.println("Vehicle Data: "+ vehicleData); //print vehicle data
                    } 
               }
           }
          

          //---filter by brand
          public void filterBrand(Scanner scanner, DealerShip dealerShip){
               System.out.println("Enter your brand: ");
               String filter_brand = scanner.nextLine();

               //loop to filter the brand in all dictionary
               for (var entry : dealerShip.getInventory().entrySet()) {
                         String brand = entry.getKey(); // get key

                         if(filter_brand.equals(brand)){
                         HashMap<String, Object> vehicleData = entry.getValue(); // get value
                    
                         //print vehicle data
                         System.out.println("Vehicle data: " + vehicleData);
                    }
                }
                
          }

          //---filter by type
          public void filterType(Scanner scanner, DealerShip dealerShip){
               System.out.println("Enter your vehicle type");
               String filter_Type = scanner.nextLine();

               //crear bucle para filtrar por tipo
               for (var entry: dealerShip.getInventory().entrySet()){
                    String type = entry.getKey(); //get key

                    if(filter_Type.equals(type)){
                         HashMap<String,Object> vehicleData = entry.getValue(); //get all values from vehicleData

                         //print vehicle data
                         System.out.println("Vehicle Data: "+ vehicleData);
                    }
               }
          }

          //---filter by availability
          public void filterAvailability(Scanner scanner, DealerShip dealerShip){
               System.out.println("Enter the Vehicle Availability (y/n)");
               String AvailabilityInput_filter = scanner.nextLine();

               boolean x = AvailabilityInput_filter.equals("y");

               //crear bucle para filtar por disponibilidad
               for (var entry: dealerShip.getInventory().entrySet()){
                    HashMap<String,Object> vehicleData = entry.getValue();

                    if(x == (boolean) vehicleData.get("Availability")){
                         System.out.println("Vehicle Data: "+ vehicleData); //print vehicle data
                    } 
               }
          }


          //---Add Vehicle function
>>>>>>> Stashed changes
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

          //Set the new vehicle in the actualInventory
          public void setInventorty_HashMap(HashMap<String, Object> Send_To_Inventory,String model){
               this.Inventory.put(model, Send_To_Inventory);
          }

          //exit function
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
               dealerShip.dealerShip_Options(scannerUser); 
          } 
          catch (Exception e) { System.out.println("Erroe encontrado: "+e);}
     }
}
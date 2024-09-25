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

          //MAIN FUNCTION: Show all the user options and connect the other objects for getting information for inventory
          public void dealerShip_Options(Scanner scannerUser){

               while(true){
                    showMenu();
                    int Option_Chosen_ByUser = scannerUser.nextInt();
                    scannerUser.nextLine();

                    switch (Option_Chosen_ByUser) {
                         case 1-> getInventory();
                         
                         case 2 -> filter(scannerUser);

                         case 3 -> AddProduct(scannerUser);
                         
                         case 4 -> exit();
                         
                         default-> throw new AssertionError();
               }
               }
          }


          //Get inventory 
          public HashMap<String,HashMap<String,Object>> getInventory(){
               System.out.println(this.Inventory);
               return this.Inventory;
          }
          

          //Show menu abot filter
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

               switch(Filter_ByUser){
                    case 3 -> filterPrice(scannerUser);
               }
          }

          //filter by price
          public void filterPrice(Scanner scannerUser){
               System.out.println("Valor mayor a: ");
               BigDecimal filter_price_bigDecimal = scannerUser.nextBigDecimal();
               scannerUser.nextLine();

               
          }

          //Add Vehicle function
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
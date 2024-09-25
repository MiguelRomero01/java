package classes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class shop {
     
     //producto
     class Producto{
          //hashmap donde se almacenarán todo los datos del producto para mandarlo al inventario de "tiendaoperaciones"
          HashMap<String, Object> productoDatos = new HashMap<>();

          public Producto(String name, String id, double price, int QuantityStock){
               this.productoDatos = new HashMap<>();

               //mandar los datos del objeto al diccionario
               productoDatos.put("nombre", name);
               productoDatos.put("codigo",id);
               productoDatos.put("precio",price);
               productoDatos.put("cantidad",QuantityStock);
          }

          //metodo get para retornar los datos del producto en formato hashmap
          public HashMap<String, Object> getDatosProducto_HashMap(){
               return this.productoDatos;
          }
     }

     //tienda
     class TiendaOperaciones{
          //hashmap que lleva el inventario de los productos
          HashMap<String, HashMap<String, Object>> Inventario = new HashMap<>();

          //contructor
          public TiendaOperaciones(){
               this.Inventario = new HashMap<>();
          }

          //funcion retornar inventario de la tienda
          public HashMap<String, HashMap<String, Object>> getInventario(){
               return this.Inventario;
          }

          //funcion mostrar menu
          public void showMenu(){
               System.out.println();
               System.out.println("1. Añadir producto");
               System.out.println("2. Ver producto");
               System.out.println("3. Mostrar inventario");
               System.out.println("4. Vender producto");
               System.out.println("5. Salir");
          }

          //funcion escoger una opcion por parte del usuario
          public void UserOPtion(Scanner scanner){
               //ciclo que repite el menu y opciones hasta que el usuario salga
               while (true) { 
                    showMenu(); //muestra el menu de opciones
                    int optionChosen_by_User = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea después de nextInt()
     
                    switch (optionChosen_by_User){
                         case 1 -> addproduct(scanner); //añadir un producto
     
                         case 2 -> ShowProduct(scanner); //mostrar el producto de eleccion
     
                         case 3 -> System.out.println(getInventario()); //imprimer el inventario actual
     
                         case 4 -> sellProduct(scanner); //vender algun producto
     
                         case 5 -> {
                              //salir del programa
                              System.out.println("Tenga un buen dia");
                              System.exit(0);
                         } 
     
                         default -> System.out.println("Ingrese una opcion valida");   
                    }
               }
          }

          //funcion añadir producto
          public void addproduct(Scanner scanner){
               System.out.println();

               //pedir datos al usuario
               System.out.println("Ingrese el nombre del producto:");
               String name = scanner.nextLine();

               System.out.println("Ingrese el código del producto:");
               String id = scanner.nextLine();

               System.out.println("Ingrese el precio del producto:");
               double price = scanner.nextDouble();

               System.out.println("Ingrese la cantidad del producto:");
               int quantity = scanner.nextInt();

               Producto producto = new Producto(name, id, price, quantity); //creacion del objeto enlazado a la clase Producto

               //objetivo: mandar "DatosProducto" a "Inventario"
               //key: nombre del producto
               //value: datos del diccionario
               this.Inventario.put(name,producto.getDatosProducto_HashMap());

               //probar si quedaron bien incertados los datos
               try{
                    System.out.println("Producto creado exitosamente");
               }catch(Exception e){
                    System.out.println(e);
               }
          }

          //funcion ver producto
          public void ShowProduct(Scanner scanner){
               System.out.println("Ingrese el nombre del producto");
               String ProductToShow = scanner.nextLine();

               // Acceder al HashMap interno usando el nombre como clave
               HashMap<String, Object> productoMostrar = this.Inventario.get(ProductToShow);

               //Mostrar los datos del producto
               System.out.println("Nombre: "+productoMostrar.get("nombre"));
               System.out.println("codigo: "+productoMostrar.get("codigo"));
               System.out.println("precio: "+productoMostrar.get("precio"));
               System.out.println("cantidad: "+productoMostrar.get("cantidad"));
          }

          //funcion vender producto
          /*
           * NOTA IMPORTANTE: COLOCAR UN IF PARA EVALUAR SI EL STOCK DISPONIBLE SE PUEDE RESTAR Y SI EL PRODUCTO EXISTE
           */
          public void sellProduct(Scanner scUser){
               System.out.println();

               System.out.println("Ingrese el nombre del producto");
               String ProductToSell = scUser.nextLine();

               // Acceder al HashMap interno usando el nombre como clave
               HashMap<String, Object> productoVender_HashMap = this.Inventario.get(ProductToSell);

               //condicional para saber si el producto existe o no
               if(productoVender_HashMap != null){
                    System.out.println("Ingrese la cantidad de "+ProductToSell+" a vender");
                    int Stock_to_sell = scUser.nextInt();

                    //--cambiar stock en inventario
                    int newStock = ((Integer) productoVender_HashMap.get("cantidad")) - Stock_to_sell; //convierte el objeto cantidad a int y lo resta

                    //condicional para saber si el stock en el inventario es el suficiente para hacer la operacion
                    if(newStock >= 0){
                         productoVender_HashMap.put("cantidad",newStock);
                         this.Inventario.put(ProductToSell,productoVender_HashMap);

                         //conversiones necesarias a bigdecimal
                         BigDecimal Stock_to_Sell_Bigdecimal = BigDecimal.valueOf(Stock_to_sell); 
                         BigDecimal price = BigDecimal.valueOf((Double) productoVender_HashMap.get("precio")); 

                         //operacion final e impresion de precio
                         BigDecimal FinalPrice = price.multiply(Stock_to_Sell_Bigdecimal); 
                         System.out.println("Valor a pagar: $"+FinalPrice);
                    }else{
                         System.out.println("Stock insuficiente en el inventario");
                    }
               }else{
                    System.out.println("Producto no encontrado. Lo sentimos");
               }
          }
     }

     public static void main(String[] args) {
          shop shop = new shop();

          try(Scanner scanner = new Scanner(System.in))
          {
               TiendaOperaciones tienda = shop.new TiendaOperaciones();

               tienda.UserOPtion(scanner);
          }
     }
}

package classes;

import java.util.ArrayList;
import java.util.List;

public class Library {
     // clase libro
     class Book{
          // atributos
          private String title;
          private String author;
          private boolean status;

          // constructor
          public Book(String title, String author, boolean status){
               this.title = title;
               this.author = author;
               this.status = status;
          }

          // métodos get
          public String getTitle(){
               return title;
          }

          public String getAuthor(){
               return author;
          }

          public boolean getStatus(){
               return status;
          }

          public boolean setStatus(boolean newStatus){
               status = newStatus;
               return status;
          }

          // método para agregar el libro a la librería
          public String setBook(LibraryShop libraryShop){
               libraryShop.addBook(this);
               return "El libro se ha agregado correctamente";
          }
     }

     // clase usuario
     class User{
          // atributos
          private String name;
          private String IdUser;

          // constructor
          public User(String name, String IdUser){
               this.name = name;
               this.IdUser = IdUser;
          }

          // métodos get
          public String getName(){
               return name;
          }

          public String getIdUser(){
               return IdUser;
          }

          // otros métodos
          public String borrowBook(Book book){
               String msg_return;
               if(book.getStatus()){
                    book.setStatus(false);
                    msg_return = "El libro se ha prestado con éxito";
               }else{
                    msg_return = "El libro no está disponible";
               }
               return msg_return;
          }
     }

     // clase librería
     class LibraryShop{
          // atributos
          private List<Book> books;
          private List<User> users;

          // constructor
          public LibraryShop(){
               this.books = new ArrayList<>();
               this.users = new ArrayList<>();
          }

          // métodos get
          public List<Book> getBooks(){
               return books;
          }

          public List<User> getUsers(){
               return users;
          }

          // método para agregar un libro
          public void addBook(Book book){
               books.add(book);
          }
     }

     public static void main(String[] args) {
          Library library = new Library();
          LibraryShop libraryShop = library.new LibraryShop();

          Book book1 = library.new Book("asd", "asd", true);
          Book book2 = library.new Book("asd2", "asd2", false);
          Book book3 = library.new Book("asd3", "asd3", true);
          User user1 = library.new User("miguel", "123");

          // Agregando libros a la librería
          System.out.println(book1.setBook(libraryShop));
          System.out.println(book2.setBook(libraryShop));
          System.out.println(book3.setBook(libraryShop));

          // Prestando un libro
          System.out.println(user1.borrowBook(book2));
          System.out.println(book2.getStatus());

          // Mostrar libros en la librería
          for (Book book : libraryShop.getBooks()) {
               System.out.println("Título: " + book.getTitle() + ", Autor: " + book.getAuthor() + ", Disponible: " + book.getStatus());
          }
     }
}

package com.example.JSON;

import java.io.File; //It Allows to use @JsonProPerty
import java.io.IOException; //It is used when we work with arrays and hasmaps to make @JsonProperty works
import java.util.List; //It allows to convert Json to object and conversly

import com.fasterxml.jackson.annotation.JsonProperty; //Allows to manipulate windows files from java (.Os in python)
import com.fasterxml.jackson.core.type.TypeReference; //Throw exceptions when there are error with inputs or outputs (Specially with JSON)
import com.fasterxml.jackson.databind.ObjectMapper; //Allows to make an array

public class PokemonApp {

    // Clase interna Pokemon: Allow use their functions without the need to call its class (PokemonApp)
    //It's a good idea when you will use only Pokemon into its class
    
    public static class Pokemon {
        //Asigns the @JsonProperty name to the Json, even if the variable is different
        //@JsonProperty(Desired name into the JSON)
        @JsonProperty("nombre")
        private String nombre;

        @JsonProperty("tipo")
        private String tipo;

        @JsonProperty("nivel")
        private int nivel;

        // Constructor used by Jackson for JsonProperty
        public Pokemon() {}

        // Constructorcwith parameters
        public Pokemon(String nombre, String tipo, int nivel) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.nivel = nivel;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        //All classes have the method "toString()" and we need Override it
        @Override
        public String toString() {
            //The return can be changed. The classic it this, but can be anyone.
            return "Pokemon{" +
                    "nombre='" + nombre + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", nivel=" + nivel +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Crea el ObjectMapper para deserializar el JSON
        ObjectMapper mapper = new ObjectMapper();

        // Especifica el archivo JSON que deseas leer
        File jsonFile = new File("pokemones.json");

        try {

            // Deserializa el archivo JSON en una lista de objetos Pokemon
            List<Pokemon> pokemones = mapper.readValue(jsonFile, new TypeReference<List<Pokemon>>(){});

            //Create a new pokemon
            Pokemon nuevoPokemon = new Pokemon("Charmander", "Fuego", 10);
            pokemones.add(nuevoPokemon);

            //Save new changes
            mapper.writeValue(jsonFile, pokemones);

            // Muestra los datos de cada Pokémon
            for (Pokemon pokemon : pokemones) {
                System.out.println("Nombre: " + pokemon.getNombre());
                System.out.println("Tipo: " + pokemon.getTipo());
                System.out.println("Nivel: " + pokemon.getNivel());
                System.out.println();
            }

            System.out.println("Nuevo Pokémon añadido correctamente al archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

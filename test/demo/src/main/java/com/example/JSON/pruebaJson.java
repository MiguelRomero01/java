package com.example.JSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class pruebaJson {
      public static void main(String[] args) {
         // Crea una lista de Pokémon
        List<Pokemon> pokemones = new ArrayList<>();
        pokemones.add(new Pokemon("Pikachu", "Eléctrico", 25));

        // Crea el ObjectMapper para convertir la lista a JSON
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Especifica el archivo donde se guardará el JSON
            File jsonFile = new File("pokemones.json");

            // Convierte la lista de Pokémon a un archivo JSON
            mapper.writeValue(jsonFile, pokemones);

            System.out.println("El archivo JSON ha sido creado: " + jsonFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}

class Pokemon {
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("nivel")
    private int nivel;

    // Constructor
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
}


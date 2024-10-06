package com.example.api;

import java.net.URI; //The API's URL
import java.net.http.HttpClient; //Class that simules a client
import java.net.http.HttpRequest; //make requests GET,PUT,POST,etc
import java.net.http.HttpResponse; //response ready to display it to the user

import com.fasterxml.jackson.databind.JsonNode; //It allows use JSON's data without mapping
import com.fasterxml.jackson.databind.ObjectMapper; //It allows to convert Json to object and conversly

public class get1Request {
    public static void main(String[] args) {
        try {
                //Create Client HTTP
                HttpClient client = HttpClient.newHttpClient();

                // Set the URI for the request
                URI uriColor = new URI("https://pokeapi.co/api/v2/pokemon-color/brown");

                //create request
                HttpRequest request = HttpRequest.newBuilder()
                      .uri(uriColor) //API's link
                      .GET() //get the result from API
                      .header("Accept", "application/json") //("Response I want", "API's Extension")
                      .build(); //build API

                //Send request and get response
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //When get the response, it is converted to String to be read

                //print response
                System.out.println("API's response: "+ response.body());


                //--------------------request with limit of pokemons--------------------
                URI uriLimit = new URI("https://pokeapi.co/api/v2/pokemon?limit=6&offset=0");
                //create request
                request = HttpRequest.newBuilder()
                .uri(uriLimit) //API's link
                .GET() //get the result from API
                .header("Accept", "application/json") //("Response I want", "API's Extension")
                .build(); //build API

                //Send request and get response
                response = client.send(request, HttpResponse.BodyHandlers.ofString()); //When get the response, it is converted to String to be read

                //print response
                System.out.println("\nAPI's response 2: "+ response.body());


                //--------------------request with Id--------------------
                //NOTE: The Id brings all about it
                URI uriId = new URI("https://pokeapi.co/api/v2/pokemon/681");
                //create request
                request = HttpRequest.newBuilder()
                .uri(uriId) //API's link
                .GET() //get the result from API
                .header("Accept", "application/json") //("Response I want", "API's Extension")
                .build(); //build API

                //Send request and get response
                response = client.send(request, HttpResponse.BodyHandlers.ofString()); //When get the response, it is converted to String to be read

                //print response
                System.out.println("\nAPI's response 3: "+ response.body());

                //--------------------just request name---------------
                URI uriPokemonNameId = new URI("https://pokeapi.co/api/v2/pokemon/25");
                //create request
                request = HttpRequest.newBuilder()
                .uri(uriPokemonNameId) //API's link
                .GET() //get the result from API
                .header("Accept", "application/json") //("Response I want", "API's Extension")
                .build(); //build API

                //Send request and get response
                response = client.send(request, HttpResponse.BodyHandlers.ofString()); //When get the response, it is converted to String to be read

                // Parsear la respuesta JSON utilizando Jackson
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response.body());

                String PokemonName = jsonNode.get("name").asText();

                //Show pokemon
                System.out.println("\nPokemon's name: "+PokemonName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

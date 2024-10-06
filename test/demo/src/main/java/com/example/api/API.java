package com.example.api;

import java.net.URI; //The API's URL
import java.net.http.HttpClient; //Class that simules a client
import java.net.http.HttpRequest; //make requests GET,PUT,POST,etc
import java.net.http.HttpResponse; //response ready to display it to the user

public class API {
    public static void main(String[] args) {
        try {
            //Create Client HTTP
            HttpClient client = HttpClient.newHttpClient();

            //create request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://pokeapi.co/api/v2/pokemon/ditto")) //API's link
                    .GET() //get the result from API
                    .header("Accept", "application/json") //("Response I want", "API's Extension")
                    .build(); //build API

            //Send request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //When get the response, it is converted to String to be read

            //print response
            System.out.println("API's response: "+ response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
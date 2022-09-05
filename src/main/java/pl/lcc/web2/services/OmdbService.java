/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.services;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import jakarta.ejb.Singleton;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import java.io.Serializable;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Teresa
 */
@Singleton
public class OmdbService implements Serializable{

    public Movie findMovie(String title, String year) {
        var targetString = constructRequestString(title, year);
        
        Client client = ClientBuilder.newClient();
        WebTarget myResource = client.target(targetString);
        var response = myResource
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
       return toMovie(response);    
    }

    private Movie toMovie(String response) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().create();
        var result = gson.fromJson(response, Movie.class);
        return result;
    }

    private String constructRequestString(String title, String year) {
        var targetString = "http://www.omdbapi.com/?apikey=c84c360e";
        if (!title.isEmpty()) {
            targetString += "&t=" + title.replaceAll(" ", "+");
        }
        if (!year.isEmpty()) {
            targetString += "&y=" + year;
        }
        return targetString;
    }

}

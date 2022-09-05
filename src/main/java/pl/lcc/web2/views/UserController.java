/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Set;
import pl.lcc.web2.services.MovieDAO;
import pl.lcc.web2.services.annotations.PreferredDB;

/**
 *
 * @author Teresa
 */
@Named
public class UserController {
    
    @Inject
    @PreferredDB
    MovieDAO db;
    
    Set<Movie> movies;

    @PostConstruct
    public void init(){
        movies = db.getMovies(getUserName());
    } 

    public Set<Movie> getMovies() {
        return movies;
    } 

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
     
    public String getUserName(){
        var username = (String) FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .get("user");
      return username;
    } 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import Qualifiers.InMemory;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Set;
import pl.lcc.web2.services.KindOfDB;
import pl.lcc.web2.services.MovieDAO;

/**
 *
 * @author Teresa
 */
@Named
public class Top3Controller {
   
    @Inject     
    MovieDAO db;
    
    Set<Movie> movies;

    @PostConstruct
    public void init(){
        movies = db.getTop(3);
        System.out.println("Movies: ");
        System.out.println(movies);
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

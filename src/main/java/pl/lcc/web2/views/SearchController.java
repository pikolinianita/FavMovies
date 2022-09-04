/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;


import Qualifiers.InMemory;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Scope;
import java.io.Serializable;
import pl.lcc.web2.services.KindOfDB;
import pl.lcc.web2.services.MovieDAO;
import pl.lcc.web2.services.OmdbService;

/**
 *
 * @author Teresa
 */
@Named
@ViewScoped
public class SearchController implements Serializable{
   
    @Inject
    OmdbService omdbService;
    
    @Inject     
    MovieDAO db;
    
    String nameSearch;
    String yearSearch;
    
    Movie movie;

    private static final long serialVersionUID
            = 2L;
    
    public SearchController() {
        System.out.println("search contructor");
        movie = new Movie();
    }
    
    public String addMovie(){
        db.addMovie("lis", movie);
        System.out.println(db.count("lis"));
        return null;
    }

    public String find(){
        System.out.println("movie search");
       movie = omdbService.findMovie(nameSearch, yearSearch);
        return null;
    } 
    
    public String getNameSearch() {
        return nameSearch;
    }

    public void setNameSearch(String nameSearch) {
        this.nameSearch = nameSearch;
    }

    public String getYearSearch() {
        return yearSearch;
    }

    public void setYearSearch(String yearSearch) {
        this.yearSearch = yearSearch;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

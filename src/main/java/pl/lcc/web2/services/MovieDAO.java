/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pl.lcc.web2.services;

import java.util.Set;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Teresa
 */
public interface MovieDAO {

    KindOfDB addMovie(String user, Movie m);

    boolean checkUser(String user, String password);

    String count(String user);

    KindOfDB createUser(String user, String password);

    Set<Movie> getMovies(String user);

    Set<Movie> getTop(int n);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2;

import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import pl.lcc.web2.services.MovieDAO;
import pl.lcc.web2.services.annotations.PreferredDB;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Teresa
 */
@WebListener
public class FakeDataInitListener implements ServletContextListener{

    @Inject
    @PreferredDB   
    MovieDAO db;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        System.out.println("Context Initiaized Listener");
        db.createUser("zajac", "poziomka");
        db.createUser("lis", "witalis");
        db.createUser("pies", "puc");
        var m1 = createMovie("Star Trek", "2009", "https://m.media-amazon.com/images/M/MV5BMjE5NDQ5OTE4Ml5BMl5BanBnXkFtZTcwOTE3NDIzMw@@._V1_SX300.jpg");
        var m2 = createMovie("Star Trek: The Motion Picture", "1979", "https://m.media-amazon.com/images/M/MV5BNjk1ZjAyZjktZTY4YS00NDY3LWIwMzktMjZiNGIzODFiZDVmXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg");
        var m3 = createMovie("Star Trek: First Contact", "1996", "https://m.media-amazon.com/images/M/MV5BYzMzZmE3MTItODYzYy00YWI5LWFkNWMtZTY5NmU2MDkxYWI1XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg");

        db.addMovie("lis", m1).addMovie("lis", m2).addMovie("lis", m3);
        db.addMovie("zajac", m1).addMovie("zajac", m2);
        db.addMovie("pies", m1);
    }
    
     private Movie createMovie(String title, String year, String posterLink) {
        var m = new Movie();
        m.setTitle(title);
        m.setYear(year);
        m.setPosterLink(posterLink);
        return m;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import pl.lcc.web2.services.MovieDAO;
import pl.lcc.web2.services.NotPreferred;

/**
 *
 * @author Teresa
 */
@Named
@SessionScoped
public class Accounting implements Serializable {

     @Inject @NotPreferred
     MovieDAO db;
    
    private static final long serialVersionUID
            = -1110733631123457L;
    private LocalDate date;
    private String name;

    public LocalDate getDate() {
        System.out.println("getDate in Accounting: " + date); 
        return date;
    }

    public String register() {
        System.out.println("Register in Accounting"); 
        try{
        db.createUser("zajac", "poziomka");
        db.createUser("lis", "witalis");
        db.createUser("pies", "puc");
        var m1 = createMovie("Star Trek", "2009", "https://m.media-amazon.com/images/M/MV5BMjE5NDQ5OTE4Ml5BMl5BanBnXkFtZTcwOTE3NDIzMw@@._V1_SX300.jpg");
        var m2 = createMovie("Star Trek: The Motion Picture", "1979", "https://m.media-amazon.com/images/M/MV5BNjk1ZjAyZjktZTY4YS00NDY3LWIwMzktMjZiNGIzODFiZDVmXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg");
        var m3 = createMovie("Star Trek: First Contact", "1996", "https://m.media-amazon.com/images/M/MV5BYzMzZmE3MTItODYzYy00YWI5LWFkNWMtZTY5NmU2MDkxYWI1XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg");
        db.addMovie("lis", m1).addMovie("lis", m2).addMovie("lis", m3);
        db.addMovie("zajac", m1).addMovie("zajac", m2);
        db.addMovie("pies", m1);
       // System.out.println("kiko: " + db.count("kiko"));
       // System.out.println("lis: " + db.count("lis"));
       // System.out.println("pies: " + db.count("pies"));
       // System.out.println("lisowe: " + db.getMovies("lis"));
        System.out.println("topowe " + db.getTop(2));
        
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void setDate(LocalDate date) {
        System.out.println("setDate in Accounting"); 
        this.date = date;
    }

    public String getName() {
        System.out.println("getName in Accounting: " + name); 
        return name;
    }

    public void setName(String name) {
        System.out.println("setName in Accounting"); 
        this.name = name;
    }

         private Movie createMovie(String title, String year, String posterLink) {
        var m = new Movie();
        m.setTitle(title);
        m.setYear(year);
        m.setPosterLink(posterLink);
        return m;
    }
    
}

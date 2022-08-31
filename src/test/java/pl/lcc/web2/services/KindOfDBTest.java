/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.lcc.web2.services;

import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Teresa
 */
public class KindOfDBTest {

    private Movie createMovie(String title, String year, String link) {
        var m = new Movie();
        m.setTitle(title);
        m.setYear(year);
        m.setPosterLink(link);
        return m;
    }

    @Test
    public void testTakeTop() {
        var db = new KindOfDB();
        var m1 = createMovie("Star Trek", "2009", "https://m.media-amazon.com/images/M/MV5BMjE5NDQ5OTE4Ml5BMl5BanBnXkFtZTcwOTE3NDIzMw@@._V1_SX300.jpg");
        var m2 = createMovie("Star Trek: The Motion Picture", "1979", "https://m.media-amazon.com/images/M/MV5BNjk1ZjAyZjktZTY4YS00NDY3LWIwMzktMjZiNGIzODFiZDVmXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg");
        var m3 = createMovie("Star Trek: First Contact", "1996", "https://m.media-amazon.com/images/M/MV5BYzMzZmE3MTItODYzYy00YWI5LWFkNWMtZTY5NmU2MDkxYWI1XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg");
        db.createUser("zajac", "poziomka");
        db.createUser("lis", "witalis");
        db.createUser("pies", "puc");
        db.addMovie("lis", m1).addMovie("lis", m2).addMovie("lis", m3);
        db.addMovie("zajac", m1).addMovie("zajac", m2);
        db.addMovie("pies", m1);
        var result = db.getTop(2);
        assertTrue(result.contains(m1));
        assertTrue( result.contains(m2));

    }

}

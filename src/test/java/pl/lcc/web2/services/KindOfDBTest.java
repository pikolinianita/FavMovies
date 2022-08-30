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

    private Movie createMovie(String title, String year) {
        var m = new Movie();
        m.setTitle(title);
        m.setYear(year);
        return m;
    }

    @Test
    public void testTakeTop() {
        var db = new KindOfDB();
        var m1 = createMovie("King", "1444");
        var m2 = createMovie("King", "1956");
        var m3 = createMovie("Kong", "1245");
        db.addMovie("lis", m1).addMovie("lis", m2).addMovie("lis", m3);
        db.addMovie("zajac", m1).addMovie("zajac", m2);
        db.addMovie("pies", m1);
        var result = db.getTop(2);
        assertEquals(m1, result.get(0));
        assertEquals(m2, result.get(1));

    }

}

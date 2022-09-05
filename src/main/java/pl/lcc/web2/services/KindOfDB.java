/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.services;

import jakarta.ejb.Singleton;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Teresa
 */
@Singleton
//@PreferredDB
@NotPreferred
public class KindOfDB implements MovieDAO, Serializable {

    Map<String, Set<Movie>> movieDB;
    Map<String, String> users;

    public KindOfDB() {
        movieDB = new ConcurrentHashMap<>();
        users = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Movie> getMovies(String user) {
        return movieDB.get(user);
    }

    @Override
    public MovieDAO addMovie(String user, Movie m) {
        movieDB.compute(user, ((k,v) -> {v.add(m); return v;}) ); 
        return this;
    }

    @Override
    public MovieDAO createUser(String user, String password) {
        if (users.get(user) != null) {
            throw new IllegalArgumentException("user already exist");
        } else {
            users.put(user, password);
            movieDB.put(user, new HashSet<>());
            return this;
        }
    }
     
    @Override
     public String count(String user){
        return String.valueOf(movieDB.get(user).size());
     }

    @Override
    public boolean checkUser(String user, String password) {
        System.out.println("Pax: " + password + " user: " + user);
        return password.equals(users.get(user));
    }
    
    @Override
    public Set<Movie> getTop(int n){
        return movieDB.values().stream()
                .flatMap(s-> s.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> -1 * Long.compare(e1.getValue(), e2.getValue()))
                .limit(n)
                .map(entry -> entry.getKey())
                .collect(Collectors.toSet());
               
    }
}

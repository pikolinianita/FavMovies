/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import pl.lcc.web2.views.Movie;

/**
 *
 * @author Teresa
 */
@Entity
public class MovieEntity {
    
    @Id
    @GeneratedValue
    Long id; 
    
    @ManyToMany(mappedBy = "movies")
    Set<UserEntity> users;
    
    @Column(name="prod_year")
    String year;
    String title;
    
    @Column(length = 1500)
    String desc;
    String genre;
    String director;
    String posterLink;

    public MovieEntity(Movie m) {
       this.title = m.getTitle();
       this.desc = m.getDesc();
       this.director = m.getDirector();
       this.genre = m.getGenre();
       this.posterLink = m.getPosterLink();
       this.year = m.getYear();
       this.users = new HashSet<>();
    }

    public MovieEntity() {
        System.out.println("Movie Entity for Hibernate");
    }

   public Movie toMovie(){
        return new Movie(title, year, desc, genre, director, posterLink);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

       public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public Set<UserEntity> getUser() {
        return users;
    }

    public void setUser(Set<UserEntity> user) {
        this.users = user;
    }

    @Override
    public String toString() {
        return "MovieEntity{" + "id=" + id + ", users=" + users.stream().map(u -> u.getName()).collect(Collectors.toList()) + ", year=" + year + ", title=" + title + '}';
    }
    
  
    
}

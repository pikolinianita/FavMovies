/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import com.google.gson.annotations.SerializedName;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Objects;

//Po wyszukaniu filmów wyświetlają się jego 
//tytuł, krótki opis, gatunek, reżyser i plakat.
//Użytkownik ma możliwość oznaczenia film jako ulubiony.

/**
 *
 * @author Teresa
 */
@Named
public class Movie implements Serializable{
    
    private static final long serialVersionUID
            = 2L;
    @SerializedName(value="Title")
    String title;
    
    @SerializedName(value = "Year")
    String year;
    
    @SerializedName(value="Plot")
    String desc;
    
    @SerializedName(value="Genre")
    String genre;
    
    @SerializedName(value="Director")
    String director;
    
    @SerializedName(value="Poster")
    String posterLink;

    public Movie() {
    }

    public Movie(String title, String year, String desc, String genre, String director, String posterLink) {
        this.title = title;
        this.year = year;
        this.desc = desc;
        this.genre = genre;
        this.director = director;
        this.posterLink = posterLink;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.year);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.year, other.year);
    }
    
    
    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", desc=" + desc + ", genre=" + genre + ", director=" + director + ", posterLink=" + posterLink + '}';
    }

    
}

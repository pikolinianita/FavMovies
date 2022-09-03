/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.entities;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Teresa
 */
public class MovieEntity {
    @Id
    Long id;
    
    //@ManyToOne
   // UserEntity user;
    
    String year;
    String title;
    String desc;
    String genre;
    String director;
    String posterLink;
    
}

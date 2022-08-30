/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.entities;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

/**
 *
 * @author Teresa
 */
public class UserEntity {
    @Id
    long id;
    
    @OneToMany
    Set<MovieEntity> movies;
}

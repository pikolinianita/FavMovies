/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Teresa
 */
@Entity
public class UserEntity implements Serializable{
    @Id
    Long id;
    
    String name;
    String password;
    
  //  @OneToMany
  //  Set<MovieEntity> movies;

    public UserEntity(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    //    movies = new HashSet<>();
    }
    
    public UserEntity(){
        System.out.println("For Hibernate User Entity");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "id=" + id + ", name=" + name + ", password=" + password + '}';
    }
    
    
}

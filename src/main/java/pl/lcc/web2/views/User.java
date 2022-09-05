/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Teresa
 */
@Named
@SessionScoped
public class User implements Serializable {
     private static final long serialVersionUID
            = 2L;
    
    String name; 
    
       public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

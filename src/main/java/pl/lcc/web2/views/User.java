/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Set;

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
        System.out.println("getName in User: " + name); 
        return name;
    }

    public void setName(String name) {
        System.out.println("setName in User"); 
        this.name = name;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Teresa
 */
@Named
@SessionScoped
public class Accounting implements Serializable {

    private static final long serialVersionUID
            = -1110733631123457L;
    private LocalDate date;
    private String name;

    public LocalDate getDate() {
        System.out.println("getDate in Accounting: " + date); 
        return date;
    }

    public String register() {
        System.out.println("Register in Accounting"); 
        return null;
    }

    public void setDate(LocalDate date) {
        System.out.println("setDate in Accounting"); 
        this.date = date;
    }

    public String getName() {
        System.out.println("getName in Accounting: " + name); 
        return name;
    }

    public void setName(String name) {
        System.out.println("setName in Accounting"); 
        this.name = name;
    }

}

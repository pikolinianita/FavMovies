/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import Qualifiers.InMemory;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import pl.lcc.web2.services.KindOfDB;
import pl.lcc.web2.services.MovieDAO;

/**
 *
 * @author Teresa
 */
@Named
@ViewScoped
public class LoginController implements Serializable {

    String user;
    
    String password;

    @Inject       
    MovieDAO db;

    public String find() {
        
        if (db.checkUser(user, password)) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .put("user", user);

            return "user.xhtml?faces-redirect=true";
        } else {
            return null;
        }

    }

    public String getUser() {
       // System.out.println("get user");
        return user;
    }

    public void setUser(String user) {
      //  System.out.println("set user: " +  user);
        this.user = user;
    }

    public String getPassword() {
    //    System.out.println("get password");
        return password;
    }

    public void setPassword(String password) {
      //  System.out.println("set password: " + password);
        this.password = password;
    }
}

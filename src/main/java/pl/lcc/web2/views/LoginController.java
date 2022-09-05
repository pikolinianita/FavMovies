/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.lcc.web2.views;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import pl.lcc.web2.services.MovieDAO;
import pl.lcc.web2.services.annotations.PreferredDB;

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
    @PreferredDB
    MovieDAO db;

    public String find() {

        if (db.checkUser(user, password)) {
            initializeSession();
            return "user.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String createUser() {
        db.createUser(user, password);
        initializeSession();
        return "user.xhtml?faces-redirect=true";
    }

    private void initializeSession() {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .put("user", user);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

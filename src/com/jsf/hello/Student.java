package com.jsf.hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by HDMI on 12/11/2016.
 */
@ManagedBean
@SessionScoped
public class Student implements Serializable {
    private String firstname;
    private String lastname;
    private String password;
    public boolean isLogged=false;

    public Student(){
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String action(){
        isLogged = true;
        return "forum.xhtml?faces-redirect=true";
    }
}

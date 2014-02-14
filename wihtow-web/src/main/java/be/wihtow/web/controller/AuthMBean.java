package be.wihtow.web.controller;

import be.wihtow.entities.User;
import be.wihtow.services.UserBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * User session information are stored here
 *
 * @author X-L
 */
@ManagedBean
@SessionScoped
public class AuthMBean {

    @EJB
    private transient UserBean userBean;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

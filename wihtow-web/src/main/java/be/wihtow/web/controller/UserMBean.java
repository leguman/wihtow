package be.wihtow.web.controller;

import be.wihtow.entities.User;
import be.wihtow.enumeration.Group;
import be.wihtow.services.UserBean;
import be.wihtow.utils.password.Password;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author axel
 */
@ManagedBean
@RequestScoped
public class UserMBean {

    @EJB
    private transient UserBean userBean;
    @ManagedProperty(value = "#{param.id}")
    private Integer id;
    private User user;
    private List<User> users;

    @PostConstruct
    public void load() {
        if (id != null) {
            this.user = userBean.find(id);
        } else {
            this.user = userBean.create();
        }
    }

    public String save() {
        if (this.user.getId() != null) {
            userBean.save(this.user);
        } else {
            this.user.setPassword(Password.INSTANCE.encode(this.user.getPassword()));
            this.user.setIsDeleted(Boolean.FALSE);
            this.user.setSubscriptionDate(new Date());
            userBean.save(this.user);
        }
        return "users";
    }

    public String remove() {
        userBean.remove(this.user.getId());
        return "users";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = userBean.findAll();
        }
        return users;
    }

    public List<Group> getGroups() {
        return Arrays.asList(Group.values());
    }
}

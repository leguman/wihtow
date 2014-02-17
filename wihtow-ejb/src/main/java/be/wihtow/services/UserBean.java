package be.wihtow.services;

import be.wihtow.business.AbstractBean;
import be.wihtow.entities.User;
import be.wihtow.utils.password.Password;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author X-L
 */
@Stateless
public class UserBean extends AbstractBean<User> {

    @PersistenceContext
    private EntityManager em;

    public UserBean() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * 
     * @param user
     * @return NULL if credentials does not match any user
     */
    public User checkCredentials(User user) {
        if (user == null) {
            return null;
        }

        String encodedPassword = Password.INSTANCE.encode(user.getPassword());
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u where u.nickname = :nick AND u.password = :pass", User.class);
        query.setParameter("nick", user.getNickname());
        query.setParameter("pass", encodedPassword);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }
}

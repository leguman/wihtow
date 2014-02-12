package be.wihtow.services;

import be.wihtow.business.AbstractBean;
import be.wihtow.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author axel
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

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u ORDER BY u.id ASC", User.class).getResultList();
    }
}

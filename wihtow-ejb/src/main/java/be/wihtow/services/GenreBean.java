package be.wihtow.services;

import be.wihtow.business.AbstractBean;
import be.wihtow.entities.movie.Genre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author X-L
 */
@Stateless
public class GenreBean extends AbstractBean<Genre> {

    @PersistenceContext
    private EntityManager em;

    public GenreBean() {
        super(Genre.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g WHERE g.isDeleted = :false ORDER BY g.id ASC", Genre.class);
        query.setParameter("false", Boolean.FALSE);
        return query.getResultList();
    }

}

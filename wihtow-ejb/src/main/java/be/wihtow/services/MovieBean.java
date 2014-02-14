package be.wihtow.services;

import be.wihtow.business.AbstractBean;
import be.wihtow.entities.Movie;
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
public class MovieBean extends AbstractBean<Movie> {

    @PersistenceContext
    private EntityManager em;

    public MovieBean() {
        super(Movie.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Return all non-deleted movies
     *
     * @return
     */
    public List<Movie> findAll() {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.isDeleted = :false ORDER BY m.id ASC", Movie.class);
        query.setParameter("false", Boolean.FALSE);
        return query.getResultList();
    }
}

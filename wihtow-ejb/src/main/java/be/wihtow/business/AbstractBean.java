package be.wihtow.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import be.wihtow.domain.Identified;

/**
 * Contains common methods to all EJB.<br />
 * Thanks to Hildeberto Mendonca/fishe project on GitHub
 *
 * @author axel
 * @param <T>
 */
public abstract class AbstractBean<T extends Identified> {

    private static final Logger LOGGER = Logger.getLogger(AbstractBean.class.getName());
    private final Class<T> entityClass;

    public AbstractBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     * Creates an instance of the entity class. The entity class must implement
     * a default constructor.
     *
     * @return
     */
    public T create() {
        T newInstance = null;
        try {
            newInstance = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return newInstance;
    }

    public T save(T entity) {
        if (entity.getId() == null) {
            getEntityManager().persist(entity);
        } else {
            entity = getEntityManager().merge(entity);
        }
        return entity;
    }

    public void remove(Number id) {
        T entity = find(id);
        if (entity != null) {
            getEntityManager().remove(entity);
        }
    }

    public T find(Number id) {
        return getEntityManager().find(entityClass, id);
    }
}

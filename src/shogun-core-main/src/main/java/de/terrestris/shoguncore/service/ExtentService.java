package de.terrestris.shoguncore.service;

import de.terrestris.shoguncore.dao.ExtentDao;
import de.terrestris.shoguncore.model.layer.util.Extent;
import de.terrestris.shoguncore.model.module.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service class for the {@link Module} model.
 *
 * @author Nils Bühner
 * @see AbstractCrudService
 */
@Service("extentService")
public class ExtentService<E extends Extent, D extends ExtentDao<E>> extends
    PermissionAwareCrudService<E, D> {

    /**
     * Default constructor, which calls the type-constructor
     */
    @SuppressWarnings("unchecked")
    public ExtentService() {
        this((Class<E>) Extent.class);
    }

    /**
     * Constructor that sets the concrete entity class for the service.
     * Subclasses MUST call this constructor.
     */
    protected ExtentService(Class<E> entityClass) {
        super(entityClass);
    }

    /**
     * We have to use {@link Qualifier} to define the correct dao here.
     * Otherwise, spring can not decide which dao has to be autowired here
     * as there are multiple candidates.
     */
    @Override
    @Autowired
    @Qualifier("extentDao")
    public void setDao(D dao) {
        this.dao = dao;
    }
}

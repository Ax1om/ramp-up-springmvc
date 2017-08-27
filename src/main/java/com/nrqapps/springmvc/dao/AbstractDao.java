package com.nrqapps.springmvc.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by mauricio on 8/21/17.
 * NrqApps © 2017
 */
public abstract class AbstractDao<PK extends Serializable, T> implements InitializingBean, DisposableBean {

    private Logger logger;
    private Class<T> persistentClass;
    private CriteriaBuilder criteriaBuilder;
    private SessionFactory sessionFactory;
    private Session session;
    private CriteriaQuery<T> criteriaQuery;
    private Root<T> rootEntity;


    @SuppressWarnings("unchecked")
    AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        logger = Logger.getLogger(this.getClass());
    }

    public void afterPropertiesSet() {
        this.criteriaBuilder = getSession().getCriteriaBuilder();
        this.criteriaQuery = criteriaBuilder.createQuery(persistentClass);
        this.rootEntity = criteriaQuery.from(persistentClass);
    }

    private Session getSession() {
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            logger.info("Not CurrentSession found, opening new Session.........");
            session = sessionFactory.openSession();
        }
        return session;
    }

    public T findOne(PK key) {
        return getSession().get(persistentClass, key);
    }

    public List findAll() {
        return
            getSession().createQuery(
                criteriaQuery
                        .select(rootEntity)
            ).getResultList();
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void destroy() throws Exception {
        logger.info("Closing session");
        session.close();
    }

    private CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilder;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private CriteriaQuery<T> getCriteriaQuery() {
        return criteriaQuery;
    }

    private Root<T> getRootEntity() {
        return rootEntity;
    }
}
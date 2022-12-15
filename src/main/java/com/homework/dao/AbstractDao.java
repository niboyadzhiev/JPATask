package com.homework.dao;

import com.homework.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public class AbstractDao<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public AbstractDao(Class<T> entityClass) {
        this.clazz = entityClass;
    }


    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(Object id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(Object entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    public List<T> search(Object searchParam) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.fistName LIKE %:searchParam% OR " +
                "e.lastName LIKE %:searchParam% OR CONCAT(e.firstname,' ', e.lastName) LIKE %:searchParam% OR " +
                "e.employeeId LIKE %:searchParam%;")
                .setParameter("searchParam", searchParam).getResultList();
    }

    public void editByEmployee (Employee employee) {
        entityManager.merge(employee);
    }


}

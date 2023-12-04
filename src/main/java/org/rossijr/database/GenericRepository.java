package org.rossijr.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericRepository<T> implements CommonRepository {

    private final Class<T> entityType;
    private final EntityManagerFactory entityManagerFactory;
    private static final Logger logger = LoggerFactory.getLogger(GenericRepository.class);

    public GenericRepository(Class<T> entityType) {
        this.entityType = entityType;
        entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    @Override
    public Object create(Object object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            entityManager.refresh(object);
            logger.info("Entity created successfully {" + entityType.getName() + "}");
            return object;
        } catch (Exception ex) {
            logger.error("Error creating entity {" + entityType + "}", ex);
            entityManager.getTransaction().rollback();
            throw ex;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public Object getById(Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(entityType, id);
        } catch (Exception e) {
            logger.error("Error getting entity by id {" + entityType.getName() + "}", e);
            throw e;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Object> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", Object.class).getResultList();
        } catch (Exception e) {
            logger.error("Error getting all entities {" + entityType + "}", e);
            throw e;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public Object update(Object object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Object updatedObject = entityManager.merge(object);
            entityManager.getTransaction().commit();
            logger.info("Entity updated successfully {" + entityType.getName() + "}");
            return updatedObject;
        } catch (Exception e) {
            logger.error("Error updating entity {" + entityType + "}", e);
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    public boolean delete(Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Object entity = entityManager.find(entityType, id);

            if (entity != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                logger.info("Entity deleted successfully (ID: " + id.toString() + ") - {" + entityType.getName() + "}");
                return true;
            }
        } catch (Exception e) {
            logger.error("Error deleting entity (ID: " + id.toString() + ") - {" + entityType + "}", e);
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return false;
    }
}
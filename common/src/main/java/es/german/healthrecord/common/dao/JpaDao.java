package es.german.healthrecord.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import es.german.healthrecord.common.exception.EhrNotFoundException;

public abstract class JpaDao<K, E> implements Dao<K, E> {
	protected Class<E> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public JpaDao() {
		this.entityClass = this.getClazz();
	}
	
	protected abstract Class<E> getClazz();

	@Transactional
	public void persist(E entity) {
		entityManager.persist(entity);
	}

	@Transactional
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public E findById(K id) throws EhrNotFoundException {
		E entity = entityManager.find(entityClass, id);
		
		if (entity == null) {
			throw new EhrNotFoundException("Entity " + id + " Not Found"); 
		}
		
		return entity;
	}
}

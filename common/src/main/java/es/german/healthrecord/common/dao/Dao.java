package es.german.healthrecord.common.dao;

import es.german.healthrecord.common.exception.EhrNotFoundException;

public interface Dao<K, E> {
	void persist(E entity);

	void remove(E entity);

	E findById(K id) throws EhrNotFoundException;
}
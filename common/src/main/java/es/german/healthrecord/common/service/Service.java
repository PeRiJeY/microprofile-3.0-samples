package es.german.healthrecord.common.service;

import es.german.healthrecord.common.exception.EhrNotFoundException;

public interface Service<K, E> {
	void persist(E entity);
	
	void remove(E entity);

	E findById(K id) throws EhrNotFoundException;
}
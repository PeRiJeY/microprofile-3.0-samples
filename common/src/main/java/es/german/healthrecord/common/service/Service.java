package es.german.healthrecord.common.service;

public interface Service<K, E> {
	void persist(E entity);
	
	void remove(E entity);

	E findById(K id);
}
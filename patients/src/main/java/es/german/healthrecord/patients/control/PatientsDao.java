/**
 * 
 */
package es.german.healthrecord.patients.control;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.german.healthrecord.common.dao.JpaDao;
import es.german.healthrecord.common.exception.EhrMultipleResultsException;
import es.german.healthrecord.common.exception.EhrNotFoundException;
import es.german.healthrecord.common.exception.EhrException;
import es.german.healthrecord.patients.entity.EPatient;

public class PatientsDao extends JpaDao<Long, EPatient> {

	@Override
	protected Class<EPatient> getClazz() {
		return EPatient.class;
	}

	public EPatient findByNumPaciente(String numPaciente) throws EhrException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EPatient> criteria = builder.createQuery(EPatient.class);
		Root<EPatient> from = criteria.from(EPatient.class);
		criteria.select(from);
		criteria.where(builder.equal(from.get("numPaciente"), numPaciente));
		TypedQuery<EPatient> typed = entityManager.createQuery(criteria);
		try {
			return typed.getSingleResult();
		} catch (final NoResultException e) {
			throw new EhrNotFoundException("Pacient not found", e);
		} catch (final NonUniqueResultException e) {
			throw new EhrMultipleResultsException("Multiple results", e);
		} catch (RuntimeException e) {
			throw new EhrException("Unknown exception", e);
		}
	}

}
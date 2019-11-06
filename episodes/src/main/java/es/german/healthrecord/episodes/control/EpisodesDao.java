/**
 * 
 */
package es.german.healthrecord.episodes.control;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.german.healthrecord.common.dao.JpaDao;
import es.german.healthrecord.common.exception.EhrException;
import es.german.healthrecord.episodes.entity.EEpisode;

public class EpisodesDao extends JpaDao<Long, EEpisode> {

	@Override
	protected Class<EEpisode> getClazz() {
		 return EEpisode.class;
	}
	
	public List<EEpisode> findByIdPaciente(Long idPaciente) throws EhrException {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EEpisode> criteria = builder.createQuery(EEpisode.class);
		Root<EEpisode> from = criteria.from(EEpisode.class);
		criteria.select(from);
		criteria.where(builder.equal(from.get("idPaciente"), idPaciente));
		TypedQuery<EEpisode> typed = entityManager.createQuery(criteria);
		try {
			return typed.getResultList();
		} catch (RuntimeException e) {
			throw new EhrException("Unknown exception", e);
		}
	}
	
}
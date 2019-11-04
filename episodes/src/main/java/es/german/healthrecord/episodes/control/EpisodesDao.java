/**
 * 
 */
package es.german.healthrecord.episodes.control;

import es.german.healthrecord.common.dao.JpaDao;
import es.german.healthrecord.episodes.entity.Episode;

public class EpisodesDao extends JpaDao<Long, Episode> {

	@Override
	protected Class<Episode> getClazz() {
		 return Episode.class;
	}
	
}
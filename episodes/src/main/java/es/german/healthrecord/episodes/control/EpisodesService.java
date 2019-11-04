package es.german.healthrecord.episodes.control;

import javax.inject.Inject;

import es.german.healthrecord.common.mapper.EntityMapper;
import es.german.healthrecord.common.service.Service;
import es.german.healthrecord.domain.administrative.Episode;

public class EpisodesService implements Service<Long, Episode> {
	
	@Inject
	EpisodesDao episodesDao;

	private final EntityMapper<Episode, es.german.healthrecord.episodes.entity.Episode> mapper = new EntityMapper<>(Episode.class, es.german.healthrecord.episodes.entity.Episode.class);
	
	@Override
	public void persist(Episode episode) {
		es.german.healthrecord.episodes.entity.Episode entity = mapper.mapToEntity(episode);
		episodesDao.persist(entity);
		episode.setId(entity.getId());
	}

	@Override
	public void remove(Episode episode) {
		es.german.healthrecord.episodes.entity.Episode entity = mapper.mapToEntity(episode);
		episodesDao.remove(entity);
	}

	@Override
	public Episode findById(Long id) {
		es.german.healthrecord.episodes.entity.Episode entity = episodesDao.findById(id);
		return mapper.mapToDTO(entity);
	}
	
}

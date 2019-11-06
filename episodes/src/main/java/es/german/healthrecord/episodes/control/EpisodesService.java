package es.german.healthrecord.episodes.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import es.german.healthrecord.common.exception.EhrException;
import es.german.healthrecord.common.exception.EhrNotFoundException;
import es.german.healthrecord.common.mapper.EntityMapper;
import es.german.healthrecord.common.service.Service;
import es.german.healthrecord.domain.administrative.Episode;
import es.german.healthrecord.episodes.entity.EEpisode;

public class EpisodesService implements Service<Long, Episode> {
	
	@Inject
	EpisodesDao episodesDao;

	private final EntityMapper<Episode, EEpisode> mapper = new EntityMapper<>(Episode.class, EEpisode.class);
	
	@Override
	public void persist(Episode episode) {
		EEpisode entity = mapper.mapToEntity(episode);
		episodesDao.persist(entity);
		episode.setId(entity.getId());
	}

	@Override
	public void remove(Episode episode) {
		EEpisode entity = mapper.mapToEntity(episode);
		episodesDao.remove(entity);
	}

	@Override
	public Episode findById(Long id) throws EhrNotFoundException {
		EEpisode entity = episodesDao.findById(id);
		return mapper.mapToDTO(entity);
	}
	
	public List<Episode> findByNumPaciente(Long idPaciente) throws EhrException {
		List<EEpisode> lEpisodes = episodesDao.findByIdPaciente(idPaciente);
		
		List<Episode> lEpisodesResult = new ArrayList<>();
		lEpisodes.forEach(episode -> {
			lEpisodesResult.add(mapper.mapToDTO(episode));
		});
		return lEpisodesResult;
	}
	
}

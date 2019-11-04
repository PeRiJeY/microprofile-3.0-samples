package es.german.healthrecord.episodes.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import es.german.healthrecord.domain.administrative.Episode;
import es.german.healthrecord.episodes.control.EpisodesService;

@Path("/episode")
public class EpisodesRest {

	@Inject
	EpisodesService episodeService;

	@GET
	@Path("/{id}")
	public Episode get(@PathParam("id") Long id) {
		Episode episode = episodeService.findById(id);
		if (episode != null) {
			return episode;
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

	@POST
	public Long insert(Episode episode) {
		episodeService.persist(episode);
		
		return episode.getId();
	}
	
}

package es.german.healthrecord.episodes.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import es.german.healthrecord.common.exception.EhrException;
import es.german.healthrecord.common.exception.EhrNotFoundException;
import es.german.healthrecord.domain.administrative.Episode;
import es.german.healthrecord.domain.administrative.Patient;
import es.german.healthrecord.episodes.control.EpisodesService;
import es.german.healthrecord.episodes.control.PatientsService;

@Path("/episode")
public class EpisodesRest {

	@Inject
	EpisodesService episodeService;
	
	@Inject
	PatientsService patientService;

	@GET
	@Path("/{id}")
	public Episode get(@PathParam("id") Long id) throws EhrNotFoundException {
		return episodeService.findById(id);
	}

	@POST
	public Long insert(Episode episode) throws EhrException {
		try {
			Patient patient = patientService.getByNumPaciente(episode.getPaciente().getNumPaciente());
			episode.getPaciente().setId(patient.getId());
			episodeService.persist(episode);
		} catch (WebApplicationException e) {
			if (e.getResponse().getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
				throw new EhrNotFoundException("Patient not found", e);
			} else {
				throw new EhrException("Error", e);
			}
		}
		return episode.getId();
	}
	
	@GET
	@Path("")
	public List<Episode> getEpisodesByNumPatient(@QueryParam("numPaciente") String numPaciente) throws EhrException {
		Patient patient = null;
		try {
			patient = patientService.getByNumPaciente(numPaciente);
		} catch (WebApplicationException e) {
			if (e.getResponse().getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
				throw new EhrNotFoundException("Patient not found", e);
			} else {
				throw new EhrException("Error", e);
			}
		}
		
		return episodeService.findByNumPaciente(patient.getId());
	}
	
}

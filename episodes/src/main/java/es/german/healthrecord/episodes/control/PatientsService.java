package es.german.healthrecord.episodes.control;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import es.german.healthrecord.domain.administrative.Patient;

@RegisterRestClient
@ApplicationScoped
public interface PatientsService {

    @GET
    @Path("")
    Patient getByNumPaciente(@QueryParam("numPaciente") String numPaciente);

}

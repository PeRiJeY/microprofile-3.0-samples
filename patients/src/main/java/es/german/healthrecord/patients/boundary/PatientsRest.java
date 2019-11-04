package es.german.healthrecord.patients.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import es.german.healthrecord.domain.administrative.Patient;
import es.german.healthrecord.patients.control.PatientsService;

@Path("/patient")
public class PatientsRest {

	@Inject
	PatientsService patientService;

	@GET
	@Path("/{id}")
	public Patient get(@PathParam("id") Long id) {
		Patient patient = patientService.findById(id);
		if (patient != null) {
			return patient;
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

	@POST
	public Long insert(Patient patient) {
		patientService.persist(patient);
		
		return patient.getId();
	}
	
}

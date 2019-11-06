package es.german.healthrecord.patients.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import es.german.healthrecord.common.exception.EhrException;
import es.german.healthrecord.common.exception.EhrNotFoundException;
import es.german.healthrecord.domain.administrative.Patient;
import es.german.healthrecord.patients.control.PatientsService;

@Path("/patient")
public class PatientsRest {

	@Inject
	PatientsService patientService;

	@GET
	@Path("/{id}")
	public Patient getById(@PathParam("id") Long id) throws EhrNotFoundException {
		return patientService.findById(id);
	}
	
	@GET
	@Path("")
	public Patient getByNumPaciente(@QueryParam("numPaciente") String numPaciente) throws EhrException {
		return patientService.findByNumPaciente(numPaciente);
	}

	@POST
	public Long insert(Patient patient) {
		patientService.persist(patient);
		
		return patient.getId();
	}
	
}

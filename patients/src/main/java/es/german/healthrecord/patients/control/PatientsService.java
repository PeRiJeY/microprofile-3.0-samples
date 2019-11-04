package es.german.healthrecord.patients.control;

import javax.inject.Inject;

import es.german.healthrecord.common.mapper.EntityMapper;
import es.german.healthrecord.common.service.Service;
import es.german.healthrecord.domain.administrative.Patient;

public class PatientsService implements Service<Long, Patient> {
	
	@Inject
	PatientsDao patientsDao;
	
	private final EntityMapper<Patient, es.german.healthrecord.patients.entity.Patient> mapper = new EntityMapper<>(Patient.class, es.german.healthrecord.patients.entity.Patient.class);

	@Override
	public void persist(Patient patient) {
		es.german.healthrecord.patients.entity.Patient entity = mapper.mapToEntity(patient);
		patientsDao.persist(entity);
		patient.setId(entity.getId());
	}
	
	@Override
	public void remove(Patient patient) {
		es.german.healthrecord.patients.entity.Patient entity = mapper.mapToEntity(patient);
		patientsDao.remove(entity);
	}

	@Override
	public Patient findById(Long id) {
		es.german.healthrecord.patients.entity.Patient entity = patientsDao.findById(id);
		return mapper.mapToDTO(entity);
	}

}

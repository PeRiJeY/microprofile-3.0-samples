package es.german.healthrecord.patients.control;

import javax.inject.Inject;

import es.german.healthrecord.common.exception.EhrException;
import es.german.healthrecord.common.exception.EhrNotFoundException;
import es.german.healthrecord.common.mapper.EntityMapper;
import es.german.healthrecord.common.service.Service;
import es.german.healthrecord.domain.administrative.Patient;
import es.german.healthrecord.patients.entity.EPatient;

public class PatientsService implements Service<Long, Patient> {
	
	@Inject
	PatientsDao patientsDao;
	
	private final EntityMapper<Patient, EPatient> mapper = new EntityMapper<>(Patient.class, EPatient.class);

	@Override
	public void persist(Patient patient) {
		EPatient entity = mapper.mapToEntity(patient);
		patientsDao.persist(entity);
		patient.setId(entity.getId());
	}
	
	@Override
	public void remove(Patient patient) {
		EPatient entity = mapper.mapToEntity(patient);
		patientsDao.remove(entity);
	}

	@Override
	public Patient findById(Long id) throws EhrNotFoundException {
		EPatient entity = patientsDao.findById(id);
		return mapper.mapToDTO(entity);
	}
	
	public Patient findByNumPaciente(String numPaciente) throws EhrException {
		EPatient entity = patientsDao.findByNumPaciente(numPaciente);
		return mapper.mapToDTO(entity);
	}

}

/**
 * 
 */
package es.german.healthrecord.patients.control;

import es.german.healthrecord.common.dao.JpaDao;
import es.german.healthrecord.patients.entity.Patient;

public class PatientsDao extends JpaDao<Long, Patient> {

	@Override
	protected Class<Patient> getClazz() {
		return Patient.class;
	}
	
}
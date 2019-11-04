package es.german.healthrecord.patients.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EHR_D_PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
 
	@Column(name = "num_paciente")
    private String numPaciente;
	
    @Column(name = "nombre")
    private String nombre;
 
    @Column(name = "apellido1")
    private String apellido1;
    
    @Column(name = "apellido2")
    private String apellido2;
 
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumPaciente() {
		return numPaciente;
	}

	public void setNumPaciente(String numPaciente) {
		this.numPaciente = numPaciente;
	}
    	
}

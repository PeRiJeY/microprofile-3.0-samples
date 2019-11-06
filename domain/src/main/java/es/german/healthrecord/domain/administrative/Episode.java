package es.german.healthrecord.domain.administrative;

import java.util.Date;

import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.xml.bind.annotation.XmlRootElement;

import es.german.healthrecord.common.serialize.JsonDateTimeDeserializer;

@XmlRootElement
public class Episode {

    private Long id;
	
    private Patient paciente;
 
	@JsonbTypeDeserializer(JsonDateTimeDeserializer.class)
    private Date fechaIngreso;
    
    @JsonbTypeDeserializer(JsonDateTimeDeserializer.class)
    private Date fechaAlta;
    
    private String tipoEpisode;
    
    private String ufIngreso;
    
    private String ufAlta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getTipoEpisode() {
		return tipoEpisode;
	}

	public void setTipoEpisode(String tipoEpisode) {
		this.tipoEpisode = tipoEpisode;
	}

	public String getUfIngreso() {
		return ufIngreso;
	}

	public void setUfIngreso(String ufIngreso) {
		this.ufIngreso = ufIngreso;
	}

	public String getUfAlta() {
		return ufAlta;
	}

	public void setUfAlta(String ufAlta) {
		this.ufAlta = ufAlta;
	}

	public Patient getPaciente() {
		return paciente;
	}

	public void setPaciente(Patient paciente) {
		this.paciente = paciente;
	}

    
}
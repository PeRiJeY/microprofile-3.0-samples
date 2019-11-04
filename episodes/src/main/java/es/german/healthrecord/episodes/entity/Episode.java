package es.german.healthrecord.episodes.entity;

import java.util.Date;

import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import es.german.healthrecord.common.serialize.JsonDateTimeDeserializer;

@Entity
@Table(name = "EHR_D_EPISODE")
@XmlRootElement
public class Episode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "id_paciente")
    private Long idPaciente;
 
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbTypeDeserializer(JsonDateTimeDeserializer.class)
    private Date fechaIngreso;
    
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbTypeDeserializer(JsonDateTimeDeserializer.class)
    private Date fechaAlta;
    
    @Column(name = "tipo_episodio")
    private String tipoEpisodio;
    
    @Column(name = "uf_ingreso")
    private String ufIngreso;
    
    @Column(name = "uf_alta")
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

	public String getTipoEpisodio() {
		return tipoEpisodio;
	}

	public void setTipoEpisodio(String tipoEpisodio) {
		this.tipoEpisodio = tipoEpisodio;
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

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

    
}
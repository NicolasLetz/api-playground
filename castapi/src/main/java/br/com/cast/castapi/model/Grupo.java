package br.com.cast.castapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="grupo", schema="invepar")
public class Grupo {
	@Id
	@SequenceGenerator(name="idSeqGen", schema="invepar", sequenceName="seq_id_grupo", initialValue=1, allocationSize=1)
	@GeneratedValue(generator= "idSeqGen", strategy= GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="concessao", length=500, nullable= false)
	private String concessao;
	@Column(name="grupo", length=100, nullable= false)
	private String grupo;
	@Column(name="status", length=10, nullable=false)
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConcessao() {
		return concessao;
	}
	public void setConcessao(String concessao) {
		this.concessao = concessao;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

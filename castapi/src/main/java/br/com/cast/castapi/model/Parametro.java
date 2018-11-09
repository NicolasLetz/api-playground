package br.com.cast.castapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="parametro", schema="invepar")
public class Parametro {
	@Id
	@SequenceGenerator(name="idSeqGen", schema="invepar", sequenceName="id_seq_parametro", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="idSeqGen", strategy= GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="descricao", length=100, nullable=false)
	private String descricao;
	@Column(name="sigla", length=50, nullable=false)
	private String sigla;
	@Column(name="valor", length=50, nullable=false)
	private String valor;
	@Column(name="ativo", length=3, nullable=false)
	private String ativo;
	@ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="id_grupo")
	private Grupo grupo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
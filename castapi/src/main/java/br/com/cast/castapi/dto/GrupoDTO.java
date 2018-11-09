package br.com.cast.castapi.dto;

import java.util.List;

public class GrupoDTO {
	private Integer id;
	private String concessao;
	private String grupo;
	private String status;
	private List<ParametroDTO> parametros;
	
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
	public List<ParametroDTO> getParametros() {
		return parametros;
	}
	public void setParametros(List<ParametroDTO> parametros) {
		this.parametros = parametros;
	}
}

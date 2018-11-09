package br.com.cast.castapi.dto;

public class CorpoBuscaDTO {
	private String concessao;
	private String grupo;
	private String status;
	
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

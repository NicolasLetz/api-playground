package br.com.cast.castapi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.castapi.dto.GrupoDTO;
import br.com.cast.castapi.dto.ParametroDTO;
import br.com.cast.castapi.model.Parametro;
import br.com.cast.castapi.repository.GrupoRepository;
import br.com.cast.castapi.repository.ParametroRepository;

@Component
public class ParametroBusiness {

	@Autowired
	private ParametroRepository repository;
	@Autowired
	private GrupoRepository repositoryGrupo;

	@Transactional
	public void inserir(GrupoDTO dto) {
		for (ParametroDTO parametroDTO : dto.getParametros()) {
			if(parametroDTO.getAtivo() != null) {
				Parametro parametro = new Parametro();
				parametro.setAtivo(parametroDTO.getAtivo());
				parametro.setDescricao(parametroDTO.getDescricao());
				parametro.setSigla(parametroDTO.getSigla());
				parametro.setValor(parametroDTO.getValor());
				parametro.setGrupo(repositoryGrupo.buscarPorId(dto.getId()));
				repository.inserir(parametro);
		
			}
		}	
	}

	public List<ParametroDTO> filtrar(Integer id, String valor, String sigla, String descricao) {
		List<ParametroDTO> resultado = new ArrayList<>();
		List<Parametro> parametros = repository.filtrar(id, valor, sigla, descricao);
		
		for (Parametro parametro : parametros) {
			ParametroDTO dto = new ParametroDTO();
			dto.setDescricao(parametro.getDescricao());
			dto.setAtivo(parametro.getAtivo());
			dto.setId(parametro.getId());
			dto.setSigla(parametro.getSigla());
			dto.setValor(parametro.getValor());
			dto.setIdGrupo(parametro.getGrupo().getId());
			resultado.add(dto);
		}
		return resultado;
	}
	@Transactional
	public void remover(Integer id) {
		repository.remover(id);
	}
}
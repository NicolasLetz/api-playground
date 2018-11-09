package br.com.cast.castapi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.castapi.dto.GrupoDTO;
import br.com.cast.castapi.exceptions.DuplicidadeGrupoException;
import br.com.cast.castapi.model.Grupo;
import br.com.cast.castapi.repository.GrupoRepository;

@Service
public class GrupoBusiness {
	
	@Autowired
	GrupoRepository repository;
	@Autowired
	ParametroBusiness business;
	
	public List<GrupoDTO> buscarPorFiltro(String concessao, String grup, String status) {
		List<GrupoDTO> resultado = new ArrayList<>();
		Grupo g = new Grupo();
		g.setStatus(status);
		g.setGrupo(grup);
		g.setConcessao(concessao);
		List<Grupo> grupos = repository.buscarPorFiltro(g);
		for (Grupo grupo : grupos) {
			GrupoDTO dto = new GrupoDTO();
			dto.setId(grupo.getId());
			dto.setStatus(grupo.getStatus());
			dto.setConcessao(grupo.getConcessao());
			dto.setGrupo(grupo.getGrupo());
			
			resultado.add(dto);
		}
		return resultado;
	}

	public GrupoDTO buscarPorId(Integer id) {
		Grupo grupo = repository.buscarPorId(id);
		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(grupo.getId());
		grupoDto.setConcessao(grupo.getConcessao());
		grupoDto.setGrupo(grupo.getGrupo());
		grupoDto.setStatus(grupo.getStatus());
		return grupoDto;
	}
	
	@Transactional
	public void salvar(GrupoDTO dto) throws DuplicidadeGrupoException {
		Grupo grupo = new Grupo();
		grupo.setConcessao(dto.getConcessao());
		grupo.setGrupo(dto.getGrupo());
		grupo.setStatus(dto.getStatus());
		verificaDuplicidade(grupo.getGrupo());
		repository.inserir(grupo);
		grupo = repository.buscarPorGrupo(grupo.getGrupo());
		dto.setId(grupo.getId());
		business.inserir(dto);
	}

	public void verificaDuplicidade(String grupo) throws DuplicidadeGrupoException {
		if(repository.buscarPorGrupo(grupo) != null) {
			throw new DuplicidadeGrupoException();
		}
	}
	@Transactional
	public void editar(GrupoDTO dto, Integer id) {
		business.remover(id);
		business.inserir(dto);
		Grupo grupo = new Grupo();
		grupo.setConcessao(dto.getConcessao());
		grupo.setGrupo(dto.getGrupo());
		grupo.setStatus(dto.getStatus());
		grupo.setId(id);
		repository.alterar(grupo);
	}

}
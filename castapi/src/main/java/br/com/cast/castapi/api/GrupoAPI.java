package br.com.cast.castapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.castapi.business.GrupoBusiness;
import br.com.cast.castapi.dto.GrupoDTO;
import br.com.cast.castapi.exceptions.DuplicidadeGrupoException;

@RestController
@RequestMapping(path="grupo")
public class GrupoAPI {
	@Autowired
	GrupoBusiness business;
	
	@RequestMapping(path="{concessao}/{grupo}/{status}", method=RequestMethod.GET)
	public List<GrupoDTO> buscarPorFiltro(@PathVariable("concessao") String concessao, @PathVariable("grupo") String grupo, @PathVariable("status") String status) {
		return business.buscarPorFiltro(concessao, grupo, status);
	}
	@RequestMapping(path="{id}", method= RequestMethod.GET)
	public GrupoDTO buscarPorId(@PathVariable("id") Integer id) {
		return business.buscarPorId(id);
	}
	@RequestMapping(method= RequestMethod.POST)
	public void salvar(@RequestBody GrupoDTO dto) throws DuplicidadeGrupoException {
		business.salvar(dto);
	}
	@RequestMapping(path="verifica/{grupo}", method= RequestMethod.GET)
	public GrupoDTO verificaDuplicidade(@PathVariable("grupo") String grupo) throws DuplicidadeGrupoException {
		business.verificaDuplicidade(grupo);
		return new GrupoDTO();
	}
	@RequestMapping(path="{id}", method= RequestMethod.PUT)
	public void edit(@RequestBody GrupoDTO dto, @PathVariable("id") Integer id) {
		business.editar(dto, id);
	}
}
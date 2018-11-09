package br.com.cast.castapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.castapi.business.ParametroBusiness;
import br.com.cast.castapi.dto.ParametroDTO;

@RestController
@RequestMapping(path="parametro")
public class ParametroAPI {
	
	@Autowired
	ParametroBusiness business;
	
	@RequestMapping(path="{id}/{valor}/{sigla}/{descricao}", method= RequestMethod.GET)
	public List<ParametroDTO> filtrar(@PathVariable("id") Integer id, @PathVariable("valor") String valor, @PathVariable("sigla") String sigla, @PathVariable("descricao") String descricao) {
		return business.filtrar(id, valor, sigla, descricao);
	}
}

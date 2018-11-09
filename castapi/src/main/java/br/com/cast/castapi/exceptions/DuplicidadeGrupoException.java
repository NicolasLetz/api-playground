package br.com.cast.castapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicidadeGrupoException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicidadeGrupoException() {
		super("Grupo já existente");
	}
}

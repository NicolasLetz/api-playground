package br.com.cast.castapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.castapi.model.Parametro;


@Repository
public class ParametroRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void inserir(Parametro parametro) {
		em.persist(parametro);
	}

	public void alterar(Parametro parametro) {
		em.merge(parametro);
	}

	@SuppressWarnings("unchecked")
	public List<Parametro> filtrar(Integer idGrupo, String valor, String sigla, String descricao) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Parametro.class.getName()).append(" p ").append(" join fetch p.grupo WHERE 1=1 AND id_grupo = :id ");

		if(!valor.equals("null")) {
			System.out.println("PASSANDO AQUI? PORRA");
			jpql.append("AND lower(valor) LIKE :valor ");
		}
		if(!sigla.equals("null")) {
			jpql.append("AND lower(sigla) LIKE :sigla ");
		}
		if(!descricao.equals("null")) {
			jpql.append("AND lower(descricao) LIKE :descricao ");
		}
		
		Query query = em.createQuery(jpql.toString());
		
		query.setParameter("id", idGrupo);
		
		if(!valor.equals("null")) {
			query.setParameter("valor", "%"+valor.toLowerCase()+"%");
		}
		if(!sigla.equals("null")) {
			query.setParameter("sigla", "%"+sigla.toLowerCase()+"%");
		}
		if(!descricao.equals("null")) {
			query.setParameter("descricao", "%"+descricao.toLowerCase()+"%");
		}

		return query.getResultList();
	}

	public void remover(Integer id) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("DELETE FROM ").append(Parametro.class.getName()).append(" p ").append("WHERE id_grupo = :id");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", id);
		query.executeUpdate();
	}

}

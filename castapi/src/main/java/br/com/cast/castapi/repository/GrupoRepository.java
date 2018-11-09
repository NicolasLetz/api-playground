package br.com.cast.castapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.castapi.model.Grupo;

@Repository
public class GrupoRepository {

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Grupo> buscarPorFiltro(Grupo g) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Grupo.class.getName()).append(" WHERE 1=1 ");
		if(!g.getConcessao().equals( "null")) {
			jpql.append("AND concessao = :concessao ");
		}
		if(!g.getStatus().equals( "null")) {
			jpql.append("AND status = :status ");
		}
		if(!g.getGrupo().equals( "null")) {
			jpql.append("AND lower(grupo) LIKE :grupo ");
		}
		
		Query query = em.createQuery(jpql.toString());
		
		
		if(!g.getConcessao().equals( "null")) {
			query.setParameter("concessao", g.getConcessao());
		}
		if(!g.getStatus().equals( "null")) {
			query.setParameter("status", g.getStatus());
		}
		if(!g.getGrupo().equals( "null")) {
			query.setParameter("grupo", "%"+g.getGrupo().toLowerCase()+"%");
		}
		return query.getResultList();
	}
	
	public Grupo buscarPorId(Integer id) {
		return em.find(Grupo.class, id);
	}

	public void inserir(Grupo grupo) {
		em.persist(grupo);
	}
	public void alterar(Grupo grupo) {
		em.merge(grupo);
	}

	public Grupo buscarPorGrupo(String grupo) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Grupo.class.getName()).append(" WHERE lower(grupo) = :grupo");
		Query query = em.createQuery(jpql.toString());
		query.setParameter("grupo", grupo.toLowerCase());
		@SuppressWarnings("unchecked")
		List<Grupo> resultado = (List<Grupo>) query.getResultList();
		return resultado.size()>0? resultado.get(0) : null;
	}
}
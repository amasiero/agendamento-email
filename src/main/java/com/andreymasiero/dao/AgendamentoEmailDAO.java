package com.andreymasiero.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.andreymasiero.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		entityManager.merge(agendamentoEmail);
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
	}
	
	public List<AgendamentoEmail> listar() {
		return entityManager.createQuery(
					"SELECT ae FROM AgendamentoEmail ae", 
					AgendamentoEmail.class
			).getResultList();
	}
	
	public List<AgendamentoEmail> listarEmailsNaoAgendados() {
		return entityManager.createQuery(
					"SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false",
					AgendamentoEmail.class
				).getResultList();
	}	

}

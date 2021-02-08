package com.andreymasiero.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.andreymasiero.dao.AgendamentoEmailDAO;
import com.andreymasiero.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailService {

	private static final Logger LOGGER = 
			Logger.getLogger(AgendamentoEmailService.class.getName());
	
	@Inject
	private AgendamentoEmailDAO dao;
	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(true);
		dao.alterar(agendamentoEmail);
	}
	
	public void enviar(AgendamentoEmail agendamentoEmail) {
		try {
			Thread.sleep(5000);
			LOGGER.info("O e-mail da(o) usuária(o) %s foi enviado.".formatted(agendamentoEmail.getEmail()));
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}

	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmail.setAgendado(false);
		dao.inserir(agendamentoEmail);
	}

	public List<AgendamentoEmail> listar() {
		return dao.listar();
	}

	public List<AgendamentoEmail> listarEmailsNaoAgendados() {
		return dao.listarEmailsNaoAgendados();
	}

}

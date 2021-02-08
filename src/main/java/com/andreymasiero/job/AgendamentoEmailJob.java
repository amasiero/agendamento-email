package com.andreymasiero.job;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import com.andreymasiero.entity.AgendamentoEmail;
import com.andreymasiero.service.AgendamentoEmailService;

@Singleton
public class AgendamentoEmailJob {

	@Inject
	private AgendamentoEmailService service;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviar() {
		List<AgendamentoEmail> emailsNaoAgendados = service.listarEmailsNaoAgendados();
		emailsNaoAgendados.forEach(emailNaoAgendado -> {
			service.enviar(emailNaoAgendado);
			service.alterar(emailNaoAgendado);
		});
	}
}

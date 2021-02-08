package com.andreymasiero.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.andreymasiero.entity.AgendamentoEmail;
import com.andreymasiero.service.AgendamentoEmailService;

@Path("emails")
public class AgendamentoEmailController {

	@Inject
	private AgendamentoEmailService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		return Response.ok(service.listar()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(AgendamentoEmail agendamentoEmail) {
		service.inserir(agendamentoEmail);
		return Response.status(201).build();
	}
}

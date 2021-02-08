package com.andreymasiero.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreymasiero.entity.AgendamentoEmail;
import com.andreymasiero.service.AgendamentoEmailService;

@WebServlet("emails_servlet")
public class AgendamentoEmailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AgendamentoEmailService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		service.listar().forEach(
				result -> out.println(
						"A lista de emails disponiveis eh: " + result.getEmail()
						)
				);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Padrão da mensagem recebida: email, assunto, mensagem.
		BufferedReader reader = req.getReader();
		
		String[] email = reader.readLine().split(",");
		
		AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
		agendamentoEmail.setEmail(email[0]);
		agendamentoEmail.setAssunto(email[1]);
		agendamentoEmail.setMensagem(email[2]);
		
		service.inserir(agendamentoEmail);
	}

}

package com.agendamentoweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgendamentoController {
	
	
	@RequestMapping("/cadastrarAgendamento")
	public String form() {
		return "agendamento/formAgendamento";
	}

}

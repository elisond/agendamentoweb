package com.agendamentoweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agendamentoweb.models.Agendamento;
import com.agendamentoweb.repository.AgendamentoRepository;

@Controller
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository ar;
	
	@RequestMapping(value="/cadastrarAgendamento", method=RequestMethod.GET)
	public String form() {
		return "agendamento/formAgendamento";
	}
	
	@RequestMapping(value="/cadastrarAgendamento", method=RequestMethod.POST)
	public String form(Agendamento agendamento) {
		
		ar.save(agendamento);
		
		return "redirect:/cadastrarAgendamento";
	}
	
	@RequestMapping("/agendamentos")
	public ModelAndView listaAgendamentos() {
	    ModelAndView mv = new ModelAndView("agendamento/listaAgendamentos");
	    Iterable<Agendamento> agendamentos = ar.findAll();
	    mv.addObject("agendamentos", agendamentos);
	    return mv;
	}
	
	@RequestMapping("/deletarAgendamento")
	public String deletarAgendamento(@RequestParam("codigo") long codigo){
	    Agendamento agendamento = ar.findByCodigo(codigo);
	    ar.delete(agendamento);
	    return "redirect:/agendamentos";
	}


	
}

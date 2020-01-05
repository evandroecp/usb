package com.ubs.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.teste.services.TesteAmbienteService;

@RestController
public class TesteAmbienteController {

	@Autowired
	private TesteAmbienteService _testeAmbienteServices;

	@RequestMapping(value = "/testeAmbiente", method = RequestMethod.GET)
	public String testeAmbiente() {
		return _testeAmbienteServices.testeAmbiente();
	}
	
}

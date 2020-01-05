package com.ubs.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.teste.services.AcessoBancoService;

@RestController
public class AcessoBancoController {

	@Autowired
	private AcessoBancoService _acessoBancoServices;

	@RequestMapping(value = "/conectarBanco", method = RequestMethod.GET)
	public String conectarBanco() {
		return _acessoBancoServices.ConnectBanco();
	}
	
	@RequestMapping(value = "/criarTabela", method = RequestMethod.GET)
	public String criarTabela() {
		return _acessoBancoServices.criarTabela();
	}

}

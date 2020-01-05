package com.ubs.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.teste.services.CalculoService;

@RestController
public class CalculoController {
	
	@Autowired
	private CalculoService _calculoServices;

	@RequestMapping(value = "/calculo", method = RequestMethod.GET)
	public String calculo(@RequestParam("produto") String produto,
			              @RequestParam("qtdelojas") int qtdeLojas) {
		return _calculoServices.calculo(produto, qtdeLojas);
	}
}

package com.ubs.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.teste.services.DataService;

@RestController
public class DataController {

	@Autowired
	private DataService _dataServices;

	@RequestMapping(value = "/carregaArquivos", method = RequestMethod.GET)
	public String carregaArquivos() {
		return _dataServices.cargaArquivos();
	}

}

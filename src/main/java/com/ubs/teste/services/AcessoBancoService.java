package com.ubs.teste.services;

import org.springframework.stereotype.Service;

import com.ubs.teste.config.CriarTabela;
import com.ubs.teste.config.SQLiteJDBCDriverConnection;

@Service
public class AcessoBancoService {

	public String ConnectBanco() {
		return SQLiteJDBCDriverConnection.connect();
	}
	
	public String criarTabela() {
		return CriarTabela.criarTabelaData();
	}
}

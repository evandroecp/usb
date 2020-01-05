package com.ubs.teste.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LojistaDTO {
	
	private String nome;
	private int qtde;
	private Double valorTotal = new Double("0");
	private Double precoMedio = new Double("0");
	private List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();

}
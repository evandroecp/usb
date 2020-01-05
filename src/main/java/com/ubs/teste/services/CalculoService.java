package com.ubs.teste.services;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ubs.teste.dto.LojistaDTO;
import com.ubs.teste.dto.ProdutoDTO;
import com.ubs.teste.entity.Data;
import com.ubs.teste.repository.DataRepository;

@Service
public class CalculoService {
	
	@Resource
	DataRepository dataRepository;
	
	DecimalFormat decimalFormat = new DecimalFormat();
	
	
	public String calculo(String produto, int qtdeLojas) {
		String retorno = "<html>";
		Map<String, LojistaDTO> listaLojistaConsolidado = new HashMap<String, LojistaDTO>();
		
		if (qtdeLojas > 0) {
			
			decimalFormat.setMinimumFractionDigits(2);
			
			List<Data> listaCalculo = Lists.newArrayList();
			listaCalculo = dataRepository.getPesquisaCalculo(produto);
			
			listaLojistaConsolidado = fazerDivisao(listaCalculo, qtdeLojas);
			
			for(Map.Entry<String, LojistaDTO> entry : listaLojistaConsolidado.entrySet()) {
			    retorno = retorno + "<br />" + "Nome: " + entry.getValue().getNome() +
			    		"<br />" + "Qtde: " + entry.getValue().getQtde() +
			    		"<br />" + "Financeiro: " + decimalFormat.format(entry.getValue().getValorTotal()) +
			    		"<br />" + "Preço Médio: " + decimalFormat.format(entry.getValue().getPrecoMedio()) ;
			    
			    for (ProdutoDTO produtos : entry.getValue().getProdutos()) {
			    	retorno = retorno + "<br />" + produtos.getNomeProduto() +
			    			 "<br />" + produtos.getPreco() + 
			    			 "<br />" + produtos.getQuantidade() + 
			    			 "<br />" + produtos.getVolume();
			    }
			    
			}
		} else {
				retorno = retorno + "Quantidade de Lojistas tem que ser maior que zero";
		}
		
		return retorno + "</html>";
	}
	
	
	public Map<String, LojistaDTO> fazerDivisao(List<Data> lstData, int qtdeLojas) {
		Map<String, LojistaDTO> listaLojistaConsolidado = new HashMap<String, LojistaDTO>();
		decimalFormat.setMinimumFractionDigits(2);
		boolean inverte = true;
		boolean lojaPar = false;
		
		for (Data data: lstData) {
			int intResto = data.getQuantity() % qtdeLojas;
			int intDiv = data.getQuantity() / qtdeLojas;
			int intLojasSob = qtdeLojas - intResto;
			int intContadorLojas = 0;
			
			while (intResto > 0) {
				ProdutoDTO produto = new ProdutoDTO();
				produto.setNomeProduto(data.getProduct());
				if (inverte) {
					produto.setQuantidade(intDiv + 1);
					inverte = false;
					lojaPar = false;
				} else { 
					produto.setQuantidade(intDiv);
					lojaPar = true;
					inverte = true;
				}
				produto.setPreco(data.getPrice());
				produto.setVolume(decimalFormat.format(produto.getQuantidade() * Double.parseDouble(data.getPrice())));
				intResto--;
				intContadorLojas ++;
				LojistaDTO list = new LojistaDTO();
				list.setNome("loja" + intContadorLojas);
				
				if(listaLojistaConsolidado.containsKey(list.getNome())) {
					LojistaDTO lojista = listaLojistaConsolidado.get(list.getNome());
					lojista.setValorTotal(lojista.getValorTotal() + (Double.parseDouble(produto.getPreco()) * produto.getQuantidade()));
					lojista.setQtde(lojista.getQtde() + produto.getQuantidade());
					lojista.setPrecoMedio(lojista.getValorTotal() / lojista.getQtde());
					lojista.getProdutos().add(produto);
				}else {
					list.setValorTotal(Double.parseDouble(produto.getPreco()) * produto.getQuantidade());
					list.setQtde(produto.getQuantidade());
					list.setPrecoMedio(list.getValorTotal() / list.getQtde());
					list.getProdutos().add(produto);
					listaLojistaConsolidado.put(list.getNome(), list);
				}
				
			}
			while (intLojasSob > 0) {
				ProdutoDTO produto = new ProdutoDTO();
				produto.setNomeProduto(data.getProduct());
				if (lojaPar) {
					produto.setQuantidade(intDiv + 1);
					inverte = true;
					lojaPar = false;
				} else { 
					produto.setQuantidade(intDiv);
				}
				produto.setPreco(data.getPrice());
				produto.setVolume(decimalFormat.format(produto.getQuantidade() * Double.parseDouble(data.getPrice())));
				intLojasSob--;
				intContadorLojas ++;
				LojistaDTO list = new LojistaDTO();
				list.setNome("loja" + intContadorLojas);
				
				if(listaLojistaConsolidado.containsKey(list.getNome())) {
					LojistaDTO lojista = listaLojistaConsolidado.get(list.getNome());
					lojista.setValorTotal(lojista.getValorTotal() + (Double.parseDouble(produto.getPreco()) * produto.getQuantidade()));
					lojista.setQtde(lojista.getQtde() + produto.getQuantidade());
					lojista.setPrecoMedio(lojista.getValorTotal() / lojista.getQtde());
					lojista.getProdutos().add(produto);
				}else {
					list.setValorTotal(Double.parseDouble(produto.getPreco()) * produto.getQuantidade());
					list.setQtde(produto.getQuantidade());
					list.setPrecoMedio(list.getValorTotal() / list.getQtde());
					list.getProdutos().add(produto);
					listaLojistaConsolidado.put(list.getNome(), list);
				}
			}
		}	
		
		return listaLojistaConsolidado;
	}

}
 
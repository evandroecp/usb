package com.ubs.teste.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.ubs.teste.entity.Data;
import com.ubs.teste.repository.DataRepository;
import com.ubs.teste.vo.DataVO;
import com.ubs.teste.vo.LdataVO;

@Service
public class DataService {
	
	@Value("${path.arquivo.json}")
	private String path;
	
	@Resource
	DataRepository dataRepository;

	@Async
	@SuppressWarnings("static-access")
	public String cargaArquivos() {
		
		String retorno = "";
		int contRegistros = 0;
		int contRegistrosInseridos = 0;
		List<Data> listData = Lists.newArrayList();
		List<Data> listDataMem = Lists.newArrayList();
		
		try {
			Gson gson = new Gson();
			
			File diretorio = new File(this.path);
			File[] arquivos = diretorio.listFiles (new FileFilter() {
	            public boolean accept(File pathname) {
	                return pathname.getName().toLowerCase().endsWith(".json");
	            } 
	        });
			
			listData = dataRepository.findAll();
			
			for(int i = 0; i < arquivos.length; i++){
				BufferedReader br = new BufferedReader(new FileReader(arquivos[i].toString()));
				LdataVO data = gson.fromJson(br, LdataVO.class);
				
				for (DataVO dataVO: data.getData()) {
					Data d = carregaRegistro(dataVO);
					
					// busca o registro na base
		            //Data consulta = dataRepository.getPesquisaData(d.getProduct(), d.getQuantity(), 
		            //		                                      d.getPrice(), d.getType(), 
		            //		                                      d.getIndustry(), d.getOrigin());
		            
					Optional<Data> lDataMem = listDataMem.stream().filter(item -> item.getProduct().equals(d.getProduct()))
		    				.filter(item -> item.getQuantity() == d.getQuantity())
		    				.filter(item -> item.getPrice().equals(d.getPrice()))
		    				.filter(item -> item.getType().equals(d.getType()))
		    				.filter(item -> item.getIndustry().equals(d.getIndustry()))
		    				.filter(item -> item.getOrigin().equals(d.getOrigin()))
		      				.findFirst();

					
	            	if (!lDataMem.isPresent()) {
	            			listDataMem.add(d);
	            			Optional<Data> lData = listData.stream().filter(item -> item.getProduct().equals(d.getProduct()))
		            				.filter(item -> item.getQuantity() == d.getQuantity())
		            				.filter(item -> item.getPrice().equals(d.getPrice()))
		            				.filter(item -> item.getType().equals(d.getType()))
		            				.filter(item -> item.getIndustry().equals(d.getIndustry()))
		            				.filter(item -> item.getOrigin().equals(d.getOrigin()))
		              				.findFirst();
	            		if (!lData.isPresent()) {
		            		// senão encontrou, faz um insert
		            		dataRepository.save(d);
		            		contRegistrosInseridos++;
	            		}
	            	} 
				}
				System.out.println(data.getData().length);
				contRegistros+= data.getData().length;
				br.close();
				arquivos[i].renameTo(new File(diretorio + "/processado/", arquivos[i].getName()));
			}
			retorno = "Processado: " + contRegistros + " registros e inseridos: " + contRegistrosInseridos;
		}
		catch (Exception e) {
			e.printStackTrace();
			retorno = "Arquivo fora do padrão, teremos que analisar!!!";
		}
		return retorno;
	}
	
	public Data carregaRegistro(DataVO dados ) {
		Data d = new Data();
		d.setProduct(dados.getProduct());
		d.setQuantity(dados.getQuantity());
		d.setPrice(dados.getPrice());
		d.setType(dados.getType());
		d.setIndustry(dados.getIndustry());
		d.setOrigin(dados.getOrigin());
		return d;
	}
}

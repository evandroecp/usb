package com.ubs.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Configuration
@EnableAsync
public class TesteUbsApplication {
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TesteUbsApplication.class, args);
		
		String pathIN; 
        String pathOUT;
         
        Properties prop = getProp();
         
        pathIN = prop.getProperty("path.criarestruturadiretorioIN");
        pathOUT = prop.getProperty("path.criarestruturadiretorioOUT");
		
		criarEstruturaDiretorio(pathIN, pathOUT);
	}
	
	public static void criarEstruturaDiretorio(String IN, String OUT) {
		File diretorio = new File(IN); 
		if (!diretorio.exists()) { 
			diretorio.mkdirs(); 
		} else { 
			System.out.println("Diretório IN já existente"); 
		}
		diretorio = new File(OUT); 
		if (!diretorio.exists()) { 
			diretorio.mkdirs(); 
		} else { 
			System.out.println("Diretório OUT já existente"); 
		}
	}

	public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + ("/target/classes/application.properties"));
        props.load(file);
        return props;
 
    }
}

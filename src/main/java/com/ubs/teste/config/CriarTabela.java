package com.ubs.teste.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
	
	public static String criarTabelaData() {
		String resultado = "erro";
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {

            System.out.println("Conexão realizada !!!!");

            Statement statement = connection.createStatement();

            // criando uma tabela
            statement.execute("CREATE TABLE IF NOT EXISTS data(id INTEGER, "
                    + "product VARCHAR, "
                    + "quantity VARCHAR, "
                    + "price VARCHAR, "
                    + "type VARCHAR, "
                    + "industry VARCHAR, "
                    + "origin VARCHAR)");

            System.out.println("Tabela Criada !!!!");
            resultado = "Tabela Criada !!!!";

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resultado = e.getMessage();
		}
		return resultado;
	}

}

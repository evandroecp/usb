package com.ubs.teste.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBCDriverConnection {

	public static String connect() {
		String resultado = "erro";
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {

            System.out.println("Conexão realizada !!!!");

            resultado = "Conexão realizada !!!!";
            
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resultado = e.getMessage();
		}
		return resultado;
	}
}

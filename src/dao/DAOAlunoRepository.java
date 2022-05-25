package dao;

import java.sql.Connection;

import connection.SingleConnection;
import model.ModelAluno;

public class DAOAlunoRepository {
	
	private Connection connection;
	
	public DAOAlunoRepository() {
		
		connection = SingleConnection.getConnection();
	}
	

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import connection.SingleConnection;
import model.ModelAluno;

public class DAOAlunoRepository {
	
	private Connection connection;
	
	public DAOAlunoRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	public void gravarAlunos(ModelAluno alunos) {
		
		try {
			
			String sql = "insert into TbAluno(Nome,Telefone,Cpf,Cep,Logradouro,Numero,Bairro,"
					+ "Cidade,UF)values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, alunos.getNome());
			insert.setString(2, alunos.getTelefone());
			insert.setString(3, alunos.getCpf());
			insert.setString(4, alunos.getCep());
			insert.setString(5, alunos.getLogradouro());
			insert.setString(6, alunos.getNumero());
			insert.setString(7, alunos.getBairro());
			insert.setString(8, alunos.getCidade());
			insert.setString(9, alunos.getUf());
			
			insert.execute();
			
			connection.commit();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}

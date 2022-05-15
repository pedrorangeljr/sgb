package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnection;
import model.ModelFuncionario;

public class DAOFuncionarioRepository {

	private Connection connection;
	
	public DAOFuncionarioRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo Salvar*/
	
	public void gravarFuncionario(ModelFuncionario mf) {
		
		try {
			
			String sql = "insert into TbFuncionario(Nome,Telefone,Cpf,Cep,Logradouro,Numero,Bairro,"
					+ "Cidade,UF,Senha,Login)values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, mf.getNome());
			insert.setString(2, mf.getTelefone());
			insert.setString(3, mf.getCpf());
			insert.setString(4, mf.getCep());
			insert.setString(5, mf.getLogradouro());
			insert.setString(6, mf.getNumero());
			insert.setString(7, mf.getBairro());
			insert.setString(8, mf.getCidade());
			insert.setString(9, mf.getUf());
			insert.setString(10, mf.getSenha());
			insert.setString(11, mf.getLogin());
			
			insert.execute();
			
			connection.commit();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
}

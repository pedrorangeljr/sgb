package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;
import model.ModelFuncionario;

public class DAOFuncionarioRepository {

	private Connection connection;
	
	public DAOFuncionarioRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo Salvar*/
	
	public ModelFuncionario gravarFuncionario(ModelFuncionario mf) throws Exception {
		
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
		
		/*Já faz a consulta depois que grava*/
		return this.consultafuncionario(mf.getLogin());
	}
	
	public ModelFuncionario consultafuncionario(String login) throws Exception {
		
		ModelFuncionario mf = new ModelFuncionario();
		
		String sql = "select * from TbFuncionario where upper(Login) = upper('"+login+"')";
		PreparedStatement consulta = connection.prepareStatement(sql);
		
		ResultSet resultado = consulta.executeQuery();
		
		while(resultado.next()) {
			
			mf.setIdFuncionario(resultado.getLong("idFuncionario"));
			mf.setNome(resultado.getString("Nome"));
			mf.setTelefone(resultado.getString("Telefone"));
			mf.setCpf(resultado.getString("Cpf"));
			mf.setCep(resultado.getString("Cep"));
			mf.setLogradouro(resultado.getString("Logradouro"));
			mf.setNumero(resultado.getString("Numero"));
			mf.setBairro(resultado.getString("Bairro"));
			mf.setCidade(resultado.getString("Cidade"));
			mf.setUf(resultado.getString("UF"));
			mf.setSenha(resultado.getString("Senha"));
			mf.setLogin(resultado.getString("Login"));
		}
		
		return mf;
	}
}

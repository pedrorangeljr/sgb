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

	/* Metodo Salvar */

	public ModelFuncionario gravarFuncionario(ModelFuncionario mf) throws Exception {

		try {
			
			if(mf.isNovo()) {

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
			
			}
			else {
				
				String sql = "update TbFuncionario set Nome =?, Telefone =?, Cpf =?, Cep =?,"
						+ "Logradouro =?, Numero =?, Bairro =?, Cidade =?, UF =?, Senha =?, Login =? "
						+ "where idFuncinario = "+mf.getIdFuncionario()+"";
				PreparedStatement update = connection.prepareStatement(sql);
				
				update.setString(1, mf.getNome());
				update.setString(2, mf.getTelefone());
				update.setString(3, mf.getCpf());
				update.setString(4, mf.getCep());
				update.setString(5, mf.getLogradouro());
				update.setString(6, mf.getNumero());
				update.setString(7, mf.getBairro());
				update.setString(8, mf.getCidade());
				update.setString(9, mf.getUf());
				update.setString(10, mf.getSenha());
				update.setString(11, mf.getLogin());
				
				update.executeUpdate();
				
				connection.commit();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		/* Já faz a consulta depois que grava */
		return this.consultafuncionario(mf.getLogin());
	}

	public ModelFuncionario consultafuncionario(String login) throws Exception {

		ModelFuncionario mf = new ModelFuncionario();

		String sql = "select * from TbFuncionario where upper(Login) = upper('" + login + "')";
		PreparedStatement consulta = connection.prepareStatement(sql);

		ResultSet resultado = consulta.executeQuery();

		while (resultado.next()) {

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

	public boolean validaLogin(String login) throws Exception {

		String sql = "select count(1) > 0 as existe from TbFuncionario where upper(login) = upper('" + login + "')";
		PreparedStatement validar = connection.prepareStatement(sql);

		ResultSet resultado = validar.executeQuery();

		resultado.next();

		return resultado.getBoolean("existe");

	}

}

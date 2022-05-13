package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;
import model.ModelLogin;

public class DAOLoginRepository {
	
	private Connection connection;
	
	public DAOLoginRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	public boolean  validarAutenticacao(ModelLogin modelLogin) throws Exception {
		
		String sql = "Select * from TbFuncionario where upper(Login) = upper(?) and upper(Senha) = upper(?) ";
		PreparedStatement validar = connection.prepareStatement(sql);
		
		validar.setString(1, modelLogin.getLogin());
		validar.setString(2, modelLogin.getSenha());
		
		ResultSet resultado = validar.executeQuery();
		
		if(resultado.next()) {
			
			return true;
		}
		
		return false;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.ModelAluno;

public class DAOAlunoRepository {

	private Connection connection;

	public DAOAlunoRepository() {

		connection = SingleConnection.getConnection();
	}

	public ModelAluno gravarAlunos(ModelAluno alunos) throws Exception {

		
		try {

			if(alunos.isNovo()) {
				
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
		}
			else {
				
				String sql = "update TbAluno set Nome=?, Telefone=?, Cpf=?, Cep=?, Logradouro=?, Numero=?,"
						+ "Bairro=?, Cidade=?, UF=? where idAluno = "+alunos.getIdAluno()+"";
				PreparedStatement update = connection.prepareStatement(sql);
				
				update.setString(1, alunos.getNome());
				update.setString(2, alunos.getTelefone());
				update.setString(3, alunos.getCpf());
				update.setString(4, alunos.getCep());
				update.setString(5, alunos.getLogradouro());
				update.setString(6, alunos.getNumero());
				update.setString(7, alunos.getBairro());
				update.setString(8, alunos.getCidade());
				update.setString(9, alunos.getUf());
				
				update.executeUpdate();
				
				connection.commit();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return this.consultaAluno(alunos.getCpf()); // chamada do metodo consultar Aluno.
	}
	
	/*Metodo de Pesquisa do Modal*/
	
    public List<ModelAluno> consultarAlunoList(String nome) throws Exception{
    	
    	List<ModelAluno> retorno = new ArrayList<ModelAluno>();
    	
    	String sql = "select * from TbAluno where upper(Nome) like upper(?)";
    	PreparedStatement consultar = connection.prepareStatement(sql);
    	consultar.setString(1, "%" + nome + "%");
    	
    	ResultSet resultado = consultar.executeQuery();
    	
    	while(resultado.next()) {
    		
    		ModelAluno aluno = new ModelAluno();
    		
    		aluno.setIdAluno(resultado.getLong("idAluno"));
			aluno.setNome(resultado.getString("Nome"));
			aluno.setTelefone(resultado.getString("Telefone"));
			aluno.setCpf(resultado.getString("Cpf"));
			aluno.setCep(resultado.getString("Cep"));
			aluno.setLogradouro(resultado.getString("Logradouro"));
			aluno.setNumero(resultado.getString("Numero"));
			aluno.setBairro(resultado.getString("Bairro"));
			aluno.setCidade(resultado.getString("Cidade"));
			aluno.setUf(resultado.getString("UF"));
			
			retorno.add(aluno);
    	}
    	
    	return retorno;
    }

	/* Faz a consulta depois que grava */

	public ModelAluno consultaAluno(String cpf) throws Exception {

		ModelAluno aluno = new ModelAluno();

		String sql = "select * from TbAluno where upper(Cpf) = upper('" + cpf + "')";
		PreparedStatement consulta = connection.prepareStatement(sql);

		ResultSet resultado = consulta.executeQuery();

		while (resultado.next()) {

			aluno.setIdAluno(resultado.getLong("idAluno"));
			aluno.setNome(resultado.getString("Nome"));
			aluno.setTelefone(resultado.getString("Telefone"));
			aluno.setCpf(resultado.getString("Cpf"));
			aluno.setCep(resultado.getString("Cep"));
			aluno.setLogradouro(resultado.getString("Logradouro"));
			aluno.setNumero(resultado.getString("Numero"));
			aluno.setBairro(resultado.getString("Bairro"));
			aluno.setCidade(resultado.getString("Cidade"));
			aluno.setUf(resultado.getString("UF"));

		}

		return aluno;
	}

	/* Metodo que deixar gravar aluno com o mesmo CPF */

	public boolean validarCpf(String cpf) throws Exception {

		String sql = "select count(1) > 0 existe from TbAluno where upper(Cpf) = upper('" + cpf + "')";
		PreparedStatement validar = connection.prepareStatement(sql);

		ResultSet resultado = validar.executeQuery();
		
		resultado.next();

		return resultado.getBoolean("existe");

	}

	/* Metodo deletar aluno */
	public void deletarAluno(String idAluno) throws Exception {

		String sql = "delete from TbAluno where idAluno = ?";
		PreparedStatement deletar = connection.prepareStatement(sql);

		deletar.setLong(1, Long.parseLong(idAluno));

		deletar.executeUpdate();

		connection.commit();
	}
}

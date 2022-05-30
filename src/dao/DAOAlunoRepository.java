package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;
import model.ModelAluno;

public class DAOAlunoRepository {
	
	private Connection connection;
	
	public DAOAlunoRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	public ModelAluno gravarAlunos(ModelAluno alunos) throws Exception {
		
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
		
		return this.consultaAluno(alunos.getCpf()); // chamada do metodo consultar Aluno.
	}
	
	/*Faz a  consulta depois que grava*/
	
	public ModelAluno consultaAluno(String cpf) throws Exception{
		
		ModelAluno aluno = new ModelAluno();
		
		String sql = "select * from TbAluno where upper(Cpf) = upper('"+cpf+"')";
		PreparedStatement consulta = connection.prepareStatement(sql);
		
		ResultSet resultado = consulta.executeQuery();
		
		while(resultado.next()) {
			
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

	/*Metodo deletar aluno*/
	public void deletarAluno(String idAluno) throws Exception {
		
		String sql = "delete from TbAluno where idAluno = ?";
		PreparedStatement deletar = connection.prepareStatement(sql);
		
		deletar.setLong(1, Long.parseLong(idAluno));
		
		deletar.executeUpdate();
		
		connection.commit();
	}
}

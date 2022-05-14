package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelFuncionario;


@WebServlet("/ServletFuncionario")
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletFuncionario() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String idFuncionario = request.getParameter("idFuncionario");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String cpf = request.getParameter("cpf");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String uf = request.getParameter("uf");
			
			ModelFuncionario mf = new ModelFuncionario(); // mf = objeto modelFuncionario
			
			
			mf.setNome(nome);
			mf.setTelefone(telefone);
			mf.setLogin(login);
			mf.setSenha(senha);
			mf.setCpf(cpf);
			mf.setCep(cep);
			mf.setLogradouro(logradouro);
			mf.setNumero(numero);
			mf.setBairro(bairro);
			mf.setCidade(cidade);
			mf.setUf(uf);
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}

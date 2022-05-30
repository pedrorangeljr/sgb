package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOAlunoRepository;
import model.ModelAluno;


@WebServlet("/ServletAluno")
public class ServletAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private DAOAlunoRepository daoAlunoRepository = new DAOAlunoRepository();
    
    public ServletAluno() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String idAluno = request.getParameter("idAluno");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String cpf = request.getParameter("cpf");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String uf = request.getParameter("uf");
			
			ModelAluno alunos = new ModelAluno();
			
			alunos.setIdAluno(idAluno != null && !idAluno.isEmpty() ? Long.parseLong(idAluno) : null);
			alunos.setNome(nome);
			alunos.setTelefone(telefone);
			alunos.setCpf(cpf);
			alunos.setCep(cep);
			alunos.setLogradouro(logradouro);
			alunos.setNumero(numero);
			alunos.setBairro(bairro);
			alunos.setCidade(cidade);
			alunos.setUf(uf);
			
			alunos = daoAlunoRepository.gravarAlunos(alunos);
			request.setAttribute("alunos", alunos);
			request.getRequestDispatcher("principal/alunos.jsp").forward(request, response);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}

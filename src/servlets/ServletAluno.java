package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		try {
			
			String acao = request.getParameter("acao");
			
			if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {
				
				String idAluno = request.getParameter("idAluno");
				
				daoAlunoRepository.deletarAluno(idAluno);
				
				request.setAttribute("msg", "Deletado com Sucesso");
			}
			
			else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarAlunoAjax")) {
				
				String nomeBusca = request.getParameter("nomeBusca");
				
				List<ModelAluno> dadosJsonAluno =  daoAlunoRepository.consultarAlunoList(nomeBusca);
				
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(dadosJsonAluno);
				
				response.getWriter().write(json); 
				
			}
		
			else {
				
				request.getRequestDispatcher("principal/alunos.jsp").forward(request, response);
			}
		
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String msg = "Operação realizada com sucesso";
			
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
			
			if(daoAlunoRepository.validarCpf(alunos.getCpf()) && alunos.getIdAluno() == null) {
				
				msg = "Já existe Aluno com o mesmo CPF, informe outro CPF";
			}
			else {
				if(alunos.isNovo()) {
					
					msg="Gravado co Sucesso";
				}
				else {
					
					msg="Atualizado com Sucesso";
				}
				
				alunos = daoAlunoRepository.gravarAlunos(alunos);
				
			}
			
			
			request.setAttribute("msg", msg);
			request.setAttribute("alunos", alunos);
			request.getRequestDispatcher("principal/alunos.jsp").forward(request, response);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}

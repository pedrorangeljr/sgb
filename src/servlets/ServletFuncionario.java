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

import dao.DAOFuncionarioRepository;
import model.ModelFuncionario;

@WebServlet("/ServletFuncionario")
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOFuncionarioRepository daoFuncionarioRepository = new DAOFuncionarioRepository();

	public ServletFuncionario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String acao = request.getParameter("acao");

			if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {

				String idFuncionario = request.getParameter("idFuncionario");

				daoFuncionarioRepository.deletarFuncionario(idFuncionario);

				request.setAttribute("msg", "Deletado com Sucesso");

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarFuncionarioAjax")) {

				String nomeBusca = request.getParameter("nomeBusca");

				List<ModelFuncionario> dadosJsonMf = daoFuncionarioRepository.consultaFuncionarioList(nomeBusca);

				ObjectMapper mapper = new ObjectMapper();

				String json = mapper.writeValueAsString(dadosJsonMf);

				response.getWriter().write(json);

			} else if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarEditar")) {
				
				String idFuncionario = request.getParameter("idFuncionario");
				
				ModelFuncionario mf = daoFuncionarioRepository.consultafuncionarioID(idFuncionario);
				
				request.setAttribute("msg", "Funcionário em edição");
				request.setAttribute("mf", mf);
				request.getRequestDispatcher("principal/funcionarios.jsp").forward(request, response);

			} else {

				request.getRequestDispatcher("principal/funcionarios.jsp").forward(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();

			RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String msg = "Operação Realizada com sucesso";

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

			mf.setIdFuncionario(
					idFuncionario != null && !idFuncionario.isEmpty() ? Long.parseLong(idFuncionario) : null);
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

			if (daoFuncionarioRepository.validaLogin(mf.getLogin()) && mf.getIdFuncionario() == null) {

				msg = "Já existe funcionário com o mesmo login, informe outro login";
			} else {
				if (mf.isNovo()) {

					msg = "Gravado com Sucesso";
				} else {

					msg = "Atualizado com sucesso";
				}

				mf = daoFuncionarioRepository.gravarFuncionario(mf);
			}

			request.setAttribute("msg", msg);
			request.setAttribute("mf", mf);
			request.getRequestDispatcher("principal/funcionarios.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

			RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}

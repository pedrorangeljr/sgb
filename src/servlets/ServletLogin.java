package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLoginRepository;
import model.ModelLogin;


@WebServlet(urlPatterns = {"/principal/ServletLogin", "/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
 
    public ServletLogin() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String url = request.getParameter("url");
			
			if(login != null && !login.isEmpty() && senha !=null  && !senha.isEmpty()) {
				
				ModelLogin modelLogin = new ModelLogin();
				
				modelLogin.setLogin(login);
				modelLogin.setSenha(senha);
				
				if(daoLoginRepository.validarAutenticacao(modelLogin)) {
					
					request.getSession().setAttribute("usuario", modelLogin.getLogin());
					
					if (url == null || url.equals("null")) {
						url = "principal/principal.jsp";
					}
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
					
				}
				else {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					request.setAttribute("msg", "Informe Login e/ou Senha corretamente");
					dispatcher.forward(request, response);
				}
			}
			else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe Login e/ou Senha corretamente");
				dispatcher.forward(request, response);
			}
			
			
			
		}catch(Exception e) {
			
			
		}
	}

}

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import model.ModelLogin;


@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletLogin() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			if(login != null && !login.isEmpty() && senha !=null  && !senha.isEmpty()) {
				
				ModelLogin modelLogin = new ModelLogin();
				
				modelLogin.setLogin(login);
				modelLogin.setSenha(senha);
				
				if(modelLogin.getLogin().equalsIgnoreCase("admin") && modelLogin.getSenha().equalsIgnoreCase("admin")) {
					
					request.getSession().setAttribute("usuario", modelLogin.getLogin());
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("principal/principal.jsp");
					dispatcher.forward(request, response);
					
				}
				else {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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

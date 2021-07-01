package contollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;
import models.role;
import services.servicesPersonne;


@WebServlet("/authentification")
public class authentification extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/authentification.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Personne p = null;
		String login = request.getParameter("email");
		String password = request.getParameter("mdp");
		 try {
			p = servicesPersonne.Authentification(login, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(p==null) {
			response.sendRedirect("http://localhost:8087/blockchain1/authentification.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("personne", p);
			if(p.getRole().equals(role.ADMIN)) {
				response.sendRedirect("http://localhost:8087/blockchain1/admin.jsp");
			}else {
				response.sendRedirect("http://localhost:8087/blockchain1/comité.jsp");
			}
		}
	}

}
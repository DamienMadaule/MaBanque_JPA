package fr.ynov.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Utilisateur;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		if (login == null || login.length() == 0) {
			req.setAttribute("errorMessage", "Le champs login est obligatoire");
			dispatcher.forward(req, resp);

		} else if (password == null || password.length() == 0) {
			req.setAttribute("errorMessage", "Le champs password est obligatoire");
			dispatcher.forward(req, resp);
		} else {
			Utilisateur uti = UtilisateurManager.LoadClientByLoginAndPassword(login, password);
			if (uti == null) {
				req.setAttribute("errorMessage", "Aucun utilisateur connu avec ce mot de passe");
				dispatcher.forward(req, resp);
			} else {
				req.getSession().setAttribute("utilisateur", uti);
				resp.sendRedirect(req.getContextPath() + "/CompteClient.jsp");
			}
		}
	}

}

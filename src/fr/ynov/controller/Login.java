package fr.ynov.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Utilisateur;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(Login.class);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(req, resp);
		logger.info("Affichage de la page login");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(Login.class);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		if (login == null || login.length() == 0) {
			req.setAttribute("errorMessage", "Le champs login est obligatoire");
			dispatcher.forward(req, resp);
			logger.debug("champs login non rempli");

		} else if (password == null || password.length() == 0) {
			req.setAttribute("errorMessage", "Le champs PasswordHelper est obligatoire");
			dispatcher.forward(req, resp);
			logger.debug("champs password non rempli");
		} else {
			Utilisateur uti = UtilisateurManager.LoadClientByLoginAndPassword(login, password);
			if (uti == null) {
				req.setAttribute("errorMessage", "Aucun utilisateur connu avec ce mot de passe");
				dispatcher.forward(req, resp);
				logger.debug("aucun utilisateur avec ce mot de passe");
			} else {
				req.getSession().setAttribute("utilisateur", uti);
				resp.sendRedirect(req.getContextPath() + "/private/compteClient");
				req.getSession().setMaxInactiveInterval(120);
				logger.info("Connexion de l'utilisateur reussi : " + uti.getLogin());
			}
		}
		
	}
	/*protected void logout (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.removeAttribute("utilisateur");
		resp.sendRedirect(req.getContextPath() + "/login");
		
	}*/

}

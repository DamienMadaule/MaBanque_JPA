package fr.ynov.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ynov.function.PasswordHelper;
import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Utilisateur;

@SuppressWarnings("serial")
@WebServlet("/private/password")
public class Password extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/password.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(CompteClient.class);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/password.jsp");
		String ancienPwd = req.getParameter("ancienPwd");
		String nouveauPwd = req.getParameter("nouveauPwd");
		String nouveauPwdConformation = req.getParameter("nouveauPwdConformation");
		if(PasswordHelper.verifyPassword(nouveauPwd))
		{
			Utilisateur uti = (Utilisateur) req.getSession().getAttribute("utilisateur");
			if(uti.getPassword().equals(ancienPwd)) {
				if(nouveauPwd.equals(nouveauPwdConformation)) {
					uti.setPassword(nouveauPwd);
					UtilisateurManager.updateClient(uti);
					req.setAttribute("utilisateur",uti);
					req.setAttribute("Message", "le mot de passe à etait changé");
					dispatcher.forward(req, resp);
				}else {
					dispatcher.forward(req, resp);
				}
			}else {
				dispatcher.forward(req, resp);
			}
		}else {
			dispatcher.forward(req, resp);
		}
	}

}

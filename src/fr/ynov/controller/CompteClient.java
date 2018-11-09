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

import fr.ynov.manager.CompteManager;
import fr.ynov.models.Compte;

@SuppressWarnings("serial")
@WebServlet("/private/compteClient")
public class CompteClient extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/compteClient.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(CompteClient.class);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CompteClient.jsp");
		int idCompte = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("idCompte", idCompte );
		Compte cpt = CompteManager.loadCompteByid(idCompte);
		if(cpt==null) {
			req.setAttribute("errorMessage", "Aucun utilisateur connu avec ce mot de passe");
			dispatcher.forward(req, resp);
			logger.debug("aucun Compte avec cette ID");
		}else {
			req.getSession().setAttribute("compte", cpt);
			resp.sendRedirect(req.getContextPath() + "/private/transaction");
		}
	}
	
}

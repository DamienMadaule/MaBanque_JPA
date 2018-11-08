package fr.ynov.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ynov.manager.CompteManager;
import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Compte;
import fr.ynov.models.Utilisateur;

@SuppressWarnings("serial")
@WebServlet("/private/ajouterCompte")
public class AjouterCompte extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ajouterCompte.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(CompteClient.class);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CompteClient.jsp");
		Compte compte = new Compte(0, new Date());
		Utilisateur uti = (Utilisateur) req.getSession().getAttribute("utilissateur");
		uti.addCompte(compte);
		CompteManager.saveCompte(compte);
		UtilisateurManager.updateClient(uti);
		dispatcher.forward(req, resp);
	}
}

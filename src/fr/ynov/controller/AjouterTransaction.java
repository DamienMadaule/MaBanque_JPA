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
import fr.ynov.manager.TransactionManager;
import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Compte;
import fr.ynov.models.Transaction;
import fr.ynov.models.Utilisateur;

@SuppressWarnings("serial")
@WebServlet("/private/ajouterTransaction")
public class AjouterTransaction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ajouterTransaction.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger = LogManager.getLogger(CompteClient.class);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/transaction.jsp");
		String motif = req.getParameter("motif");
		float somme = Float.parseFloat(req.getParameter("somme"));
		String cptSource = req.getParameter("cptSource");
		String cptDestination = req.getParameter("cptDestination");
		Transaction transaction = new Transaction(somme, cptSource, cptDestination, new Date(), motif);
		Compte compte = CompteManager.loadCompteByid(Integer.parseInt(cptSource));
		transaction.setCompte(compte);
		TransactionManager.saveTransaction(transaction);
		compte.setSolde(compte.getSolde() - somme);
		CompteManager.updateCompte(compte);
		Transaction transaction2 = new Transaction(somme, cptDestination, cptSource, new Date(), motif);
		Compte compte2 = CompteManager.loadCompteByid(Integer.parseInt(cptDestination));
		transaction2.setCompte(compte2);
		TransactionManager.saveTransaction(transaction2);
		compte2.setSolde(compte2.getSolde() + somme);
		CompteManager.updateCompte(compte2);
		Utilisateur uti = (Utilisateur) req.getSession().getAttribute("utilisateur");
		Utilisateur uti2 = UtilisateurManager.LoadClientByLoginAndPassword(uti.getLogin(), uti.getPassword());
		req.setAttribute("utilisateur", uti2);
		dispatcher.forward(req, resp);
	}

}

package fr.ynov.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Utilisateur;

@SuppressWarnings("serial")
@WebServlet("/rest/utilisateur/*")
public class RestUtilisateurId extends HttpServlet {
	Logger logger = LogManager.getLogger(RestUtilisateurId.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String[] split = req.getRequestURI().split("/");
        Utilisateur uti = UtilisateurManager.loadClientByLogin(split[split.length-1].toString());
        logger.debug("coucou");
        JSONObject json = new JSONObject();
        json.put("id", uti.getId());
        json.put("nom", uti.getNom());
        json.put("prenom", uti.getPrenom());
        json.put("email", uti.getEmail());
        json.put("login", uti.getLogin());
        json.put("Password", uti.getPassword());
        json.put("telephone", uti.getTelephone());
        json.put("dateDeNaissance", uti.getDateDeNaissance());
        json.put("adresse", uti.getAdresse());


        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
	
	}

}
package fr.ynov.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import fr.ynov.manager.CompteManager;
import fr.ynov.models.Compte;

@SuppressWarnings("serial")
@WebServlet("/rest/solde/*")
public class RestSolde extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String[] split = req.getRequestURI().split("/");
		int id = Integer.valueOf(split[split.length-1]);
        Compte compte = CompteManager.loadCompteByid(id);

        JSONObject json = new JSONObject();
        json.put("id", compte.getId());
        json.put("solde", compte.getSolde());

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
	
	}

}

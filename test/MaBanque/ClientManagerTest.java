package MaBanque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import fr.ynov.manager.UtilisateurManager;
import fr.ynov.models.Compte;
import fr.ynov.models.Utilisateur;

class ClientManagerTest {

	@Test
	void test1LoadClientbylogin() {
		Utilisateur utilisateur = new Utilisateur("Madaule", "Damien","azerty@azerty.com", "Damien","Secret","0501020304",new Date(), "chez moi");
		UtilisateurManager.saveClient(utilisateur);
		assertEquals(UtilisateurManager.loadClientByLogin(utilisateur.getLogin()).getNom(),utilisateur.getNom());
	}
	
	@Test
	void test2LoadClientbyLoginAndPassword() {
		Utilisateur utilisateur2 = new Utilisateur("Madaule2", "Damien2","azerty2@azerty.com", "Damien2","Secret2","0501020308",new Date(), "chez moi2");
		UtilisateurManager.saveClient(utilisateur2);
		assertEquals(UtilisateurManager.LoadClientByLoginAndPassword("Damien2", "secret2").getPassword(),utilisateur2.getPassword());
	}
	
	@Test
	void test3AjouterUnCompte(){
		Compte compte = new Compte(2500.00f,new Date(),null);
		Utilisateur utilisateur3 = new Utilisateur("test","test","test@test.com","Damien42","secret","0501040708",new Date(),"ic où là bas");
		utilisateur3.addCompte(compte);
		UtilisateurManager.saveClient(utilisateur3);
		assertEquals(utilisateur3.getComptes().get(0), compte);
	}
	

}

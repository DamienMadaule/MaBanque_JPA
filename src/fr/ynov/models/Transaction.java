package fr.ynov.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float montant;
	private String cptSource;
	private String cptDestination;
	private Date date;
	private String libelle;
	@ManyToOne
	private Compte compte;

	public Transaction() {
		
	}
	
	public Transaction(float montant, String cptSource, String cptDestination, Date date, String libelle) {
		super();
		this.montant = montant;
		this.cptSource = cptSource;
		this.cptDestination = cptDestination;
		this.date = date;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getCptSource() {
		return cptSource;
	}

	public void setCptSource(String cptSource) {
		this.cptSource = cptSource;
	}

	public String getCptDestination() {
		return cptDestination;
	}

	public void setCptDestination(String cptDestination) {
		this.cptDestination = cptDestination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}

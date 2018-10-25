package fr.ynov.models;

public class TypeCpt {
	
	private int id;
	private String libelle;
	private float taux;
	
	public TypeCpt(int id, String libelle, float taux) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.taux = taux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	
}

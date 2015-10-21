package com.bankonet.dto;


public enum Civilite {
	MONSIEUR("Monsieur"), MADAME("Madame"), MADEMOISELLE("Mademoiselle");
	
	private String libelle;
	
	private Civilite(String libelle) {
		this.setLibelle(libelle);
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	
	

}

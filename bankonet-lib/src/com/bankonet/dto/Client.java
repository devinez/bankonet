package com.bankonet.dto;


import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import com.bankonet.exception.CompteNonTrouveException;
import com.bankonet.metier.ToString;

@Entity
public class Client {
		
	@Id
	@GeneratedValue
	private Integer id;
	
	private Civilite civilite;
	@ToString (uppercase = true) private String nom;
	@ToString private String prenom;
	private String login;
	private String mdp;
	//private String identifiant;
	
	private static int nbClients = 0;
	
	@Transient
	private Map<String, Compte> comptesMap = new HashMap<>();

	public Client(Civilite civilite, String nom, String prenom, String login, String mdp) {
		super();
		setNbClients(getNbClients() + 1);
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.setCivilite(civilite);
		this.setMdp(mdp);
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public void creerCompte(Compte compte) {
		comptesMap.put(compte.getNumero(), compte);
	}
	
	public void supprimerCompte(Compte compte) {
		comptesMap.remove(compte.getNumero());
	}
	
	public Compte retournerCompte(String numero) throws CompteNonTrouveException {
		Compte compteRecherche = (Compte) comptesMap.get(numero);
	
		if(compteRecherche == null) {
			throw new CompteNonTrouveException();
		}
		
		return compteRecherche;
	}
	
	
	public void supprimerCompte(String numero) throws CompteNonTrouveException {
		Compte compteRecherche = retournerCompte(numero);
		comptesMap.remove(compteRecherche.getNumero());
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

//	public String getIdentifiant() {
//		return identifiant;
//	}
//
//	public void setIdentifiant(String identifiant) {
//		this.identifiant = identifiant;
//	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public Civilite getCivilite() {
		return civilite;
	}
	
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Collection<Compte> getComptesList() {
		return comptesMap.values();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Client [");
		
		for(Field champ : Client.class.getDeclaredFields()) {
			ToString toStringAnn = champ.getAnnotation(ToString.class) ;
			if(toStringAnn != null) {
				sb.append(champ.getName());
				sb.append("=");
				try {
					if(toStringAnn.uppercase()) {
						sb.append(champ.get(this).toString().toUpperCase());
					} else {
						sb.append(champ.get(this));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				sb.append(",");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}

	
	public static int getNbClients() {
		return nbClients;
	}

	public static void setNbClients(int nbClients) {
		Client.nbClients = nbClients;
	}



	
	
	
	
	
	
	
	
	
	
	
	

}

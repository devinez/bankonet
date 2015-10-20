package com.bankonet.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.DaoFactoryMySQL;
import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;
import com.bankonet.metier.ClientService;
import com.bankonet.metier.ClientServiceImpl;

public class AppConseiller {
	
	private Scanner scanInput;
	private DaoFactory factory = new DaoFactoryMySQL();
	private ClientService clientService = new ClientServiceImpl(factory.getClientDao());
	

	public void start() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		boolean menu = true;
		while (menu) {
			System.out.println(
					"************* Application Conseiller Bancaire *************\n\n0. Arrêter le programme\n1. Ouvrir un compte courant\n2. Lister tous les clients\n\nVeuillez choisir une action");
			switch (scanInput.nextLine()) {
			case "0":
				System.out.println("Arrêt de l'application");
				menu = false;
				break;
			case "1":
				try {
					ouvrirCompte(scanInput);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "2":
				try {
					listerClients();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("erreur de saisie");
				break;
			}
		}
	}
	

	public AppConseiller(Scanner scanInput) {
		super();
		this.scanInput = scanInput;

	}


	private void listerClients() throws IOException {
		try {
			for(Client c : clientService.findAll()) {
//				System.out.println(c);
			}
		} catch (BankonetException e) {
			System.out.println("Impossible d'afficher les clients");
		}

	}

	private void ouvrirCompte(Scanner scanInput) throws IOException {
		String nom, prenom, login, mdp = "secret";
		
//		System.out.println("civilite du client ?");
//		civ = scanInput.nextLine();
		
		System.out.println("nom du client ?");
		nom = scanInput.nextLine();
		System.out.println("prenom du client ?");
		prenom = scanInput.nextLine();
		System.out.println("login ?");
		login = scanInput.nextLine();

		// StringBuilder propClient = new
		// StringBuilder(lireFichier(fichierClient));
		// System.out.println(propClient);
		
		try {
			clientService.creerClient(nom, prenom, login, mdp);
		} catch (BankonetException | SQLException e) {
			//System.out.println("Désolé, impossible d'ouvrir le compte");
			e.printStackTrace();
		}
		
	}

}

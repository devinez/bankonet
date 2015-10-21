package com.bankonet.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

import com.bankonet.command.ExitCommand;
import com.bankonet.command.IhmCommand;
import com.bankonet.command.ListerTousLesClientsCommand;
import com.bankonet.command.OuvrirCompteCourantCommand;
import com.bankonet.dao.DaoFactory;
import com.bankonet.dao.DaoFactoryJPA;
import com.bankonet.exception.BankonetException;
import com.bankonet.metier.ClientService;
import com.bankonet.metier.ClientServiceImpl;

public class AppConseiller {

	private Scanner scanInput;
	private DaoFactory factory = new DaoFactoryJPA("bankonet-lib");
	private ClientService clientService = new ClientServiceImpl(factory.getClientDao());

	public void start() throws ClassNotFoundException {

		afficherMenu();

	}

	private void afficherMenu() {
		// TODO Auto-generated method stub
		System.out.println("************* Application Conseiller Bancaire *************\n\n");

		TreeSet<IhmCommand> commands = new TreeSet<>(Arrays.asList(
				new ListerTousLesClientsCommand(clientService), 
				new ExitCommand(), 
				new OuvrirCompteCourantCommand(scanInput ,clientService)));

		for (IhmCommand command : commands) {
			System.out.println(command.getId() + ": " + command.getLibelle());
		}

	}

	public AppConseiller(Scanner scanInput) {
		super();
		this.scanInput = scanInput;

	}

//	private void listerClients() throws IOException {
//		try {
//			for (Client c : clientService.findAll()) {
//				// System.out.println(c);
//			}
//		} catch (BankonetException e) {
//			System.out.println("Impossible d'afficher les clients");
//		}
//
//	}

	private void ouvrirCompte(Scanner scanInput) throws IOException {
		String nom, prenom, login, mdp = "secret";

		// System.out.println("civilite du client ?");
		// civ = scanInput.nextLine();

		System.out.println("nom du client ?");
		nom = scanInput.nextLine();
		System.out.println("prenom du client ?");
		prenom = scanInput.nextLine();
		System.out.println("login ?");
		login = scanInput.nextLine();


		try {
			clientService.creerClient(nom, prenom, login, mdp);
		} catch (BankonetException | SQLException e) {
			// System.out.println("Désolé, impossible d'ouvrir le compte");
			e.printStackTrace();
		}

	}

}

package com.bankonet.command;

import java.sql.SQLException;
import java.util.Scanner;

import com.bankonet.exception.BankonetException;
import com.bankonet.metier.ClientService;

public class OuvrirCompteCourantCommand implements IhmCommand {

	private ClientService clientService;
	private Scanner scanInput;
	public OuvrirCompteCourantCommand(Scanner scanInput, ClientService clientService) {
		// TODO Auto-generated constructor stub
		this.clientService = clientService;
	}

	@Override
	public String getLibelle() {
		return "Ouvrir Compte Courant";
	}

	@Override
	public Integer getId() {
		return 1;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
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
			} catch (BankonetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

}

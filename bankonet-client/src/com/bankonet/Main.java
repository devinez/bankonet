package com.bankonet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		File fichierClient = new File(".\\clients.properties");
		Scanner scanInput = new Scanner(System.in);
		System.out.println("Login : ");
		String login = scanInput.nextLine();
		System.out.println("Mot de passe : ");
		String mdp = scanInput.nextLine();
		boolean menu = true;
		while (menu == true) {
			System.out.println(
					"************* Application Client Bancaire *************\n\n0. Arrêter le programme\n1. Consulter soldes des comptes\n2. Effectuer un dépot\n3. Effectuer un retrait\n\nVeuillez choisir une action");
			switch (scanInput.nextLine()) {
			case "0":
				System.out.println("Arrêt de l'application");
				menu = false;
				break;
			case "1":
				
				break;
			case "2":
				
				break;
			default:
				System.out.println("erreur de saisie");
				break;
			}
		}
		scanInput.close();

	}

}

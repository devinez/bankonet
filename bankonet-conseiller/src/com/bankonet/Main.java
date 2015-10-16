package com.bankonet;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		File fichierClient = new File(".\\clients.properties");
		Scanner scanInput = new Scanner(System.in);
		boolean menu = true;
		while (menu == true) {
			System.out.println(
					"************* Application Conseiller Bancaire *************\n\n0. Arrêter le programme\n1. Ouvrir un compte courant\n2. Lister tous les clients\n\nVeuillez choisir une action");
			switch (scanInput.nextLine()) {
			case "0":
				System.out.println("Arrêt de l'application");
				menu = false;
				break;
			case "1":
				ouvrirCompte(scanInput, fichierClient);
				break;
			case "2":
				listerClients(fichierClient);
				break;
			default:
				System.out.println("erreur de saisie");
				break;
			}
		}
		scanInput.close();

	}

	private static void listerClients(File fichierClient) throws IOException {
		System.out.println(lireFichier(fichierClient));

	}

	private static String lireFichier(File fichierClient) throws IOException {
		FileReader fr = new FileReader(fichierClient);
		char[] cbuf = new char[100];
		fr.read(cbuf);
		StringBuilder sb = new StringBuilder();
		String str;
		for (char c : cbuf)
			sb.append(c);
		fr.close();
		str = sb.toString();
		System.out.println(str);
		return str;
	}

	private static void ouvrirCompte(Scanner scanInput, File fichierClient) throws IOException {
		String nom, prenom, login, mdp = "secret";

		System.out.println("nom du client ?");
		nom = scanInput.nextLine();
		System.out.println("prenom du client ?");
		prenom = scanInput.nextLine();
		System.out.println("login ?");
		login = scanInput.nextLine();

		// StringBuilder propClient = new StringBuilder(lireFichier(fichierClient));
		// System.out.println(propClient);
		String identifiant = "cli" + Client.getNbClients();
		String numero = "cc" + CompteCourant.getNbComptesCourant();

		String intitule = String.format("%s_%s_COURANT_%s", nom.toUpperCase(), prenom.toUpperCase(), numero);
		System.out.println(intitule);
		Client cl = new Client(Civilite.MONSIEUR, nom, prenom, identifiant);
		CompteCourant cc = new CompteCourant(numero, intitule, 100, 400);
		cl.creerCompte(cc);

		FileWriter fw = new FileWriter(fichierClient);
		String propClient = String.format("%s=nom:%s&prenom:%s&comptes_courants:%s\n", login, nom, prenom, cc.getNumero());

		System.out.println(propClient);
		fw.write(propClient);
		fw.flush();
		fw.close();

	}

}

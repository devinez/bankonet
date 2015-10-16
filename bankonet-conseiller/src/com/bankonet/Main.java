package com.bankonet;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bankonet.metier.Civilite;
import com.bankonet.metier.Client;
import com.bankonet.metier.CompteCourant;

public class Main {

	public static void main(String[] args) throws IOException {

		File fichierClient = new File(".\\clients.properties");
		Scanner scanInput = new Scanner(System.in);
		
		AppConseiller app = new AppConseiller(scanInput, fichierClient);
		
		scanInput.close();

	}

	
}

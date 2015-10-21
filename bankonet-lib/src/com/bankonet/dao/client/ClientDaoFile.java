package com.bankonet.dao.client;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;

public class ClientDaoFile implements ClientDao {
	
	File fichierClient = new File(".\\clients.properties");

	@Override
	public Set<Client> findAll() throws BankonetException {
		try {
			lireFichier(fichierClient);
			// TODO transformer les STring en objets
		} catch (IOException e) {
			throw new BankonetException(e);
		}
		return null;
	}
	
	private String lireFichier(File fichierClient) throws IOException {
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

	@Override
	public void save(Client client) throws BankonetException {
		

		FileWriter fw;
		try {
			fw = new FileWriter(fichierClient);
			String propClient = String.format("%s=nom:%s&prenom:%s&comptes_courants:%s\n", /*client.getCivilite(),*/ client.getNom().toUpperCase(), client.getPrenom(), client.getComptesList().iterator().next().getNumero());

			System.out.println(propClient);
			fw.write(propClient);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			throw new BankonetException(e);
		}
	


	}

}

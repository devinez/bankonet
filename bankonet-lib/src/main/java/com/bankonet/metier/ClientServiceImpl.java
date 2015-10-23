package com.bankonet.metier;

import java.sql.SQLException;
import java.util.Set;

import com.bankonet.dao.client.ClientDao;
import com.bankonet.dto.Civilite;
import com.bankonet.dto.Client;
import com.bankonet.dto.CompteCourant;
import com.bankonet.exception.BankonetException;

public class ClientServiceImpl implements ClientService {
	
	private ClientDao clientDao;

	public ClientServiceImpl(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public void creerClient(String nom, String prenom, String login, String mdp) throws BankonetException, SQLException {
		//String identifiant = "cli" + Client.getNbClients();
		String numero = "cc" + CompteCourant.getNbComptesCourant();

		String intitule = String.format("%s_%s_COURANT_%s", nom.toUpperCase(), prenom, numero);
		System.out.println(intitule);
		Client cl = new Client(/*Civilite.MONSIEUR,*/ nom, prenom, login, mdp);
		CompteCourant cc = new CompteCourant(numero, intitule, 100, 400);
		cl.creerCompte(cc);
		clientDao.save(cl);
	}

	@Override
	public Set<com.bankonet.dto.Client> findAll() throws BankonetException {
		
		return clientDao.findAll();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}

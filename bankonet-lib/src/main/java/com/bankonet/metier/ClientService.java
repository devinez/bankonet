package com.bankonet.metier;

import java.sql.SQLException;
import java.util.Set;

import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;

public interface ClientService {

	void creerClient(String nom, String prenom, String login, String mdp) throws BankonetException, SQLException;
	Set<Client> findAll() throws BankonetException;
	void delete();
}

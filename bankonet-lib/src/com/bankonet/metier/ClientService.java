package com.bankonet.metier;

import java.util.Set;

public interface ClientService {

	void creerClient(String nom, String prenom);
	Set<Client> findAll();
	void delete();
}

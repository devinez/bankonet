package com.bankonet.metier;

import java.util.Set;

import com.bankonet.dao.client.ClientDao;

public class ClientServiceImpl implements ClientService {
	
	private ClientDao clientDao;

	public ClientServiceImpl(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public void creerClient(String nom, String prenom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}

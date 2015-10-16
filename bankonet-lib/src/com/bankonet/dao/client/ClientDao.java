package com.bankonet.dao.client;

import java.util.List;

import com.bankonet.metier.Client;

public interface ClientDao {
	List<Client> findAll();
	void save(Client client);
}

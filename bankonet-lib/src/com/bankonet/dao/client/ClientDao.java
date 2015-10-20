package com.bankonet.dao.client;

import java.sql.SQLException;
import java.util.Set;

import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;

public interface ClientDao {
	Set<Client> findAll() throws BankonetException;
	void save(Client client) throws BankonetException, SQLException;
}

package com.bankonet.metier;

import java.sql.SQLException;

import com.bankonet.dao.client.ClientDao;
import com.bankonet.dto.Civilite;
import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;

public class InitService {

	private ClientDao clientDao;

	public InitService(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}

	public void init() throws BankonetException, SQLException {

		Client client1 = new Client(/*Civilite.MADAME,*/ "aasehg", "aaddx", "aadfdf", "aaa");
		Client client2 = new Client(/*Civilite.MONSIEUR,*/ "bbsehg", "bbbdx", "bbdf", "bbb");
		Client client3 = new Client(/*Civilite.MADEMOISELLE,*/ "ccehg", "ccdx", "ccfdf", "ccc");
		clientDao.save(client1);
		clientDao.save(client2);
		clientDao.save(client3);
	}

}

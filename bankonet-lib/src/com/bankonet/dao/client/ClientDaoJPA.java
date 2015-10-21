package com.bankonet.dao.client;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;

public class ClientDaoJPA implements ClientDao {

	private EntityManagerFactory emFactory;
	
	public ClientDaoJPA(EntityManagerFactory emFactory) {
		super();
		this.emFactory = emFactory;
	}

	@Override
	public Set<Client> findAll() throws BankonetException {
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		List<Client> resultList = em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
		em.close();
		return new HashSet<>(resultList);
	}

	@Override
	public void save(Client client) throws BankonetException, SQLException {
		// TODO Auto-generated method stub
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(client);
		et.commit();
		em.close();
		System.out.println("client ajouté");
	}

}

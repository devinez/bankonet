package com.bankonet.dao.compte;

import java.util.List;

import com.bankonet.metier.Compte;
import com.bankonet.metier.CompteException;

public interface CompteDao {
	List<Compte> findAll();
	void save(Compte compte) throws CompteException;

}

package com.bankonet.dao.compte;

import java.util.List;

import com.bankonet.dto.Compte;
import com.bankonet.exception.CompteException;

public interface CompteDao {
	List<Compte> findAll();
	void save(Compte compte) throws CompteException;

}

package com.bankonet.dao.compte;

import java.io.FileReader;
import java.util.List;

import com.bankonet.dto.Compte;
import com.bankonet.exception.CompteException;

public class CompteDaoFile implements CompteDao {
	
	private FileReader fileReader;

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Compte compte) throws CompteException {
		
	}

}

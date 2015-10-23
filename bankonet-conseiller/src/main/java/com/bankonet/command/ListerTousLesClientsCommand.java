package com.bankonet.command;

import com.bankonet.dto.Client;
import com.bankonet.exception.BankonetException;
import com.bankonet.metier.ClientService;

public class ListerTousLesClientsCommand extends IhmCommand {

	//private DaoFactory factory = new DaoFactoryMySQL();
	//private DaoFactory factory = new DaoFactoryJPA("bankonet-lib");
	//private ClientService clientService = new ClientServiceImpl(factory.getClientDao());
	
	public ListerTousLesClientsCommand(ClientService clientService) {
		// TODO Auto-generated constructor stub
		try {
			
			for (Client c : clientService.findAll()) {
				 System.out.println(c);
			}
		} catch (BankonetException e) {
			System.out.println("Impossible d'afficher les clients");
		}
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Lister clients";
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(IhmCommand o) {
		// TODO Auto-generated method stub
		return 2;
	}

}

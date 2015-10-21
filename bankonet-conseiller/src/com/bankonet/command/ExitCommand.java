package com.bankonet.command;

public class ExitCommand implements IhmCommand {
	
	@Override
	public String getLibelle() {
		
		return "Arrêter programme";
	}
	
	@Override
	public Integer getId() {
		return 0;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}

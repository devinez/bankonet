package com.bankonet.command;

public class ExitCommand extends IhmCommand {
	
	public ExitCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		System.out.println("programme arrêté");
		
	}

	@Override
	public int compareTo(IhmCommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.bankonet.command;

public abstract class IhmCommand implements Comparable<IhmCommand>{
	public abstract String getLibelle();
	
	public abstract Integer getId();
	
	public abstract void execute();
}

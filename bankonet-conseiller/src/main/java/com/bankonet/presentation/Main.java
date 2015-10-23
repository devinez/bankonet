package com.bankonet.presentation;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		
		Scanner scanInput = new Scanner(System.in);
		
		AppConseiller app = new AppConseiller(scanInput);
		app.start();
		
		scanInput.close();

	}

}

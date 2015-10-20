package com.bankonet.dao.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.bankonet.dto.Client;

public class ClientDaoMySQL implements ClientDao {

	@Override
	public Set<Client> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","util","util");
			Statement statement = connection.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM CLIENT");
			while(resultats.next()) {
				String nom = resultats.getString("NOM");
				String prenom = resultats.getString("PRENOM");
				String login = resultats.getString("LOGIN");
				System.out.println("[nom=" + nom + " prenom=" + prenom + " login=" + login
				+ "]");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void save(Client client) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","util","util");
		//Statement statement = connection.createStatement();
		
		//int nbPizzaInsere = statement.executeUpdate("INSERT INTO BANKONET(NOM,PRENOM,LOGIN,MDP) VALUES(client.getNom(),client.getPrenom(),client.getLogin(),client.getMdp()));
		//		System.out.println(nbPizzaInsere + " pizza insérée");
		
		String insertTableSQL = "INSERT INTO CLIENT(NOM,PRENOM,LOGIN,MDP,CIVILITE)" + " VALUES(?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, client.getNom());
		preparedStatement.setString(2, client.getPrenom());
		preparedStatement.setString(3, client.getLogin());
		preparedStatement.setString(4, client.getMdp());
		preparedStatement.setString(5, client.getCivilite().getLibelle());
		// execute insert SQL statement
		preparedStatement .executeUpdate();
		System.out.println("client ajouté");
		
	}

}

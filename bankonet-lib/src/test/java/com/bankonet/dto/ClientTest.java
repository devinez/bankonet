package com.bankonet.dto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.bankonet.exception.CompteNonTrouveException;

public class ClientTest {

	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRetournerCompte() {
		Client client = new Client();

		try {
			client.retournerCompte("dfffs");
			Assert.fail("CompteNonTrouveException attendu");
		} catch (CompteNonTrouveException e) {
			//ok
			e.getStackTrace();
		}
	}

}

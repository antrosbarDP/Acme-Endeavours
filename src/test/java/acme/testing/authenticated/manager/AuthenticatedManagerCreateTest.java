/*
 * SignUpTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedManagerCreateTest extends AcmeWorkPlansTest {

	@Test
	@Order(10)
	public void becomeManager() {
		
		super.signUp("userprueba", "passprueba0", "Antonio", "García", "something@msn.com", "123456789");
		super.signIn("userprueba", "passprueba0");
		super.clickOnMenu("Account", "Become a manager");
		super.clickOnSubmitButton("Register");
		super.clickOnMenu("Account", "Officer data");
		super.checkButtonExists("Update");
		
		super.signOut();
	}
	
	//There's no extra info the user can submit when becoming a manager, so it's not possible to create a negative test case
	
	
}

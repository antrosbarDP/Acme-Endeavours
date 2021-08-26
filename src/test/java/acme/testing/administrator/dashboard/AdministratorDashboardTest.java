/*
 * EmployerApplicationLIstTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorDashboardTest extends AcmeWorkPlansTest {

	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------
	
	@Test
	@Order(10)
	public void showDashboard() {		
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");		
		super.checkNotPanicExists();
		
		
		
		
		super.signOut();
		
		
	}
	
	//It's not possible to create negative test cases since the dashboard feature doesn't allow the user to send information that could potentially be wrong
	
	// Ancillary methods ------------------------------------------------------

}

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

package acme.testing.authenticated.duty;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeEndeavoursTest;

public class AuthenicatedDutyListTest extends AcmeEndeavoursTest {

	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/duty/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void list(final int recordIndex, final String title, final String description, final String executionPeriod, final String link, final String workloadHours, final String workloadMinutes, final String workload) {		
		super.signIn("officer1", "officer1");
		
		super.clickOnMenu("User", "List Duties");		
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, executionPeriod);
		super.checkColumnHasValue(recordIndex, 2, workload);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);		
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("workloadHours", workloadHours);
		super.checkInputBoxHasValue("workloadMinutes", workloadMinutes);
		
		super.signOut();
	}
	
	//It's not possible to create negative test cases since the listing feature doesn't allow the user to send information that could potentially be wrong
	
	// Ancillary methods ------------------------------------------------------

}

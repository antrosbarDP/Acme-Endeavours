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

package acme.testing.anonymous.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousTaskListTest extends AcmeWorkPlansTest {

	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void list(final int recordIndex, final String title, final String description, final String executionPeriod, final String link, final String workloadHours, final String workloadMinutes, final String workload) {		
		
		
		super.clickOnMenu("Anonymous", "List Tasks");		
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, executionPeriod);
		super.checkColumnHasValue(recordIndex, 2, workload);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);		
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("workloadHours", workloadHours);
		super.checkInputBoxHasValue("workloadMinutes", workloadMinutes);
		
		
	}
	
	//It's not possible to create negative test cases since the listing feature doesn't allow the user to send information that could potentially be wrong
	
	// Ancillary methods ------------------------------------------------------

}

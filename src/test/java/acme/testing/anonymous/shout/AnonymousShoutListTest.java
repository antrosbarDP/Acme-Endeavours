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

package acme.testing.anonymous.shout;

import java.text.ParseException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousShoutListTest extends AcmeWorkPlansTest {

	// Lifecycle management ---------------------------------------------------
	
	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int recordIndex, final String moment, final String author, final String text, final String link) throws ParseException {		
		
		super.clickOnMenu("Anonymous", "List Shouts");		
		
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		
		
	}
	
	//It's not possible to create negative test cases since the listing feature doesn't allow the user to send information that could potentially be wrong
	
	// Ancillary methods ------------------------------------------------------

}

/*
 * EmployerJobCreateTest.java
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

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousShoutCreateTest extends AcmeWorkPlansTest {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String author, final String text, final String link, final String tracker, final String deadline, final String budget, final String important) {

		super.clickOnMenu("Anonymous", "Create Shouts");

		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("important", important);
		super.fillInputBoxIn("tracker", tracker);
		super.fillInputBoxIn("deadline", deadline);
		super.clickOnSubmitButton("Create");

		super.clickOnMenu("Anonymous", "List Shouts");
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);

		

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void createNegative(final int recordIndex, final String author, final String text, final String link, final String tracker, final String deadline, final String budget, final String important) {
		

		super.clickOnMenu("Anonymous", "Create Shouts");

		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("important", important);
		super.fillInputBoxIn("tracker", tracker);
		super.fillInputBoxIn("deadline", deadline);
		super.clickOnSubmitButton("Create");

		super.checkErrorsExist();

		
	}

	// Ancillary methods ------------------------------------------------------

}

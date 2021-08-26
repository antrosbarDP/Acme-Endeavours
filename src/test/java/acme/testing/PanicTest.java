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

package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PanicTest extends AcmeWorkPlansTest {

	@Test
	@Order(10)
	public void positivePanic() {
		
		super.navigate("/master/oops", "");
		super.checkPanicExists();
	}
	
	
	@Test
	@Order(10)
	public void negativePanic() {
		
		super.navigate("/master/welcome", "");
		super.checkNotPanicExists();
	}
	
}

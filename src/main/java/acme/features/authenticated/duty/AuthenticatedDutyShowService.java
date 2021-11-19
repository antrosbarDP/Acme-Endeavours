/*
 * AuthenticatedUserAccountCreateService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedDutyShowService implements AbstractShowService<Authenticated, Duty> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		return true;
	}



	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "executionPeriodStart", "title", "executionPeriodEnd", "description","workloadHours", "workloadMinutes","link");

		
	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		Duty result;
		int id;
		

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		

		return result;
	}



}

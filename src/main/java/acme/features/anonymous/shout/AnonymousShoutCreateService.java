/*
 * AnonymousUserAccountCreateService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.shout;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.entities.shouts.Tremmer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnonymousShoutRepository repository;


	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Shout> request, final Shout entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "link", "tremmer.tracker", "tremmer.deadline", "tremmer.budget", "tremmer.important");

		
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request != null;

		Shout result;
		Date moment;
		final Tremmer tremmer = new Tremmer();
		
		moment = new Date(System.currentTimeMillis() -1);

		result = new Shout();
		result.setTremmer(tremmer);
		result.setMoment(moment);
		
		

		return result;
	}

	@Override
	public void validate(final Request<Shout> request, final Shout entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		
		final Calendar calendar = Calendar.getInstance();
		
		final String year = String.valueOf(calendar.get(Calendar.YEAR));
		final String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
		String finalmonth = month;
		if (month.length()==1) {
			finalmonth = "0" + month;
		} 
		final String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		
		final String regexp = year.substring(2) + "-" + finalmonth + day + "-" + "\\d{2,4}";
	
		final boolean notUniqueTracker = this.repository.findOneByTracker(entity.getTremmer().getTracker()) != null;
		errors.state(request, notUniqueTracker, "tremmer.tracker", "anonymous.shout.error.repeated-tracker");
		
		final boolean pattern = entity.getTremmer().getTracker().matches(regexp);
		errors.state(request, pattern, "tremmer.tracker", "anonymous.shout.error.pattern-no-match");
		
		if (entity.getTremmer().getBudget()==null) {
			errors.state(request,entity.getTremmer().getBudget()!=null , "tremmer.budget", "anonymous.shout.error.null-budget");
		} else {
			final String currencystr = entity.getTremmer().getBudget().getCurrency();
			final boolean currency = currencystr.equals("EUR") || currencystr.equals("USD") || currencystr.equals("GBP");
			errors.state(request, currency, "tremmer.budget", "anonymous.shout.error.wrong-currency");
			final boolean amount = entity.getTremmer().getBudget().getAmount() >= 0;
			errors.state(request, amount, "tremmer.budget", "anonymous.shout.error.negative-amount");

		}
		
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		final Date futureWeek = calendar.getTime();
		
		if (entity.getTremmer().getDeadline() == null) {
			errors.state(request, entity.getTremmer().getDeadline() != null, "tremmer.deadline", "anonymous.shout.error.null-deadline");
		} else {
			final boolean fw = entity.getTremmer().getDeadline().after(futureWeek);
			errors.state(request, fw, "tremmer.deadline", "anonymous.shout.error.future-week");
		}
		
		
		

	}

	@Override
	public void create(final Request<Shout> request, final Shout entity) {
		assert request != null;
		assert entity != null;
		
		Date moment;
		
		moment = new Date(System.currentTimeMillis() -1);
		entity.setMoment(moment);

		final Tremmer tremmer = this.repository.save(entity.getTremmer());
		entity.setTremmer(tremmer);
		this.repository.save(entity);
		
	
	}

}

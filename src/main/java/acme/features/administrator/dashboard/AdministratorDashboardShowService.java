/*
 * AdministratorDashboardShowService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.dashboard;

import java.util.Collection;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.shouts.Shout;
import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDashboardRepository repository;

	// AbstractShowService<Administrator, Dashboard> interface ----------------


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
									"totalPublicDuties",
								"totalPrivateDuties",
								"totalFinishedDuties",
								"totalUnfinishedDuties",
								"averageExecutionPeriod",
								"averageWorkload",
								"maximumExecutionPeriod",
								"minimumExecutionPeriod",
								"maximumWorkload",
								"minimumWorkload",
								"standardDeviationWorkload",
							"standardDeviationExecutionPeriod",
							"standardDeviationShoutEUR",
							"averageShoutEUR",
								"standardDeviationShoutUSD",
								"averageShoutUSD",
								"standardDeviationShoutGBP",
								"averageShoutGBP",
								"ratioImportantShouts",
								"ratioBudget0Shouts");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		final Dashboard result;
		final Double						totalPublicDuties;
		final Double						totalPrivateDuties;
		final Double						totalFinishedDuties;
		final Double						totalUnfinishedDuties;
		final Double						averageExecutionPeriod;
		final Double						averageWorkload;
		final Double						maximumExecutionPeriod;
		final Double						minimumExecutionPeriod;
		final Double						maximumWorkload;
		final Double						minimumWorkload;
		final Double						standardDeviationWorkload;
		final Double						standardDeviationExecutionPeriod;
		final Double						standardDeviationShoutEUR;
		final Double						averageShoutEUR;
		final Double						standardDeviationShoutUSD;
		final Double						averageShoutUSD;
		final Double						standardDeviationShoutGBP;
		final Double						averageShoutGBP;
		final Double						ratioImportantShouts;
		final Double						ratioBudget0Shouts;

		final Collection<Duty> duties =  this.repository.findMany();
		final Collection<Shout> shouts =  this.repository.findManyShouts();
		totalPublicDuties = (double) this.repository.findManyPublic().size();
		totalPrivateDuties = (double) this.repository.findManyPrivate().size();
		totalFinishedDuties = (double) this.repository.findManyFinished().size();
		totalUnfinishedDuties = (double) this.repository.findManyUnfinished().size();
		ratioImportantShouts = (double) this.repository.findManyImportant().size()/shouts.size();
		ratioBudget0Shouts = (double) this.repository.findManyBudget0().size()/shouts.size();
		for (final Shout s:shouts){
			System.out.println(s.getTremmer().getBudget().getCurrency());

		}
		averageShoutGBP = shouts.stream().filter(s->s.getTremmer().getBudget().getCurrency().equals("GBP")).mapToDouble(s->s.getTremmer().getBudget().getAmount()).average().orElse(0);
		averageShoutEUR = shouts.stream().filter(s->s.getTremmer().getBudget().getCurrency().equals("EUR")).mapToDouble(s->s.getTremmer().getBudget().getAmount()).average().orElse(0);
		averageShoutUSD = shouts.stream().filter(s->s.getTremmer().getBudget().getCurrency().equals("USD")).mapToDouble(s->s.getTremmer().getBudget().getAmount()).average().orElse(0);
		averageExecutionPeriod = duties.stream().mapToDouble(t->t.getExecutionPeriod()).average().orElse(0);
		maximumExecutionPeriod = duties.stream().mapToDouble(t->t.getExecutionPeriod()).max().orElse(0);
		minimumExecutionPeriod = duties.stream().mapToDouble(t->t.getExecutionPeriod()).min().orElse(0);
		standardDeviationExecutionPeriod = this.standardDeviation(duties.size(), averageExecutionPeriod, duties.stream().mapToDouble(t->t.getExecutionPeriod()));
		averageWorkload = duties.stream().mapToDouble(t->t.getWorkload()).average().orElse(0);
		maximumWorkload = duties.stream().mapToDouble(t->t.getWorkload()).max().orElse(0);
		minimumWorkload = duties.stream().mapToDouble(t->t.getWorkload()).min().orElse(0);
		standardDeviationWorkload = this.standardDeviation(duties.size(), averageWorkload, duties.stream().mapToDouble(t->t.getWorkload()));
		standardDeviationShoutEUR = this.standardDeviation(shouts.size(), averageShoutEUR, shouts.stream().filter(s->s.getTremmer().getBudget().getCurrency().equals("EUR")).mapToDouble(s->s.getTremmer().getBudget().getAmount()));
		standardDeviationShoutUSD = this.standardDeviation(shouts.size(), averageShoutUSD, shouts.stream().filter(s->s.getTremmer().getBudget().getCurrency().equals("USD")).mapToDouble(s->s.getTremmer().getBudget().getAmount()));
		standardDeviationShoutGBP = this.standardDeviation(shouts.size(), averageShoutGBP, shouts.stream().filter(s->s.getTremmer().getBudget().getCurrency().equals("GBP")).mapToDouble(s->s.getTremmer().getBudget().getAmount()));
		
		

		result = new Dashboard();
		result.setAverageExecutionPeriod(averageExecutionPeriod);
		result.setAverageWorkload(averageWorkload);
		result.setMaximumExecutionPeriod(maximumExecutionPeriod);
		result.setMaximumWorkload(maximumWorkload);
		result.setMinimumExecutionPeriod(minimumExecutionPeriod);
		result.setMinimumWorkload(minimumWorkload);
		result.setStandardDeviationExecutionPeriod(standardDeviationExecutionPeriod);
		result.setStandardDeviationWorkload(standardDeviationWorkload);
		result.setTotalFinishedDuties(totalFinishedDuties);
		result.setTotalPrivateDuties(totalPrivateDuties);
		result.setTotalUnfinishedDuties(totalUnfinishedDuties);
		result.setTotalPublicDuties(totalPublicDuties);
		result.setAverageShoutEUR(averageShoutEUR);
		result.setAverageShoutGBP(averageShoutGBP);
		result.setAverageShoutUSD(averageShoutUSD);
		result.setStandardDeviationShoutEUR(standardDeviationShoutEUR);
		result.setStandardDeviationShoutUSD(standardDeviationShoutUSD);
		result.setStandardDeviationShoutGBP(standardDeviationShoutGBP);
		result.setRatioBudget0Shouts(ratioBudget0Shouts);
		result.setRatioImportantShouts(ratioImportantShouts);

		return result;
	}
	
	private Double standardDeviation(final Integer total, final Double average,  final DoubleStream elements) {
		
		final Double sum = elements.map(e ->  Math.pow(e - average,2)).sum();
		final Double result = Math.sqrt(sum/total);
		
		return result;
	}

}

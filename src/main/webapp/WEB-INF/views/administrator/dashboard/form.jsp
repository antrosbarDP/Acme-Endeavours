<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<caption>
		<acme:message code="administrator.dashboard.form.title.general-indicators"/>
	</caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalPublic"/>
		</th>
		<td>
			<acme:print value="${totalPublicDuties}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalPrivate"/>
		</th>
		<td>
			<acme:print value="${totalPrivateDuties}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalFinished"/>
		</th>
		<td>
			<acme:print value="${totalFinishedDuties}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.totalUnfinished"/>
		</th>
		<td>
			<acme:print value="${totalUnfinishedDuties}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgPeriod"/>
		</th>
		<td>
			<acme:print value="${averageExecutionPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgWorkload"/>
		</th>
		<td>
			<acme:print value="${averageWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxPeriod"/>
		</th>
		<td>
			<acme:print value="${maximumExecutionPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minPeriod"/>
		</th>
		<td>
			<acme:print value="${minimumExecutionPeriod}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxWorkload"/>
		</th>
		<td>
			<acme:print value="${maximumWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minWorkload"/>
		</th>
		<td>
			<acme:print value="${minimumWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.sdWorkload"/>
		</th>
		<td>
			<acme:print value="${standardDeviationWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.sdPeriod"/>
		</th>
		<td>
			<acme:print value="${standardDeviationExecutionPeriod}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.ratioImportantShouts"/>
		</th>
		<td>
			<acme:print value="${ratioImportantShouts}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.ratioBudget0Shouts"/>
		</th>
		<td>
			<acme:print value="${ratioBudget0Shouts}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.sdShoutEUR"/>
		</th>
		<td>
			<acme:print value="${standardDeviationShoutEUR}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgShoutEUR"/>
		</th>
		<td>
			<acme:print value="${averageShoutEUR}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.sdShoutGBP"/>
		</th>
		<td>
			<acme:print value="${standardDeviationShoutGBP}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgShoutGBP"/>
		</th>
		<td>
			<acme:print value="${averageShoutGBP}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.sdShoutUSD"/>
		</th>
		<td>
			<acme:print value="${standardDeviationShoutUSD}"/>
		</td>
	</tr>
	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgShoutUSD"/>
		</th>
		<td>
			<acme:print value="${averageShoutUSD}"/>
		</td>
	</tr>
	
</table>







<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.duty.form.label.title" path="title"/>
	<acme:form-textarea code="anonymous.duty.form.label.description" path="description"/>
	<acme:form-moment code="anonymous.duty.form.label.start" path="executionPeriodStart"/>
	<acme:form-moment code="anonymous.duty.form.label.end" path="executionPeriodEnd"/>
	<acme:form-textbox code="anonymous.duty.form.label.link" path="link"/>
	<acme:form-textbox code="anonymous.duty.form.label.hours" path="workloadHours"/>
	<acme:form-textbox code="anonymous.duty.form.label.minutes" path="workloadMinutes"/>
		
  	<acme:form-return code="anonymous.duty.form.button.return"/>
</acme:form>
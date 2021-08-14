

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.task.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.task.form.label.description" path="description"/>
	<acme:form-moment code="authenticated.task.form.label.start" path="executionPeriodStart"/>
	<acme:form-moment code="authenticated.task.form.label.end" path="executionPeriodEnd"/>
	<acme:form-textbox code="authenticated.task.form.label.link" path="link"/>
	<acme:form-textbox code="authenticated.task.form.label.hours" path="workloadHours"/>
	<acme:form-textbox code="authenticated.task.form.label.minutes" path="workloadMinutes"/>
		
  	<acme:form-return code="authenticated.task.form.button.return"/>
</acme:form>
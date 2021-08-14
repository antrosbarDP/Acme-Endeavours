

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.task.form.label.title" path="title"/>
	<acme:form-textarea code="anonymous.task.form.label.description" path="description"/>
	<acme:form-moment code="anonymous.task.form.label.start" path="executionPeriodStart"/>
	<acme:form-moment code="anonymous.task.form.label.end" path="executionPeriodEnd"/>
	<acme:form-textbox code="anonymous.task.form.label.link" path="link"/>
	<acme:form-textbox code="anonymous.task.form.label.hours" path="workloadHours"/>
	<acme:form-textbox code="anonymous.task.form.label.minutes" path="workloadMinutes"/>
		
  	<acme:form-return code="anonymous.task.form.button.return"/>
</acme:form>
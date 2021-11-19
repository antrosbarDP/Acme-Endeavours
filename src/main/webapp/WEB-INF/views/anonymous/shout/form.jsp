

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.shout.form.label.author" path="author"/>
	<acme:form-textarea code="anonymous.shout.form.label.text" path="text"/>
	<acme:form-url code="anonymous.shout.form.label.link" path="link"/>
	
	<acme:form-textbox placeholder="^yy-mmdd-\d{2,4}$" code="anonymous.shout.label.tremmer.tracker" path="tremmer.tracker"/>
	<acme:form-moment code="anonymous.shout.label.tremmer.deadline" path="tremmer.deadline"/>
	<acme:form-money code="anonymous.shout.label.tremmer.budget" path="tremmer.budget"/>
	<acme:form-checkbox code="anonymous.shout.label.tremmer.important" path="tremmer.important"/>
		
	<acme:form-submit code="anonymous.shout.form.button.create" action="/anonymous/shout/create"/>
  	<acme:form-return code="anonymous.shout.form.button.return"/>
</acme:form>
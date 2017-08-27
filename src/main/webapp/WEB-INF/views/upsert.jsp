<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tmpl" tagdir="/WEB-INF/tags/templates" %>

<tmpl:main>
    <form:form id="upsert-form" modelAttribute="employee" method="post">
        <fieldset class="upsert__fieldset">
            <legend class="upsert__legend">${not empty employee.employeeId ? 'Edit ' : 'Insert '} Employee</legend>
            <label class="upsert__label">
                <span class="upsert__label-text">Name:</span>
                <form:input cssClass="upsert__input" path="name" type="text" placeholder="Name" />
            </label>
            <label class="upsert__label">
                <span class="upsert__label-text">Surname:</span>
                <form:input cssClass="upsert__input" path="surname" type="text" placeholder="Surname" />
            </label>
            <label class="upsert__label">
                <span class="upsert__label-text">Country:</span>
                <form:input cssClass="upsert__input" path="country" type="text" placeholder="Country" />
            </label>
            <label class="upsert__label">
                <span class="upsert__label-text">Birth Date:</span>
                <form:input cssClass="upsert__input" path="birthDate" type="date" placeholder="Birth Date" />
            </label>
            <div class="upsert__buttons-container">
                <input class="link-as-button" type="submit" value="Save">
                <a href="<c:url value="/"/>" class="link-as-button">Cancel</a>
            </div>
        </fieldset>
    </form:form>
</tmpl:main>

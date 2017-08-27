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
            <label class="upsert__label">
                <span class="upsert__label-text">Marital Status:</span>
                <form:select cssClass="upsert__input" path="maritalStatus.maritalStatusId" items="${maritalStatusList}" itemValue="maritalStatusId" itemLabel="status" />
            </label>

            <fieldset class="upsert__skills">
                <legend>Skills</legend>
                <label>
                    <span>Skills to add:</span>
                    <select id="skills-to-add">
                        <c:forEach var="skill" items="${skills}">
                            <option value="${skill.skillId}-${skill.name}">${skill.name}</option>
                        </c:forEach>
                    </select>
                </label>
                <button type="button" class="link-as-button" onclick="addSkill()">Add</button>
                <div id="skills-container" class="upsert__skills-container"></div>
                <form:input path="skills" type="hidden" />
            </fieldset>

            <div class="upsert__buttons-container">
                <input onclick="submitForm()" class="link-as-button" type="button" value="Save">
                <a href="<c:url value="/"/>" class="link-as-button">Cancel</a>
            </div>
        </fieldset>
    </form:form>
    <script type="text/javascript">
      window.initialSkills = ${employeeSkills};
    </script>
    <c:url var="upsertJsUrl" value="/static/js/upsert.js"/>
    <script src="${upsertJsUrl}" type="text/javascript"></script>
</tmpl:main>

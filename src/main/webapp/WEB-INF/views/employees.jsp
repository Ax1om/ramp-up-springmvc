<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tmpl" tagdir="/WEB-INF/tags/templates" %>

<%--@elvariable id="employees" type="java.util.List"--%>

<tmpl:main>
    <script type="text/javascript">
      function deleteEmployee(employeeId, employeeName) {
        if (confirm("Are you sure you want to delete " + employeeName + "?")) {
          location.href = "${pageContext.request.contextPath}/delete?employeeId=" + employeeId;
        }
      }
    </script>
    <table class="table">
        <caption class="table__caption">
            <span>Employees</span>
            <c:url var="insertUrl" value="/upsert"/>
            <a href="${insertUrl}" class="table__new-employee-btn link-as-button">New Employee</a>
        </caption>
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Country</th>
            <th>Birth Date</th>
            <th>Marital Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.country}</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${employee.birthDate}"/></td>
                <td>${employee.maritalStatus.status}</td>
                <td>
                    <c:url var="updateUrl" value="/upsert">
                        <c:param name="employeeId" value="${employee.employeeId}"/>
                    </c:url>
                    <span>
                        <a href="${updateUrl}" class="link-as-button">Edit</a>
                    </span>
                    <span>
                        <button onclick="deleteEmployee(${employee.employeeId}, '${employee.name}')" class="link-as-button">
                            Delete
                        </button>
                    </span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</tmpl:main>
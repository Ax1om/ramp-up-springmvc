<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="userNotification" type="java.lang.String"--%>
<html>
    <head>
        <title>Employees CRUD</title>
        <c:url var="mainCssUrl" value='/static/css/main.css' />
        <link type="text/css" rel="stylesheet" href="${mainCssUrl}" >
        <c:if test="${not empty userNotification}">
            <script type="text/javascript">
              window.notification = ${userNotification};
            </script>
            <c:remove var="userNotification" scope="session" />
        </c:if>
    </head>
    <body>
        <div class="container">
            <jsp:doBody />
        </div>
        <div id="notification-area" class="notification-area"></div>
        <script type="text/javascript" src="<c:url value='/static/js/notifications.js' />"></script>
    </body>
</html>
